package com.android.plugapp;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orange.PlugActivity;

public class MainActivity extends PlugActivity {

    Button buttonA;
    Button buttonB;

    final String TAG = "PlugActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(!isAttach()) {
            super.onCreate(savedInstanceState);
        }

        Log.d(TAG, "setContentView !!!");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "setContentView end !!!");
        buttonA = (Button) findViewById(R.id.button);
        buttonA.setOnClickListener(listener);

        buttonB = (Button) findViewById(R.id.button2);
        buttonB.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Intent intent = new Intent();
                    intent.setClassName(getApplicationContext(), "com.android.supportplugapp.MainActivity");
                    startActivity(intent);
                    break;

                case R.id.button2:
                    Toast.makeText(getApplicationContext(), "R.id.button2", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onPause() {
        if(!isAttach()) {
            super.onPause();
        }
    }

    @Override
    protected void onRestart() {
        if(!isAttach()) {
            super.onRestart();
        }
    }

    @Override
    protected void onResume() {
        if(!isAttach()) {
            super.onResume();
        }
    }

    @Override
    protected void onStart() {
        if(!isAttach()) {
            super.onStart();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if(!isAttach()) {
            super.onNewIntent(intent);
        }
    }

    @Override
    protected void onStop() {
        if(!isAttach()) {
            super.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        if(!isAttach()) {
            super.onDestroy();
        }
    }
}
