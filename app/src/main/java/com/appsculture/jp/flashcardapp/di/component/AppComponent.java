package com.appsculture.jp.flashcardapp.di.component;

import android.app.Application;

import com.appsculture.jp.flashcardapp.App;
import com.appsculture.jp.flashcardapp.di.module.FragmentModule;
import com.appsculture.jp.flashcardapp.di.module.ActivityModule;
import com.appsculture.jp.flashcardapp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(App app);
}