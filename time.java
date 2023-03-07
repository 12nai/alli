package com.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (EditText) findViewById(R.id.time);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTIME = Calendar.getInstance();
                int hour = currentTIME.get(Calendar.HOUR_OF_DAY);
                int minute = currentTIME.get(Calendar.MINUTE);
                //int seconds = currentTIME.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    time.setText(hour+":"+minute);
                    }
                },hour,minute,true);
                timePickerDialog.setTitle("Selected time : ");
                timePickerDialog.show();
            }
        });
    }

}