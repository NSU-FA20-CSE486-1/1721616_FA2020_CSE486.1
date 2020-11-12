package com.adib.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eEmailAddress, ePassword;
    private TextView forgotPassword;
    private Button btnSignin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eEmailAddress = (EditText) findViewById(R.id.eEmailAddress);
        ePassword = (EditText) findViewById(R.id.ePassword);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        btnSignin = (Button)  findViewById(R.id.btnSignin);




    }
    public void signIn(View view) {
        if(eEmailAddress .getText().toString().equals("adib") &&
                ePassword.getText().toString().equals("123456")) {
          /*  Toast.makeText(getApplicationContext(), "Welcome to our world!",Toast.LENGTH_SHORT).show();*/

            Intent intent = new Intent(MainActivity.this, Welcome.class);
            startActivity(intent);
            finish();


        }else{
            Toast.makeText(getApplicationContext(), "Wrong  Credentials",Toast.LENGTH_SHORT).show();


        }


    }
    public void forgotPassword(View view) {

        Toast.makeText(getApplicationContext(), "This feature is not available",Toast.LENGTH_SHORT).show();

    }
}