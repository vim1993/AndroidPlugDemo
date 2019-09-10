package com.orange;

import com.orange.PlugActivity;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import dalvik.system.DexClassLoader;

public class HookManager {
    private Class mPlugClass;
    private Object mInstance;
    private String mApkPath;
    private String mActivityName;
    private Resources mResources;
    private DexClassLoader mClassLoader;

    private Context mContext;

    private final String TAG = "PlugActivity";

    public HookManager(Context context, String apkPath, String activityName) {
        mApkPath = apkPath;
        mContext = context;
        mActivityName = activityName;

        try {
            //load apk dex.
            File dexOutFile = mContext.getDir("dex", Context.MODE_PRIVATE);
            mClassLoader = new DexClassLoader(mApkPath, dexOutFile.getAbsolutePath(), null, mContext.getClassLoader().getParent());

            //load activity info
            mPlugClass = mClassLoader.loadClass(mActivityName);

            //get activity instance
            mInstance = mPlugClass.getConstructor().newInstance();

            //load apk resources
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssertMethod = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssertMethod.invoke(assetManager, mApkPath);
            mResources = new Resources(assetManager, mContext.getResources().getDisplayMetrics(), mContext.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Resources getResources() {
        return mResources;
    }

    public ClassLoader getClassLoader() {
        return mClassLoader;
    }

    public void attach(Activity proxyActivity) {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getMethod("attach", Activity.class);
                method.invoke(mInstance, proxyActivity);
                Log.d(TAG, "attach!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onCreate", Bundle.class);
                method.setAccessible(true);
                method.invoke(mInstance, savedInstanceState);
                Log.d(TAG, "onCreate!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onStart() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onStart");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onStart!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onResume() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onResume");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onResume!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onPause() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onPause");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onPause!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onStop() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onStop");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onStop!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onDestroy() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onDestroy");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onDestroy!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onRestart() {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onRestart");
                method.setAccessible(true);
                method.invoke(mInstance);
                Log.d(TAG, "onRestart!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onNewIntent(Intent intent) {
        if(mInstance != null) {
            try {
                Method method = mPlugClass.getDeclaredMethod("onNewIntent", Intent.class);
                method.setAccessible(true);
                method.invoke(mInstance, intent);
                Log.d(TAG, "onNewIntent!!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}