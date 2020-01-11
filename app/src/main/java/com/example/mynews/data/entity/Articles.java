package com.example.mynews.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Articles {
    @SerializedName("articles")
    @Expose
    private ArrayList<Article> list;

    public ArrayList<Article> getList() {
        return list;
    }
}
