package com.example.ditest.di;

import com.example.ditest.CustomListAdapter;
import com.example.ditest.MainActivity;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    public final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public CustomListAdapter customListAdapter(Picasso picasso) {
        return new CustomListAdapter();
    }
}
