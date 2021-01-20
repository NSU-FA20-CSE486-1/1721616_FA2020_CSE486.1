package com.adib.foodwhiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    EditText eName, eEmailAddress, ePhone,  ePassword, eConfirmPassword;

    Spinner Statespin,Cityspin;

    CountryCodePicker Cpp;
    FirebaseAuth FAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String ename, eemailaddress, ephone,  epassword, econfirmpassword;
    String role="Chef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        eName = (EditText) findViewById(R.id.eName);
        eEmailAddress = (EditText) findViewById(R.id.eEmailAddress);
        ePhone = (EditText) findViewById(R.id.ePhone);
        ePassword = (EditText) findViewById(R.id.ePassword);
        eConfirmPassword = (EditText) findViewById(R.id.eConfirmPassword);


    }
    public void register(View view) {
        String email = eEmailAddress.getText().toString().trim();
        if(TextUtils.isEmpty(email)) {
            eEmailAddress.setError("Enter email");
        }

    }


    public void alreadyHaveAccount(View view) {
        Intent dsp = new Intent(SignUpActivity.this,LogInActivity.class);
        startActivity(dsp);
        finish();
    }


}