package com.appsculture.jp.flashcardapp.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsculture.jp.flashcardapp.R;
import com.appsculture.jp.flashcardapp.view_models.ListItemViewModel;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class ListViewFragment extends Fragment
{
    public static final String LIST_ID_KEY = "list_id_key";
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private ListItemViewModel viewModel;

    public ListViewFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();
    }

    private void configureViewModel()
    {
        String userLogin = getArguments().getString(LIST_ID_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListItemViewModel.class);
    }

    private void configureDagger()
    {
        AndroidSupportInjection.inject(this);
    }
}
