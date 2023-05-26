package py.edu.facitec.simplepokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {
   final private Context context;
   final private List<Pokemon> pokemonList;

    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @Override
    public int getCount() {
            return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pokemonList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
           view= LayoutInflater.from(context).inflate(R.layout.item_pokemon, null);

        }
        Pokemon pokemon = (Pokemon) getItem(position);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewSpecies = view.findViewById(R.id.textViewSpecies);
        textViewName.setText(pokemon.getName());
        textViewSpecies.setText(pokemon.getSpecies());
        Picasso.get().load("https://leodufer.github.io/simple-pokedex/img/pokemons/"+pokemon.getName().toLowerCase()+".jpg").into(imageView);


        return view;
    }
}
