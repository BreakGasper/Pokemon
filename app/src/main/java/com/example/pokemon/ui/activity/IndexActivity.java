package com.example.pokemon.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.pokemon.ui.fragment.BagFragment;
import com.example.pokemon.ui.fragment.GetPokemonFragment;
import com.example.pokemon.R;
import com.example.pokemon.databinding.ActivityIndexBinding;
import com.example.pokemon.ui.fragment.HomeFragment;

public class IndexActivity extends AppCompatActivity {

    ActivityIndexBinding bi;
    String TAG ="FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_index);

        bi.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.navigation_home:
                    OpenFragment(HomeFragment.newInstance("",""));
                    return true;

                case R.id.navigation_get_pokemons:
                    OpenFragment(GetPokemonFragment.newInstance("",""));
                    return true;

                case R.id.navigation_my_pokemons:
                    OpenFragment(BagFragment.newInstance("",""));
                    return true;
            }
            return false;
        });
    }

    private void OpenFragment(Fragment fragment) {
        Log.d(TAG, "openFragment: ");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}