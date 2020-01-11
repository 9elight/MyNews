package com.example.mynews.ui.main;



import com.example.mynews.Lifecycles;
import com.example.mynews.data.entity.Article;

import java.util.ArrayList;

public interface MainContract {

    interface View{
        void rv_builder(ArrayList<Article> list);

        void toast(String localizedMessage);
    }
    interface Presenter extends Lifecycles<View> {
        void getNews();
    }
}
