package com.example.ditest.di;

import com.example.ditest.network.GitHubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = NetworkModule.class)
public class GitHubServiceModule {

    @Provides
    @ApplicationScope
    public GitHubService gitHubService(Retrofit gitHubRetrofit) {
        return gitHubRetrofit.create(GitHubService.class);
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }
}
