package com.appsculture.jp.flashcardapp.database.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;


/**
 *  Because Room can’t persist Date object, we have to create a TypeConverter
 */
public class DateConverter
{
    @TypeConverter
    public static Date toDate(Long timestamp)
    {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimeStamp(Date date){

        return date == null ? null : date.getTime();
    }
}
