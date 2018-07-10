package com.appsculture.jp.flashcardapp.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.appsculture.jp.flashcardapp.database.converter.DateConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Create the User entity, representing a Github user, that will be persisted (via Room) and get from Github Api (via Retrofit).
 */
@Entity
public class User
{
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("blog")
    @Expose
    private String blog;

    private Date lastRefresh;

    public User(@NonNull String id, String login, String avatar_url, String name, String company, String blog, Date lastRefresh)
    {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.lastRefresh = lastRefresh;
    }

    // -- Getter
    @NonNull
    public String getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getAvatar_url()
    {
        return avatar_url;
    }

    public String getName()
    {
        return name;
    }

    public String getCompany()
    {
        return company;
    }

    public String getBlog()
    {
        return blog;
    }

    public Date getLastRefresh()
    {
        return lastRefresh;
    }

    // --- setter

    public void setId(@NonNull String id)
    {
        this.id = id;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setAvatar_url(String avatar_url)
    {
        this.avatar_url = avatar_url;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public void setBlog(String blog)
    {
        this.blog = blog;
    }

    public void setLastRefresh(Date lastRefresh)
    {
        this.lastRefresh = lastRefresh;
    }
}
