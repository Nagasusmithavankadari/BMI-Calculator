package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,BMICalculator.class);
                startActivity(intent);
                finish();
                //Animation is fade in
                //To create that in res-->new Android Resource Directory-->name it as anim-->new animation Resource file
                //Name it as fade_in
                overridePendingTransition(R.anim.fade_in,0);
            }
            //Splash screen Works for 1sec
        },1000);
    }
}