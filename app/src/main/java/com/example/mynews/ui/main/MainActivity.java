package com.example.mynews.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mynews.R;

import com.example.mynews.data.entity.Article;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setSupportActionBar(toolbar);
        mPresenter = new MainPresenter();
        mPresenter.bind(this);
        progressBar.setVisibility(View.VISIBLE);
        mPresenter.getNews();
        progressBar.setVisibility(View.GONE);
    }
    private void initViews(){
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);

    }



    public void rv_builder(ArrayList<Article> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this
                , RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RV_Adapter adapter = new RV_Adapter();
        recyclerView.setAdapter(adapter);
        adapter.updateNews(list);
    }

    @Override
    public void toast(String localizedMessage) {
        Toast.makeText(this,localizedMessage,Toast.LENGTH_LONG).show();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

}
