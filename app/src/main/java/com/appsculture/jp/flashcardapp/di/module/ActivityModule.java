package com.appsculture.jp.flashcardapp.di.module;

import com.appsculture.jp.flashcardapp.activities.CreateListActivity;
import com.appsculture.jp.flashcardapp.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule
{
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract CreateListActivity contributeCreateListActivity();

}