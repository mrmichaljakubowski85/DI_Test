package com.example.ditest.di;

import com.example.ditest.MainActivity;

import dagger.Component;

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

//    CustomListAdapter getCustomListAdapter();

//    GitHubService getGitHubService();

    void inject(MainActivity mainActivity);
}

