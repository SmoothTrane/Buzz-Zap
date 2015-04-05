package com.example.garycoltrane.buzzzap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.util.Log;
import android.widget.Toast;

import java.sql.Time;


public class timerActivity extends ActionBarActivity {
    private static final String TAG = "timerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        getSupportActionBar().hide();


        TimePicker tp = (TimePicker) findViewById(R.id.timePicker);

        Toast.makeText(getApplicationContext(), String.valueOf(tp.getCurrentHour()),
                Toast.LENGTH_LONG).show();




    }





}
