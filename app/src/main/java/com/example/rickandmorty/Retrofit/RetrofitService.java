package com.example.rickandmorty.Retrofit;

import com.example.rickandmorty.API.Feed;
import com.example.rickandmorty.API.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("api/character/")
    Call <Feed> getData();
}
