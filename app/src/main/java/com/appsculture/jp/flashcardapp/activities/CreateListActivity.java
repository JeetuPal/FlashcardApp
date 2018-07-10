package com.appsculture.jp.flashcardapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appsculture.jp.flashcardapp.R;
import com.appsculture.jp.flashcardapp.fragments.ListViewFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class CreateListActivity extends AppCompatActivity implements HasSupportFragmentInjector
{

    private static final String LIST_ID_VALUE = "1";
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        this.configureDagger();
        this.showFragment(savedInstanceState);
    }

    private void showFragment(Bundle savedInstanceState)
    {

        ListViewFragment fragment = new ListViewFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ListViewFragment.LIST_ID_KEY, LIST_ID_VALUE);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment, null)
                .commit();
    }

    private void configureDagger()
    {
        AndroidInjection.inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector()
    {
        return dispatchingAndroidInjector;
    }
}
