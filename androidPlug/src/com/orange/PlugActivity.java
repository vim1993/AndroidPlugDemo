package com.orange;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.content.pm.ApplicationInfo;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.ComponentName;

import android.content.Context;

import android.content.res.Resources;

/*
    plug apk activity need extends PlugActivity
 */
public class PlugActivity extends Activity {
    Activity m_proxy = null;

    public void attach(Activity proxyActivity) {
        m_proxy = proxyActivity;
    }

    public boolean isAttach() {
        return m_proxy != null;
    }

    @Override
    public View findViewById(int id){
        if(m_proxy == null) {
            return super.findViewById(id);
        }

        return m_proxy.findViewById(id);
    }

    @Override
    public void setContentView(View view) {
        if(m_proxy != null) {
            m_proxy.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    public void setContentView(int layoutResID) {
        if(m_proxy != null) {
            m_proxy.setContentView(layoutResID);
        } else {
            super.setContentView(layoutResID);
        }
    }

    @Override
    public Window getWindow() {
        if(m_proxy != null) {
            return m_proxy.getWindow();
        }
        return super.getWindow();
    }

    @Override
    public WindowManager getWindowManager() {
        if(m_proxy != null) {
            return m_proxy.getWindowManager();
        }
        return super.getWindowManager();
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if(m_proxy != null) {
            return m_proxy.getLayoutInflater();
        }
        return super.getLayoutInflater();
    }
    
    public Resources getResources() {
        if(m_proxy != null) {
           return m_proxy.getResources();
        }

        return super.getResources();
    }
    
    public ApplicationInfo getApplicationInfo() {
        if(m_proxy != null) {
           return m_proxy.getApplicationInfo();
        }

        return super.getApplicationInfo();
    }
    
    public Context getApplicationContext() {
        if(m_proxy != null) {
           return m_proxy.getApplicationContext();
        }

        return super.getApplicationContext();
    }
    
    public void startActivity(Intent intent) {
        if(m_proxy != null) {
            m_proxy.startActivity(intent);
        }else {
            super.startActivity(intent);
        }
    }
    
    public void sendBroadcast(Intent intent) {
        if(m_proxy != null) {
            m_proxy.sendBroadcast(intent);
        }else {
            super.sendBroadcast(intent);
        }
    }
    
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        if(m_proxy != null) {
            return m_proxy.registerReceiver(receiver, filter);
        }
        return super.registerReceiver(receiver, filter);
    }
    
    public ClassLoader getClassLoader() {
        if(m_proxy != null) {
            return m_proxy.getClassLoader();
        }
        return super.getClassLoader();
    }
    
    public Intent getIntent() {
        if(m_proxy != null){
            return m_proxy.getIntent();
        }
        return super.getIntent();
    }
    
    public ComponentName startService(Intent service) {
        if(m_proxy != null) {
            return m_proxy.startService(service);
        }
        return super.startService(service);
    }
}