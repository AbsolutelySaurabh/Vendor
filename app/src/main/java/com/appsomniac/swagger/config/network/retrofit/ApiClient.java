package com.appsomniac.swagger.config.network.retrofit;

import com.appsomniac.swagger.other.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by absolutelysaurabh on 23/9/17.
 */
public class ApiClient {

    public static final String BASE_URL = Config.BASE_URL;
    private static Retrofit retrofit = null;

    public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}