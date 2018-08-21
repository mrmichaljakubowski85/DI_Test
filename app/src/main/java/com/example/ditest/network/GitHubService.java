package com.example.ditest.network;

import com.example.ditest.model.GitHubRepo;
import com.example.ditest.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("user/{username}/repos")
    Call<List<GitHubRepo>> getRepositoriesForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<GitHubRepo>> getAllRepositories();

    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);

}
