package com.example.mynews.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.R;
import com.example.mynews.data.entity.Article;
import com.example.mynews.ui.webview.WebViewActivity;


import java.util.ArrayList;
import java.util.List;


public class RV_Adapter extends RecyclerView.Adapter<RV_view_holder> implements OnItemClickListener{
    private List<Article> list;
    private Context context;
    public RV_Adapter() {

    }

    public void updateNews(List<Article> list){
        this.list = list;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public RV_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_view_holder,parent,false);
        RV_view_holder view_holder = new RV_view_holder(view);
        view_holder.setOnClickListener(this);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RV_view_holder holder, int position) {
        holder.onBind(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClickItem(int position) {
        Toast.makeText(context,"My position " + position,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context,WebViewActivity.class);
        intent.putExtra("url",list.get(position).getUrl());
        context.startActivity(intent);

    }
}
