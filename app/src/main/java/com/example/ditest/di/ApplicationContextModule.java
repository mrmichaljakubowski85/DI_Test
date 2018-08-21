package com.example.ditest.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationContextModule {

    private final Context context;

    public ApplicationContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    public Context context() {
        return context;
    }
}
