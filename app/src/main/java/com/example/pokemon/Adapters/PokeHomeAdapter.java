package com.example.pokemon.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.R;
import com.example.pokemon.models.pojo.Pokemons;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokeHomeAdapter extends RecyclerView.Adapter<PokeHomeAdapter.CustomViewHolder> {

    private List<Pokemons> dataList;
    Context context;

    public PokeHomeAdapter(List<Pokemons> dataList, Context context){

        this.dataList = dataList;
        this.context= context;
        
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {

        //Get a reference to the Views in our layout//
        public final View v;

        TextView tvPokeName;
        ImageView ivPokeFoto;

        CustomViewHolder(View itemView) {
            super(itemView);
            v = itemView;

            tvPokeName = v.findViewById(R.id.tv_poke_name);
            ivPokeFoto = v.findViewById(R.id.iv_poke_foto);


        }


    }
    //Construct a RecyclerView.ViewHolder//
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_home_layout, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder h, int position) {
        System.out.println("DataList: "+dataList.size());
        Pokemons p = dataList.get(position);
        h.tvPokeName.setText(p.getName());
        Picasso.get()
                .load(p.getUrl())
                .into(h.ivPokeFoto);

    }


    //Calculate the item count for the RecylerView//
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
