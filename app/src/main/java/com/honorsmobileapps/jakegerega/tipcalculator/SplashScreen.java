package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private int timer = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Timer t = new Timer();

        TimerTask ttask = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent i = new Intent(SplashScreen.this, BillActivity.class);
                startActivity(i);
            }
        };
        t.schedule(ttask, timer);

    }
}
