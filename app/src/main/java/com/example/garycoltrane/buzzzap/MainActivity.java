package com.example.garycoltrane.buzzzap;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.os.Vibrator;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MyActivity";
EditText textEdit;
   TextView viewTxt;
    int domain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        final Button button = (Button) findViewById(R.id.btn);


button.setOnClickListener(new View.OnClickListener(){


                        public void onClick(View v){

takeinPut();
vibrate(domain*1000);

    }

    public void vibrate(int duration)
    {
        //allow users to input how many seconds they want to implement instead of milliseconds.
        //so if user inputs 60 seconds, it would count as 60 milliseconds, so we would have to
        //do 60 * 1000 to get 60 seconds,
        //for every input, multiply it by 1000
        Vibrator vibes = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibes.vibrate(duration);
    }

    public void takeinPut(){
        textEdit = (EditText) findViewById(R.id.editText);
        String b = textEdit.getText().toString();
        domain = Integer.parseInt(b);
    }


});




    }



}
