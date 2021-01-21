package com.adib.foodwhiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    EditText  eEmailAddress,  ePassword;
    FirebaseAuth FAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        eEmailAddress = findViewById(R.id.eEmailAddress);
        ePassword = findViewById(R.id.ePassword);

        FAuth = FirebaseAuth.getInstance();

    }

    public void signUp(View view) {
        Intent reg = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(reg);
        finish();
    }

    public void forgotPassword(View view) {
    }

    public void logIn(View view) {
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = eEmailAddress.getText().toString().trim();
        if(TextUtils.isEmpty(email)) {
            eEmailAddress.setError("Enter email");
            return;
        }

        if(!email.matches(emailpattern)) {
            eEmailAddress.setError("invalid email");
            return;
        }


        final String password =  ePassword.getText().toString().trim();
        if(TextUtils.isEmpty(password)) {
            ePassword.setError("Enter password");
            return;
        }
        if(password.length()<8){
            ePassword.setError("Password is Weak");
        }

        //user authentication

            FAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {

                        Toast.makeText(LogInActivity.this, "Logged in successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));





                    }
                    else {
                        Toast.makeText(LogInActivity.this, "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

                    }

                }
            });





    }
}