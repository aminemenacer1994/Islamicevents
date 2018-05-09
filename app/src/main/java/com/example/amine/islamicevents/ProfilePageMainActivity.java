package com.example.amine.islamicevents;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilePageMainActivity extends Fragment{

    TextView buttonLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.activity_profile_page_main, container, false);

        buttonLogout = (TextView) myView.findViewById(R.id.buttonLogout);


        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfilePageMainActivity.this.getActivity(), ProfilePageEditActivity.class);
                ProfilePageMainActivity.this.startActivity(intent);

            }
        });


        return myView;

    }



}