package com.appsculture.jp.flashcardapp.repositories;

import android.arch.lifecycle.LiveData;

import com.appsculture.jp.flashcardapp.database.dao.ListItemDao;
import com.appsculture.jp.flashcardapp.database.entity.ListItem;

import java.util.List;

import javax.inject.Inject;

public class ListItemRepository
{
    private final ListItemDao listItemDao;

    @Inject
    public ListItemRepository(ListItemDao listItemDao)
    {
        this.listItemDao = listItemDao;
    }

    // --------
    public LiveData<List<ListItem>> getListItem()
    {
        return listItemDao.getListItems();
    }


    public LiveData<ListItem> getListItemData(String itemId)
    {
        return listItemDao.getListItemById(itemId);
    }

    public void deleteListItem(ListItem listItem)
    {
        listItemDao.deleteListItem(listItem);
    }

    public void insertListItem(ListItem listItem)
    {
        listItemDao.insertListItem(listItem);
    }


}
