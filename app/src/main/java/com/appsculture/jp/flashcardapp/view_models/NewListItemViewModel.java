package com.appsculture.jp.flashcardapp.view_models;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.appsculture.jp.flashcardapp.database.entity.ListItem;
import com.appsculture.jp.flashcardapp.repositories.ListItemRepository;

public class NewListItemViewModel extends ViewModel
{
    private ListItemRepository repository;

    public NewListItemViewModel(ListItemRepository repository)
    {
        this.repository = repository;
    }

    //----
    public void addNewItemToDataBase(ListItem listItem)
    {
        AddItemTask addItemTask = new AddItemTask();
        addItemTask.execute();
    }

    public class AddItemTask extends AsyncTask<ListItem, Void, Void>
    {

        @Override
        protected Void doInBackground(ListItem... listItems)
        {
            repository.insertListItem(listItems[0]);
            return null;
        }
    }
}
