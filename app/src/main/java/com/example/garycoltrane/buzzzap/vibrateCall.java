package com.example.garycoltrane.buzzzap;

import android.content.Context;
import android.os.Vibrator;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
public class vibrateCall {

    private Context context;
    private EditText textEdit;
  private  TextView viewTxt;
   private int domain;
public Activity activity;


//    public vibrateCall(Context mContext, Activity activity){
//
//        this.mContext = mContext;
//        this.activity= activity;
//


//    }
public vibrateCall(Context context, Activity MainActivity){
    this.context= context;
    this.activity = MainActivity;
}


    public void vibrate(int duration)
    {

        Vibrator vibes = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
        vibes.vibrate(duration);
    }

    public void takeinPut(){
        textEdit = (EditText) this.activity.findViewById(R.id.editText);
        String b = textEdit.getText().toString();


        domain = Integer.parseInt(b);

    }

}