package com.example.mystore.service;

import com.example.mystore.network.CategoryApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationNetwork {
    private static ApplicationNetwork instance;
    private Retrofit retrofit;
    public ApplicationNetwork (){
        retrofit = new Retrofit
                .Builder()
                .baseUrl("https://vpd121.itstep.click")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static ApplicationNetwork getInstance(){
        if (instance==null)
            instance=new ApplicationNetwork();
        return instance;

    }

    public CategoryApi getCategory (){
        return retrofit.create(CategoryApi.class);
    }

}
