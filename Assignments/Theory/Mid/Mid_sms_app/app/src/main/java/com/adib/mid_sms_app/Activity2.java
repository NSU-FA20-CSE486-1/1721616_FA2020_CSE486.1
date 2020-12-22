package com.adib.mid_sms_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Activity2 extends AppCompatActivity {
    TextView enc_sms;
    TextView output_txt;
    private static final String ALGORITHM = "Blowfish";
    private static final String MODE = "Blowfish/CBC/PKCS5Padding";
    private static final String IV = "abcdefgh";
    private static String KEY;
    String output;
    String sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        enc_sms = (TextView) findViewById(R.id.show_sms);
        output_txt = (TextView) findViewById(R.id.decrypted_txt);

        String ekey = getIntent().getStringExtra("e_key");
        KEY = ekey;
        sms = getIntent().getStringExtra("e_sms");
        String total_sms = ekey + " " + sms;
        enc_sms.setText(total_sms);


    }

    public void btn_decrypt(View view) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
            output = decrypt(sms);
            output_txt.setText(output);

    }
    public static  String decrypt(String value) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IllegalBlockSizeException {
        byte[] values = Base64.decode(value, Base64.DEFAULT);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(IV.getBytes()));
        return new String(cipher.doFinal(values));
    }
}