package com.example.rickandmorty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rickandmorty.API.Character;
import com.example.rickandmorty.Adapter.CharacterAdapter;
import com.example.rickandmorty.Retrofit.RetrofitClient;
import com.example.rickandmorty.Retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String baseUrl ="https://rickandmortyapi.com/";

    RecyclerView rvCharacters;
    List<Character> characterList = new ArrayList<>();

    Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBtn = findViewById(R.id.get);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvCharacters = findViewById(R.id.rv);

                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                rvCharacters.setLayoutManager(llm);

                final CharacterAdapter[] adapter = {new CharacterAdapter(characterList)};
                rvCharacters.setAdapter(adapter[0]);

                DividerItemDecoration itemDecoration = new DividerItemDecoration(rvCharacters.getContext(),llm.getOrientation());
                rvCharacters.addItemDecoration(itemDecoration);

                RetrofitService retrofitService = RetrofitClient.getClient(baseUrl).create(RetrofitService.class);

                Call<List<Character>> listCall = retrofitService.getCharacters();
                listCall.enqueue(new Callback<List<Character>>() {
                    @Override
                    public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                        if (response.isSuccessful()){
                            characterList = response.body();
                            adapter[0] = new CharacterAdapter(characterList);
                            rvCharacters.setAdapter(adapter[0]);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Character>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
