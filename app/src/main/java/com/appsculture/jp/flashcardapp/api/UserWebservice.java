package com.appsculture.jp.flashcardapp.api;

import com.appsculture.jp.flashcardapp.database.entity.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *  User object will be used both by Retrofit and Room. So now, we only have to create a Retrofit interface.
 *  API : https://api.github.com/users/JakeWharton
 */
public interface UserWebservice
{
    @GET("/users/{user}")
    Call<User> getUser(@Path("user") String userId);
}
