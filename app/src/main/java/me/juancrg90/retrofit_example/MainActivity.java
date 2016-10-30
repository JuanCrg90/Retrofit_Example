package me.juancrg90.retrofit_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.juancrg90.retrofit_example.api.GithubClient;
import me.juancrg90.retrofit_example.api.GithubService;
import me.juancrg90.retrofit_example.api.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.textView)
    TextView textView;

    GithubClient githubClient = new GithubClient();
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        githubClient = new GithubClient();

        githubService = githubClient.getGithubService();
    }

    @OnClick(R.id.button)
    public void handleFetch() {
        Call<List<Repository>> call = githubService.listRepos("JuanCrg90");

        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                textView.setText("Something went wrong: " + t.getMessage());
            }
        });


    }
}
