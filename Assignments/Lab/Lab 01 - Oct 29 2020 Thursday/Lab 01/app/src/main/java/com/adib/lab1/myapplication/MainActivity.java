package com.adib.lab1.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "Happy Birthday");
        Log.e("MainActivity", "Forgot the date");
        setContentView(R.layout.activity_main);
    }
}