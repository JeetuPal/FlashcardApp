package com.appsculture.jp.flashcardapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.appsculture.jp.flashcardapp.database.converter.DateConverter;
import com.appsculture.jp.flashcardapp.database.dao.ListItemDao;
import com.appsculture.jp.flashcardapp.database.dao.UserDao;
import com.appsculture.jp.flashcardapp.database.entity.ListItem;
import com.appsculture.jp.flashcardapp.database.entity.User;

/**
 * Finally, we create the database object.
 */
@Database(entities = {User.class, ListItem.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase
{
    // ---- Singleton
    public static volatile MyDatabase instance;

    // ----- Dao
    public abstract UserDao userDao();

    public abstract ListItemDao listItemDao();
}
