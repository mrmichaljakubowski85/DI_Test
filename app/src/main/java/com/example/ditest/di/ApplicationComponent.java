package com.example.ditest.di;

import com.example.ditest.network.GitHubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@ApplicationScope
@Component(modules = {GitHubServiceModule.class, PicassoModule.class})
public interface ApplicationComponent {

    GitHubService getGitHubService();

    Picasso getPicasso();
}
