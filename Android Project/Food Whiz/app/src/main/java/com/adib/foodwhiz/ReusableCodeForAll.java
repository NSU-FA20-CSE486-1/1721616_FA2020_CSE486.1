/*package com.adib.foodwhiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;



public class ReusableCodeForAll {
    public static void ShowAlert(SignUpActivity signUpActivity, String error, String message) {
        Context context = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(null);
        builder.setCancelable(false);
        char d = 0;
        char tittle = d;
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setTitle(tittle).setMessage(message).show();

    }
}
*/