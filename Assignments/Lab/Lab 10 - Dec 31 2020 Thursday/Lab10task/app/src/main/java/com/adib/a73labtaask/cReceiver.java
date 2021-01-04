package com.adib.a73labtaask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class cReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction != null){
            Toast.makeText(context, "Headset plugged or unplugged", Toast.LENGTH_LONG).show();
        }

    }
}
