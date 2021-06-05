package com.example.apicountry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Countries {
    @GET("asia")
    Call<List<AsiaDetails>> getAsiaDetails();
}
