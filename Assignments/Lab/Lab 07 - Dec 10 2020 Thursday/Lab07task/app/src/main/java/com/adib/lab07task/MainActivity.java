package com.adib.lab07task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String fullText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
    }

    public void showTimeClock(View view) {
        DialogFragment fragment = new TimePicker();
        fragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    public void processTimePickerResult(int hour, int minute){
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String time_message = hour_string + ":" + minute_string;
        textView.setText("Your selected time: "+time_message);
        fullText = time_message;
        Toast.makeText(getApplicationContext(), "Time: " + time_message, Toast.LENGTH_SHORT).show();
    }

    public void showDateCalender(View view) {
        DialogFragment fragment = new DatePicker();
        fragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth){
        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(dayOfMonth);
        String date_message = day_string + "/" + month_string + "/" + year_string;
        textView.setText("Your selected date: "+date_message);
        fullText = fullText + " & " + date_message;
        Toast.makeText(getApplicationContext(), "Date: " + date_message, Toast.LENGTH_SHORT).show();
    }



    public void showAll(View view) {
        textView.setText("Your selected time and date: \n     " +fullText);

    }

}