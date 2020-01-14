package com.example.mynews.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mynews.R;

import com.example.mynews.data.entity.Article;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainContract.Presenter mPresenter;
    private Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar);

    }
    public void rv_builder(List<Article> list) {
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.popular:
                mPresenter.getNews();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter.getNewsQword(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        return true;
    }



}
