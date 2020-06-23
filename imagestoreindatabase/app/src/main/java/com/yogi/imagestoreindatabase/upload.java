package com.yogi.imagestoreindatabase;

import android.net.Uri;

import com.google.android.gms.tasks.Task;

public class upload
{
    String name,url;

    public Task<Uri> getData() {
        return data;
    }

    public void setData(Task<Uri> data) {
        this.data = data;
    }

    Task<Uri> data;

    public upload() {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
