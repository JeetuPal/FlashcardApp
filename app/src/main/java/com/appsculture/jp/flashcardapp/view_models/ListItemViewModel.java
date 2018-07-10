package com.appsculture.jp.flashcardapp.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.appsculture.jp.flashcardapp.database.entity.ListItem;
import com.appsculture.jp.flashcardapp.repositories.ListItemRepository;

import java.util.List;

import javax.inject.Inject;

public class ListItemViewModel extends ViewModel
{
    private ListItemRepository repository;

    @Inject
    public ListItemViewModel(ListItemRepository listItemRepository)
    {
        this.repository = listItemRepository;
    }

    //-----

    public LiveData<List<ListItem>> getListItems()
    {
        return repository.getListItem();
    }

    public void deleteListItem(ListItem listItem)
    {
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(listItem);
    }

    // ------
    private class DeleteItemTask extends AsyncTask<ListItem, Void, Void>
    {
        @Override
        protected Void doInBackground(ListItem... listItems)
        {
            repository.deleteListItem(listItems[0]);
            return null;
        }
    }
}
