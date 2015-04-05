package com.example.garycoltrane.buzzzap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
EditText textEdit;
   TextView viewTxt;
    int domain;
public vibrateCall vibes = new vibrateCall(this,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Log.d(TAG, "Testing");


        final Button button = (Button) findViewById(R.id.btn);

        final Button timr = (Button) findViewById(R.id.timeBtn);

timr.setOnClickListener(new View.OnClickListener(){


    public void onClick(View view){

        Intent intent = new Intent(MainActivity.this, timerActivity.class);
        startActivity(intent);

    }



       });



button.setOnClickListener(new View.OnClickListener(){


                        public void onClick(View v){

vibes.takeinPut();



vibes.vibrate(vibes.domain*1000);



    }


});




    }






    }

