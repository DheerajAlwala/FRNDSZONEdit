package com.example.frndszone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    private static int SPLASH_TIME=4400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(ChatActivity.this,LoginActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME);
    }
}