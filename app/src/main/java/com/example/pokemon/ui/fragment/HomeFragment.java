package com.example.pokemon.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pokemon.Adapters.PokeHomeAdapter;
import com.example.pokemon.R;
import com.example.pokemon.databinding.FragmentHomeBinding;
import com.example.pokemon.interfaz.GetData;
import com.example.pokemon.models.pojo.Pokemons;
import com.example.pokemon.webservices.RetrofitPokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    FragmentHomeBinding bi;
    PokeHomeAdapter pokeAdapter;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = FragmentHomeBinding.inflate(inflater,container,false);
        View view = bi.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Create a handler for the RetrofitInstance interface//
        GetData service = RetrofitPokemon.getRetrofitInstance().create(GetData.class);
        Call<List<Pokemons>> call = service.getAllPokemons();
        //Execute the request asynchronously//
        call.enqueue(new Callback<List<Pokemons>>() {

            @Override
            //Handle a successful response//
            public void onResponse(Call<List<Pokemons>> call, Response<List<Pokemons>> response) {
                loadDataList(response.body());
            }

            @Override
            //Handle execution failures//
            public void onFailure(Call<List<Pokemons>> call, Throwable throwable) {

                //If the request fails, then display the following toast//
                Toast.makeText(getActivity(), "Unable to load pokemons", Toast.LENGTH_SHORT).show();
                System.out.println(call+"\n"+throwable);
            }
        });

    }

    //Display the retrieved data as a list//
    private void loadDataList(List<Pokemons> pokemonsList) {

        //Get a reference to the RecyclerView//
        pokeAdapter = new PokeHomeAdapter(pokemonsList, getActivity());

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bi.rvAllPokemons.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        bi.rvAllPokemons.setAdapter(pokeAdapter);
    }
}