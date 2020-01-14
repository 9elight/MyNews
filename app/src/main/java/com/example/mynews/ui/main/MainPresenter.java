package com.example.mynews.ui.main;

import com.example.mynews.data.RetrofitBuilder;
import com.example.mynews.data.entity.Article;
import com.example.mynews.data.entity.Example;

import java.util.List;

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

        RetrofitBuilder.getNewsService().getNews("ru",API_KEY)
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        List<Article> newsList = response.body().getArticles();
                        if (newsList.size() < 1) {
                            mView.rv_builder(newsList);
                        }else {

                        }
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        mView.toast(t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void getNewsQword(String qWord) {
        RetrofitBuilder.getNewsService().getNewsQword(qWord,"ru",API_KEY)
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        List<Article> newsList = response.body().getArticles();
                        mView.rv_builder(newsList);
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        mView.toast(t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void unbind() {
        mView = null;
    }
}
