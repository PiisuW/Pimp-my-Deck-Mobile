package com.example.pimp_my_deck;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;

    // Test of : http://localhost/api/cartes
    private static final String BASE_URL = "http://10.0.2.2:80/"; // Ensure this port matches your 'docker ps' result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);


        fetchCards();
    }

    private void fetchCards() {
        apiService.getCartes().enqueue(new Callback<List<Carte>>() {
            @Override
            public void onResponse(Call<List<Carte>> call, Response<List<Carte>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Carte> cards = response.body();

                    // Logic to show the result
                    for (Carte card : cards) {
                        Log.d("API_RESULT", "Nom de la carte: " + card.getNom());
                        Log.d("API_RESULT", "Id de la carte: " + card.getId_carte());
                        Log.d("API_RESULT", "Collection de la carte: " + card.getId_collection());
                        Log.d("API_RESULT", "Prix de la carte: " + card.getPrix());
                        Log.d("API_RESULT", "Description de la carte: " + card.getDescription());
                        Log.d("API_RESULT", "Rareter de la carte: " + card.getId_rarete());
                    }

                    Toast.makeText(MainActivity.this,
                            "Loaded " + cards.size() + " cartes de laravel",
                            Toast.LENGTH_LONG).show();
                } else {
                    Log.e("API_ERROR", "Response Code: " + response.code());
                    Toast.makeText(MainActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Carte>> call, Throwable t) {
                Log.e("API_ERROR", "Failure: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Network Error: Check if Laravel is running", Toast.LENGTH_LONG).show();
            }
        });
    }
}