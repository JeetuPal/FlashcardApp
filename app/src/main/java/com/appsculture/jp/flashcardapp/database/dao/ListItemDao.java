package com.appsculture.jp.flashcardapp.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.appsculture.jp.flashcardapp.database.entity.ListItem;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ListItemDao
{
    @Query("SELECT * FROM ListItem")
    LiveData<List<ListItem>> getListItems();

    @Query("SELECT * FROM ListItem WHERE itemId = :itemId")
    LiveData<ListItem> getListItemById(String itemId);

    @Delete()
    void deleteListItem(ListItem listItem);

    @Insert(onConflict = REPLACE)
    void insertListItem(ListItem tempListItem);
}
