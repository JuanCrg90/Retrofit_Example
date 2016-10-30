package me.juancrg90.retrofit_example.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JuanCrg90 on 10/30/16.
 */

public class GithubClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "https://api.github.com/";

    public GithubClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public GithubService getGithubService() {
        return this.retrofit.create(GithubService.class);

    }




}
