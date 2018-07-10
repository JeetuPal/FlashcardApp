package com.appsculture.jp.flashcardapp.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.appsculture.jp.flashcardapp.di.key.ViewModelKey;
import com.appsculture.jp.flashcardapp.view_models.FactoryViewModel;
import com.appsculture.jp.flashcardapp.view_models.ListItemViewModel;
import com.appsculture.jp.flashcardapp.view_models.UserProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule
{

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel.class)
    abstract ViewModel bindUserProfileViewModel(UserProfileViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);

    @Binds
    @IntoMap
    @ViewModelKey(ListItemViewModel.class)
    abstract ViewModel bindListItemViewModel(ListItemViewModel repoViewModel);
}