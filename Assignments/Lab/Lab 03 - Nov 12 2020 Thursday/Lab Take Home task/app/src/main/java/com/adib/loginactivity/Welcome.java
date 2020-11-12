package com.adib.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnBack = (Button)  findViewById(R.id.btnBack);
    }
    public void btnBack(View view) {
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(Welcome.this, "Sign out succesfull", Toast.LENGTH_SHORT).show();
        finish();




    }

}
