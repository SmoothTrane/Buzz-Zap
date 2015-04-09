package com.example.garycoltrane.buzzzap;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class timerAlarm{
   private static final String TAG = "timerActivity";
    private Context context;
    private Intent intent;
    AlarmManager am;
    PendingIntent pi;
    BroadcastReceiver br;
    long alarmDomain;
    int inDomain;
    String inputGrab;
    String inputTake;
    public Activity activity;

public vibrateCall vibe = new vibrateCall(context,activity);



    public timerAlarm (Context context, Activity timerActivity){


        this.context= context;
        this.activity= timerActivity;


    }


    public void setup(){


        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context.getApplicationContext(), "AHHHH",
//                    Toast.LENGTH_LONG).show();
                Vibrator vibratr = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vibratr.vibrate(inDomain*1000);

            }
        };
        context.registerReceiver(br, new IntentFilter("com.example.garycoltrane.buzz"));
        pi = PendingIntent.getBroadcast(context, 0, new Intent("com.example.garycoltrane.buzz"), 0);
        am = (AlarmManager) (context.getSystemService(Context.ALARM_SERVICE));




    }

    public void receiveMinInput() {


        EditText textEdit = (EditText) this.activity.findViewById(R.id.buzzEdit);
        inputGrab = textEdit.getText().toString();

        if (inputGrab.isEmpty()) {
            Toast.makeText(context.getApplicationContext(), "Please enter a value",
                    Toast.LENGTH_LONG).show();

        } else {
            alarmDomain = Integer.parseInt(inputGrab);
        }
    }





    public void receiveSecInput(){


        EditText editTxt = (EditText) this.activity.findViewById(R.id.secEdit);
        inputTake = editTxt.getText().toString();


        if(inputTake.isEmpty()){
            Toast.makeText(context.getApplicationContext(), "Please enter a value",
                    Toast.LENGTH_LONG).show();
        }
        else{


            inDomain = Integer.parseInt(inputTake);
        }
    }


}
