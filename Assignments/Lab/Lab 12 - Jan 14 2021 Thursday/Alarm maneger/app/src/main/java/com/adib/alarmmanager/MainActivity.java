package com.adib.alarmmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private AlarmManager nextAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void nextAlarmView(View view) {
        AlarmManager.AlarmClockInfo info = nextAlarm.getNextAlarmClock();
        String message;
        if (info != null){
            Date nextAlarm = new Date(info.getTriggerTime());
            String newDate = DateFormat.getTimeInstance().format(nextAlarm);
            message = "Next alarm set at " + newDate + ".";
        }
        else{
            message = "There is no alarm set";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}