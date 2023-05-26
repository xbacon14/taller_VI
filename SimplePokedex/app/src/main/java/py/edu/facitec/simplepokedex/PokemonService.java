package py.edu.facitec.simplepokedex;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


public interface PokemonService {

    @GET("/pokemons.json")
    void getPokemons(Callback<List<Pokemon>> callback);
}