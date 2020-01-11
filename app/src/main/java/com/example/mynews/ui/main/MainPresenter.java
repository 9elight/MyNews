package com.example.mynews.ui.main;

import android.util.Log;
import android.widget.Toast;

import com.example.mynews.data.RetrofitBuilder;
import com.example.mynews.data.entity.Article;
import com.example.mynews.data.entity.Articles;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mynews.BuildConfig.API_KEY;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    @Override
    public void bind(MainContract.View view) {
        mView = view;
    }

    @Override
    public void getNews() {
        RetrofitBuilder.getNewsService().getNews2("ru",API_KEY)
                .enqueue(new Callback<Articles>() {
                    @Override
                    public void onResponse(Call<Articles> call, Response<Articles> response) {
                        ArrayList<Article> newsList = response.body().getList();
                        mView.rv_builder(newsList);
                        
                    }

                    @Override
                    public void onFailure(Call<Articles> call, Throwable t) {
                        mView.toast(t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
