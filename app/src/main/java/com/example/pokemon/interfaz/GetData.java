package com.example.pokemon.interfaz;

import com.example.pokemon.models.pojo.Pokemons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    //Specify the request type and pass the relative URL//
    @GET("pokemon?limit=100000&offset=0")
    //Wrap the response in a Call object with the type of the expected result//
    Call<List<Pokemons>> getAllPokemons();
}
