package com.example.apicountry;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    AsiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/region/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Countries countries = retrofit.create(Countries.class);
        Call<List<AsiaDetails>> call = countries.getAsiaDetails();
        call.enqueue(new Callback<List<AsiaDetails>>() {
            @Override
            public void onResponse(Call<List<AsiaDetails>> call, Response<List<AsiaDetails>> response) {
               if (!response.isSuccessful()){
                  Toast.makeText(MainActivity.this, response.code(),Toast.LENGTH_SHORT).show();
                   return;
               }
               List<AsiaDetails> asiaDetailsList = response.body();
               adapter = new AsiaAdapter(MainActivity.this,asiaDetailsList);
               recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<AsiaDetails>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}