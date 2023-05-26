package py.edu.facitec.simplepokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textViewDetalleName;
    TextView textViewDetalleSpecie;
    TextView textViewDetalleType;
    TextView textViewDetalleAbilities;
    TextView textViewDetalleHeight;
    TextView textViewDetalleWeight;
    TextView textViewDetalleHPData;
    TextView textViewDetalleAttack;
    TextView textViewDetalleDefense;
    TextView textViewDetalleSpecialAttack;
    TextView textViewDetalleSpecialDefense;
    TextView textViewDetalleSpeed;
    TextView textViewDetalleTotal;
    TextView textViewDetalleEvolutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imageView = findViewById(R.id.imageViewDetalle);
        textViewDetalleName = findViewById(R.id.textViewDetalleName);
        textViewDetalleSpecie = findViewById(R.id.textViewDetalleSpecie);
        textViewDetalleType = findViewById(R.id.textViewDetalleType);
        textViewDetalleAbilities = findViewById(R.id.textViewDetalleAbilities);
        textViewDetalleHeight = findViewById(R.id.textViewDetalleHeight);
        textViewDetalleWeight = findViewById(R.id.textViewDetalleWeight);
        textViewDetalleHPData = findViewById(R.id.textViewDetalleHPData);
        textViewDetalleAttack = findViewById(R.id.textViewDetalleAttack);
        textViewDetalleDefense = findViewById(R.id.textViewDetalleDefense);
        textViewDetalleSpecialAttack = findViewById(R.id.textViewDetalleSpecialAttack);
        textViewDetalleSpecialDefense = findViewById(R.id.textViewDetalleSpecialDefense);
        textViewDetalleSpeed = findViewById(R.id.textViewDetalleSpeed);
        textViewDetalleTotal = findViewById(R.id.textViewDetalleTotal);
        textViewDetalleEvolutions = findViewById(R.id.textViewDetalleEvolutions);


        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");
        mostrarPokemon(pokemon);

    }

    private void mostrarPokemon(Pokemon pokemon) {
        Picasso.get().load("https://leodufer.github.io/simple-pokedex/img/pokemons/"+pokemon.getName().toLowerCase()+".jpg").into(imageView);
        textViewDetalleName.setText(pokemon.getName());
        textViewDetalleSpecie.setText(pokemon.getSpecies());
        textViewDetalleType.setText(pokemon.getType().toString());
        textViewDetalleAbilities.setText(pokemon.getAbilities().toString());
        textViewDetalleHeight.setText(pokemon.getHeight());
        textViewDetalleWeight.setText(pokemon.getWeight());
        textViewDetalleHPData.setText(String.valueOf(pokemon.getStats().getHp()));
        textViewDetalleAttack.setText(String.valueOf(pokemon.getStats().getAtack()));
        textViewDetalleDefense.setText(String.valueOf(pokemon.getStats().getDefense()));
        textViewDetalleSpecialAttack.setText(String.valueOf(pokemon.getStats().getSpAtk()));
        textViewDetalleSpecialDefense.setText(String.valueOf(pokemon.getStats().getSpDef()));
        textViewDetalleSpeed.setText(String.valueOf(pokemon.getStats().getSpeed()));
        textViewDetalleTotal.setText(String.valueOf(pokemon.getStats().getTotal()));
        textViewDetalleEvolutions.setText(pokemon.getEvolution().toString());
    }
}