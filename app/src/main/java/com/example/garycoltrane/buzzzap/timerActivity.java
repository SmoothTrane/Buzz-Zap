package com.example.garycoltrane.buzzzap;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.util.Log;
import android.widget.Toast;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Time;


public class timerActivity extends ActionBarActivity {


public timerAlarm timr = new timerAlarm (this, this);
    private static final String TAG = "timerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        getSupportActionBar().hide();

       final Button btn = (Button) findViewById(R.id.buzzTime);


        btn.setOnClickListener(new View.OnClickListener() {

       public void onClick(View v) {
timr.receiveMinInput();
           timr.receiveSecInput();
           timr.setup();
     timr.am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + timr.alarmDomain * 60000, timr.pi);

            }
                   });










        final Button cancelIt = (Button) findViewById(R.id.cancel);

        cancelIt.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                timr.am.cancel(timr.pi);

            }






        });


    }








}
