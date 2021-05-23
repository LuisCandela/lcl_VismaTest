package com.lcl.visma.work.ui.weather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lcl.visma.work.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WeatherFragment.newInstance())
                    .commitNow();
        }
    }
}