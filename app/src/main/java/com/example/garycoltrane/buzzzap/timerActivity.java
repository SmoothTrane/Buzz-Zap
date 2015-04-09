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
    AlarmManager am;
    PendingIntent pi;
    BroadcastReceiver br;
    long alarmDomain;
    int inDomain;
    String inputGrab;
    String inputTake;
    public vibrateCall vibe = new vibrateCall(this,this);

    private static final String TAG = "timerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        getSupportActionBar().hide();

       final Button btn = (Button) findViewById(R.id.buzzTime);
        setup();

        btn.setOnClickListener(new View.OnClickListener() {

       public void onClick(View v) {
receiveMinInput();
           receiveSecInput();
      am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + alarmDomain * 60000, pi);
            }
                   });










        final Button cancel = (Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Vibrator vibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrate.cancel();

            }






        });


    }


public void setup(){


    br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context.getApplicationContext(), "AHHHH",
//                    Toast.LENGTH_LONG).show();

           vibe.vibrate(inDomain*1000);

        }
    };
    registerReceiver(br, new IntentFilter("com.example.garycoltrane.buzz"));
    pi = PendingIntent.getBroadcast(this, 0, new Intent("com.example.garycoltrane.buzz"), 0);
    am = (AlarmManager) (this.getSystemService(Context.ALARM_SERVICE));




}

    public void receiveMinInput() {


        EditText textEdit = (EditText) findViewById(R.id.buzzEdit);
        inputGrab = textEdit.getText().toString();

        if (inputGrab.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter a value",
                    Toast.LENGTH_LONG).show();

        } else {
            alarmDomain = Integer.parseInt(inputGrab);
        }
    }



        public void receiveSecInput(){


       EditText editTxt = (EditText) findViewById(R.id.secEdit);
        inputTake = editTxt.getText().toString();


        if(inputTake.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter a value",
                    Toast.LENGTH_LONG).show();
    }
            else{


            inDomain = Integer.parseInt(inputTake);
        }
    }


}
