package com.example.mynews.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mynews.R;
import com.example.mynews.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        MainActivity.start(this);

    }

}
