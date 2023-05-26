package py.edu.facitec.simplepokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<Pokemon>> {
    ListView pokemonListView;
    ProgressBar progressBar;
    TextView errorTextView;
    Button reintentarButton;
    PokemonService pokemonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokemonListView = findViewById(R.id.listViewPokemon);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        reintentarButton = findViewById(R.id.btnReintentar);



        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(getString(R.string.end_point)).build();
        pokemonService = restAdapter.create(PokemonService.class);
        pokemonService.getPokemons(this);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon p = (Pokemon) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this,DetalleActivity.class);
                intent.putExtra("pokemon",p);
                startActivity(intent);
            }
        });
    }

    @Override
    public void success(List<Pokemon> pokemons, Response response) {
        progressBar.setVisibility(View.GONE);
        //cargar el adaptador
        PokemonAdapter pokemonAdapter = new PokemonAdapter(this,pokemons);

        pokemonListView.setVisibility(View.VISIBLE);
        pokemonListView.setAdapter(pokemonAdapter);


    }

    @Override
    public void failure(RetrofitError error) {
        System.out.println(error.getMessage());
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.errorMessage);
        reintentarButton.setVisibility(View.VISIBLE);

    }

    public void tryAgain(View view) {
        reintentarButton.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        pokemonService.getPokemons(this);
    }
}