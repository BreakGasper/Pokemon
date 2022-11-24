package com.example.pokemon.models.pojo;

import com.google.gson.annotations.SerializedName;

public class Pokemons {
    @SerializedName("name")
    String name;

    @SerializedName("url")
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
