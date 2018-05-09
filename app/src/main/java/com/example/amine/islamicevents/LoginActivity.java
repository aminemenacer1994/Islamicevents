package com.example.amine.islamicevents;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.Console;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity{


    //defining views

    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup, skipLogin;
    private Button buttonSignIn;
    private String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        skipLogin = (TextView)findViewById(R.id.skipLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignup  = (TextView) findViewById(R.id.textViewSignUp);
        skipLogin = (TextView)findViewById(R.id.skipLogin);
        textViewSignup = (TextView)findViewById(R.id.textViewSignUp);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);
        email=editTextEmail.getText().toString().trim();

        // validate & login user
        // identify if user exists
        // identify if email and/or password is valid
        // make sure register details are unique

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJSON();
            }
        });
        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                LoginActivity.this.startActivity(intent);

            }
        });

        skipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                LoginActivity.this.startActivity(intent);

            }
        });


    }
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginActivity.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //
                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                LoginActivity.this.startActivity(intent);
                Toast.makeText(LoginActivity.this,"Signed in",Toast.LENGTH_LONG).show();


            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_GET_USER_BY_MAIL,email);
                Toast.makeText(LoginActivity.this,s,Toast.LENGTH_LONG).show();
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}