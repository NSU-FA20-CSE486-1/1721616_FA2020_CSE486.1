package com.adib.foodwhiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DialogFragment;
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
import android.widget.Toast;

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
        FAuth = FirebaseAuth.getInstance();
/*
        if(FAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), LogInActivity.class));
            finish();


        }

*/

    }
    public void register(View view) {
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String name = eName.getText().toString().trim();

        if(TextUtils.isEmpty(name)) {
            eName.setError("Enter your name");
            return;
        }

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


        String cpassword =  eConfirmPassword.getText().toString().trim();
        if(TextUtils.isEmpty(cpassword)) {
            eConfirmPassword.setError("Enter password");
            return;
        }
        if(!password.equals(cpassword)){
            eConfirmPassword.setError("Password is not matched try again");
            return;
        }

        String phone =  ePhone.getText().toString().trim();
        if(TextUtils.isEmpty(phone)) {
            ePhone.setError("Enter phone number");
            return;
        }
        if(phone.length()<10){
            ePhone.setError("please enter proper phone number");
        }
        if(phone.length()>10){
            ePhone.setError("please enter proper phone number");
        }




        //firebase
        FAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

               /**
                    String useridd = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference("User").child(useridd);
                                final HashMap<String , String> hashMap = new HashMap<>();
                                hashMap.put("Role",role);
                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        HashMap<String , String> hashMap1 = new HashMap<>();
                                        hashMap1.put("Mobile No",phone);

                                        hashMap1.put("EmailId",email);
                                        hashMap1.put("Password",password);

                                        hashMap1.put("Confirm Password",cpassword);
                                        hashMap1.put("Name",name);

                                        firebaseDatabase.getInstance().getReference("Chef")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {


                                                FAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {

                                                        if(task.isSuccessful()){
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                                                            builder.setMessage("You Have Registered! Make Sure To Verify Your Email");
                                                            builder.setCancelable(false);
                                                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {

                                                                    dialog.dismiss();

                                                                }
                                                            });
                                                            AlertDialog Alert = builder.create();
                                                            Alert.show();
                                                        }
                                                    }
                                                });

                                            }
                                        });

                                    }
                                });
                            }



                     */








                    Toast.makeText(SignUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));





                }
                else {
                    Toast.makeText(SignUpActivity.this, "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

                }



              }


        });

    }

    public void alreadyHaveAccount(View view) {
        Intent dsp = new Intent(SignUpActivity.this,LogInActivity.class);
        startActivity(dsp);
        finish();
    }


}