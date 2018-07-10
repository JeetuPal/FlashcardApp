package com.appsculture.jp.flashcardapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.appsculture.jp.flashcardapp.R;
import com.appsculture.jp.flashcardapp.fragments.UserProfileFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector
{
    private static final String USER_LOGIN = "JakeWharton";
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureDagger();
        this.showFragment(savedInstanceState);
    }

    private void configureDagger()
    {
        AndroidInjection.inject(this);
    }

    private void showFragment(Bundle savedInstanceState)
    {
        UserProfileFragment fragment = new UserProfileFragment();

        Bundle bundle = new Bundle();
        bundle.putString(UserProfileFragment.UID_KEY, USER_LOGIN);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment, null)
                .commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector()
    {
        return dispatchingAndroidInjector;
    }
}
