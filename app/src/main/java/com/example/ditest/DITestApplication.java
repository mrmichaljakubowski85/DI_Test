package com.example.ditest;

import android.app.Activity;
import android.app.Application;

import com.example.ditest.di.ApplicationComponent;
import com.example.ditest.di.ApplicationContextModule;
import com.example.ditest.di.DaggerApplicationComponent;

import timber.log.Timber;

public class DITestApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        //                .gitHubServiceModule(new GitHubServiceModule())
//                .networkModule(new NetworkModule())
//                .picassoModule(new PicassoModule())
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
//                .gitHubServiceModule(new GitHubServiceModule())
//                .networkModule(new NetworkModule())
//                .picassoModule(new PicassoModule())
                .build();


    }

    public static DITestApplication get(Activity activity) {
        return (DITestApplication) activity.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
