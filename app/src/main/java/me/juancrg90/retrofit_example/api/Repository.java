package me.juancrg90.retrofit_example.api;

/**
 * Created by JuanCrg90 on 10/30/16.
 */
public class Repository {
    private String id;
    private String name;


    @Override
    public String toString() {
        return id + "/" + name;
    }
}
