package com.example.amine.islamicevents;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class LaucherActivity extends AppCompatActivity {


        private int SPLASH_TIME_OUT = 1200;
        ImageView image;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_laucher);



            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(LaucherActivity.this, SignupActivity.class);
                    LaucherActivity.this.startActivity(intent);
                    finish();

                }
            }, SPLASH_TIME_OUT);
        }
    }

