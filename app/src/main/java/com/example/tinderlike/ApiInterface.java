package com.example.tinderlike;

import com.example.tinderlike.models.Example;
import com.example.tinderlike.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api")
    Call<Example> getUser();
}
