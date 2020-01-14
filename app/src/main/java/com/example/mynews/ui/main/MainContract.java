package com.example.mynews.ui.main;



import com.example.mynews.Lifecycles;
import com.example.mynews.data.entity.Article;

import java.util.List;

public interface MainContract {

    interface View{
        void rv_builder(List<Article> list);

        void toast(String localizedMessage);
    }
    interface Presenter extends Lifecycles<View> {
        void getNews();
        void getNewsQword(String qWord);
    }
}
