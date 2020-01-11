package com.example.mynews.ui.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mynews.R;
import com.example.mynews.data.entity.Article;


public class RV_view_holder extends RecyclerView.ViewHolder {
    private ImageView news_img;
    private TextView news_title;
    private TextView news_description;
    private OnItemClickListener listener;
    private int position;

    public RV_view_holder(@NonNull View itemView) {
        super(itemView);
        initViews();
        itemView.setOnClickListener(v -> listener.onClickItem(position));
    }



    private void initViews() {
        news_img = itemView.findViewById(R.id.img_news);
        news_title = itemView.findViewById(R.id.title_news);
        news_description = itemView.findViewById(R.id.description_news);
    }

    public void onBind(Article article,int position) {
        Glide.with(itemView.getContext()).load(article.getUrlToImage()).fitCenter()
                .into(news_img);
        news_title.setText(article.getTitle());
        news_description.setText(article.getDescription());
        this.position = position;
    }
    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
