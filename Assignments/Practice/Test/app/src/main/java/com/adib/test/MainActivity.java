package com.adib.test;


import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button signOut;
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //sets layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* text = findViewById(R.id.textView);
        signOut = findViewById(R.id.signOut);




        pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, this.getClass())
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);


        //sign out button
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
*/
    }



    //function that continuously checks if NFC tag is detected. Moves to new activity when detected



}


