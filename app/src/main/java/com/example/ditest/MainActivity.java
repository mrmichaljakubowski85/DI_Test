package com.example.ditest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.ditest.di.DaggerMainActivityComponent;
import com.example.ditest.di.MainActivityComponent;
import com.example.ditest.di.MainActivityModule;
import com.example.ditest.model.GitHubRepo;
import com.example.ditest.network.GitHubService;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    GitHubService gitHubService;

    @Inject
    CustomListAdapter customListAdapter;
    private Call<List<GitHubRepo>> allRepositoriesCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .applicationComponent(DITestApplication.get(this).getApplicationComponent())
                .build();
        mainActivityComponent.inject(this);
//        gitHubService = mainActivityComponent.getGitHubService();
//        mainActivityComponent.inject(this);

//        customListAdapter = mainActivityComponent.getCustomListAdapter();

        allRepositoriesCall = gitHubService.getAllRepositories();

        allRepositoriesCall.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                Timber.d("onResponse");
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Timber.d("onFailure");
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (allRepositoriesCall != null) {
            allRepositoriesCall.cancel();
        }
    }
}
