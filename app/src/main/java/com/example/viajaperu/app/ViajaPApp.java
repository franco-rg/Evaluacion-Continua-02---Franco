package com.example.viajaperu.app;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;

public class ViajaPApp extends Application {
    private static ViajaPApp instance;
    private static Context appContext;

    public static ViajaPApp getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        /* se carga la vista */
        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}