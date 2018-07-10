package com.appsculture.jp.flashcardapp.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.appsculture.jp.flashcardapp.api.UserWebservice;
import com.appsculture.jp.flashcardapp.database.MyDatabase;
import com.appsculture.jp.flashcardapp.database.dao.ListItemDao;
import com.appsculture.jp.flashcardapp.database.dao.UserDao;
import com.appsculture.jp.flashcardapp.repositories.ListItemRepository;
import com.appsculture.jp.flashcardapp.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule
{

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application)
    {
        return Room.databaseBuilder(application,
                MyDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(MyDatabase database)
    {
        return database.userDao();
    }

    // -- ListItemInjection
    @Provides
    @Singleton
    ListItemDao provideListItemDao(MyDatabase database)
    {
        return database.listItemDao();
    }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor()
    {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserWebservice webservice, UserDao userDao, Executor executor)
    {
        return new UserRepository(webservice, userDao, executor);
    }

    // -- ListItemInjection
    @Provides
    @Singleton
    ListItemRepository provideListItemRepository(ListItemDao listItemDao, Executor executor)
    {
        return new ListItemRepository(listItemDao);
    }

    // --- NETWORK INJECTION ---

    private static String BASE_URL = "https://api.github.com/";

    @Provides
    Gson provideGson()
    {
        return new GsonBuilder().create();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    UserWebservice provideApiWebservice(Retrofit restAdapter)
    {
        return restAdapter.create(UserWebservice.class);
    }
}