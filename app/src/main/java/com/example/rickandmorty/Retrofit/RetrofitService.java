package com.example.rickandmorty.Retrofit;

import com.example.rickandmorty.API.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("api/character/")
    Call<List<Character>> getCharacters();
}
