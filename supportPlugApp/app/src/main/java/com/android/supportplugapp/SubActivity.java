package com.android.supportplugapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.orange.HookManager;

import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class SubActivity extends Activity {

    HookManager hookManager = null;

    private final String TAG = "SubActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        hookManager = new HookManager(getApplicationContext(),
                intent.getStringExtra("packageUri"), intent.getStringExtra("ActivityName"));

        if(hookManager != null) {
            hookManager.attach(this);
            hookManager.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(hookManager != null) {
            hookManager.onPause();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(hookManager != null) {
            hookManager.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(hookManager != null) {
            hookManager.onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(hookManager != null) {
            hookManager.onStart();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(hookManager != null) {
            hookManager.onNewIntent(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(hookManager != null) {
            hookManager.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(hookManager != null) {
            hookManager.onDestroy();
        }
    }

    @Override
    public Resources getResources() {
        if(hookManager != null) {
            return hookManager.getResources();
        } else {
            return super.getResources();
        }
    }
}
