package com.appsculture.jp.flashcardapp.di.module;

import com.appsculture.jp.flashcardapp.fragments.ListViewFragment;
import com.appsculture.jp.flashcardapp.fragments.UserProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule
{
    @ContributesAndroidInjector
    abstract UserProfileFragment contributeUserProfileFragment();

    @ContributesAndroidInjector
    abstract ListViewFragment contributeListViewFragment();

}