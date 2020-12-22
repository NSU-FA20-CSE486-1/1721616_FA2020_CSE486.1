package com.adib.mid_sms_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static android.media.MediaCodec.MetricsConstants.MODE;

public class MainActivity extends AppCompatActivity {
    private static final String ALGORITHM = "Blowfish";
    private static final String MODE = "Blowfish/CBC/PKCS5Padding";
    private static final String IV = "abcdefgh";
    private static String KEY;

    EditText txt_ekey, txt_sms;
    String encrypted_sms;
    String AES = "AES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_ekey = (EditText)findViewById(R.id.input_ekey);
        txt_sms = (EditText)findViewById(R.id.input_sms);
    }

    public void btn_send(View view) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        String ekey = txt_ekey.getText().toString();
        String sms = txt_sms.getText().toString();
            KEY = ekey;
            encrypted_sms = encrypt(sms);
     //   sms = encrypted_sms;
        // sms = sms+ekey;
     //   String enc_sms = ekey +" "+ sms;
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("e_key",ekey);
        intent.putExtra("e_sms",encrypted_sms);

        startActivity(intent);
    }
    public static  String encrypt(String value ) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(MODE);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(IV.getBytes()));
        byte[] values = cipher.doFinal(value.getBytes());
        return Base64.encodeToString(values, Base64.DEFAULT);
    }
/*
    private String encrypt(String sms, String ekey) throws Exception  {
        SecretKeySpec key = generateKey(ekey);
        Cipher cy = Cipher.getInstance(AES);
        cy.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal = cy.doFinal(sms.getBytes());
        String encryptedValue = Base64.encodeToString(encVal,Base64.DEFAULT);
        return encryptedValue;
    }

    private SecretKeySpec generateKey(String ekey) throws Exception{

        final MessageDigest digest= MessageDigest.getInstance("SHA-265");
        byte[] bytes = ekey.getBytes("UTF-8");
        digest.update(bytes, 0 ,bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key,"AES");
        return secretKeySpec;
    }
*/

}