package com.appsculture.jp.flashcardapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.appsculture.jp.flashcardapp.database.entity.User;
import com.appsculture.jp.flashcardapp.repositories.UserRepository;

import javax.inject.Inject;

/**
 * A ViewModel provides the data for a specific UI component, such as a fragment or activity, and handles the communication with the business part of data handling,
 * such as calling other components to load the data or forwarding user modifications.
 * The ViewModel does not know about the View and is not affected by configuration changes such as recreating an activity due to rotation.
 */
public class UserProfileViewModel extends ViewModel
{
    private LiveData<User> userLiveData;
    private UserRepository userRepository;

    @Inject
    public UserProfileViewModel(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //----
    public void init(String userId)
    {
        if (userLiveData != null)
        {
            return;
        }
        userLiveData = userRepository.getUser(userId);
    }

    public LiveData<User> getUserLiveData()
    {
        return this.userLiveData;
    }
}
