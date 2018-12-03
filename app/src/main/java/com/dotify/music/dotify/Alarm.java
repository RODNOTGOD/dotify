package com.dotify.music.dotify;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_builder);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Button deleteAlarmBtn = findViewById(R.id.delete_alarm);
        deleteAlarmBtn.setOnClickListener((v) -> deleteAlarm());
    }

    @Override
    public void onBackPressed() {
        saveAndSetAlarm();
        super.onBackPressed();
    }

    private void saveAndSetAlarm() {
        TimePicker alarmTimePicker = findViewById(R.id.timePicker);
        int hour = alarmTimePicker.getCurrentHour();
        int minute = alarmTimePicker.getCurrentMinute();
        saveAlarm(hour, minute);
        setAlarm(hour, minute);
    }

    private void saveAlarm(int hour, int minute) {
    }

    private void setAlarm(int hour, int minute) {
        ToggleButton button = findViewById(R.id.set_alarm);
        if (button.isChecked()) {
            long time;
            Toast toast = Toast.makeText(this, "Alarm set", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 400);
            toast.show();

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time)
            {
                if (calendar.AM_PM == 0)
                    time = time + (1000*60*60*12);
                else
                    time = time + (1000*60*60*24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);

        }
    }

    private void deleteAlarm() {
        finish();
    }
}
