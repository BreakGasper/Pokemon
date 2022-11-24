package com.example.pokemon.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPokemon {
    private static Retrofit retrofit;

    //Define the base URL//
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    //Create the Retrofit instance//
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())//Add the converter//
                    .build();//Build the Retrofit instance//
        }
        return retrofit;
    }
}
