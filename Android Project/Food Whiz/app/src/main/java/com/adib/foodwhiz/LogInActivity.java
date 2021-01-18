package com.adib.foodwhiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void signUp(View view) {
        Intent reg = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(reg);
        finish();
    }

    public void forgotPassword(View view) {
    }
}