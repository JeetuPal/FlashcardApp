package com.appsculture.jp.flashcardapp.repositories;

import android.arch.lifecycle.LiveData;
import android.util.Log;
import android.widget.Toast;

import com.appsculture.jp.flashcardapp.App;
import com.appsculture.jp.flashcardapp.api.UserWebservice;
import com.appsculture.jp.flashcardapp.database.dao.UserDao;
import com.appsculture.jp.flashcardapp.database.entity.User;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/***
 * User object will be used both by Retrofit and Room. So now, we only have to create a Retrofit interface :
 */
public class UserRepository
{
    public static int FRESH_TIMEOUT_IN_MINUTES = 3;

    private static UserWebservice userWebservice;
    private static UserDao userDao;
    private static Executor executor;

    @Inject
    public UserRepository(UserWebservice userWebservice, UserDao userDao, Executor executor)
    {

        this.userWebservice = userWebservice;
        this.userDao = userDao;
        this.executor = executor;
    }

    //--
    public LiveData<User> getUser(String userLogin)
    {
        refreshUser(userLogin);
        return userDao.load(userLogin);
    }

    private void refreshUser(final String userLogin)
    {
        executor.execute(() -> {
            // check if user fetched recently
            boolean userExists = (userDao.hasUser(userLogin, getMaxRefreshTime(new Date())) != null);

            // if user have to be updated
            if (!userExists)
            {
                userWebservice.getUser(userLogin).enqueue(new Callback<User>()
                {
                    @Override
                    public void onResponse(Call<User> call, final Response<User> response)
                    {
                        Log.e("TAG", "DATA REFRESHED FROM NETWORK");
                        Toast.makeText(App.context, "Data refreshed from network !", Toast.LENGTH_LONG).show();
                        executor.execute(() -> {
                            User user = response.body();
                            user.setLastRefresh(new Date());
                            userDao.saveUser(user);
                        });
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t)
                    {
                        // do nothing
                    }
                });
            }
        });
    }

    private Date getMaxRefreshTime(Date currentDate)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MINUTE, -FRESH_TIMEOUT_IN_MINUTES);
        return calendar.getTime();
    }
}
