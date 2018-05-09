package com.example.amine.islamicevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Checkout extends AppCompatActivity {

    Toolbar toolbar;
    Button debit, paypal, android_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        debit = (Button) findViewById(R.id.debit);
        paypal = (Button) findViewById(R.id.paypal);
        android_pay = (Button) findViewById(R.id.android_pay);


        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Checkout");

        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



     /*
        debit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paypal.setEnabled(false);
                android_pay.setEnabled(false);
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                debit.setEnabled(false);
                android_pay.setEnabled(false);
            }
        });

        android_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                debit.setEnabled(false);
                paypal.setEnabled(false);
            }
        });
        */

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
