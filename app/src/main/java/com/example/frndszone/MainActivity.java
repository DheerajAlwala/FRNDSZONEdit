package com.example.frndszone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME=3500;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(firebaseUser==null) {
                    Intent homeIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
                else
                {
                    Intent homeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        }, SPLASH_TIME);
    }
}