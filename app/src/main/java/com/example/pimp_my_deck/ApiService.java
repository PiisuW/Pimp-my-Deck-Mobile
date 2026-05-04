package com.example.pimp_my_deck;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("api/cartes")
    Call<List<Carte>> getCartes();
}
