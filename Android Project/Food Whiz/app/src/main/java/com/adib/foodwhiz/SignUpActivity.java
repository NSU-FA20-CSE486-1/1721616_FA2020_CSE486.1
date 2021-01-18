package com.adib.foodwhiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void alreadyHaveAccount(View view) {
        Intent dsp = new Intent(SignUpActivity.this,LogInActivity.class);
        startActivity(dsp);
        finish();
    }
}