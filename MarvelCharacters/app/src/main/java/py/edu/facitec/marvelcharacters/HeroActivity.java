package py.edu.facitec.marvelcharacters;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import py.edu.facitec.marvelcharacters.models.Character;
import py.edu.facitec.marvelcharacters.models.CharacterDao;
import py.edu.facitec.marvelcharacters.models.CharacterDto;

public class HeroActivity extends AppCompatActivity {
    ImageView imageViewHero;
    TextView textViewHeroName;
    TextView textViewHeroDescription;
    Button guardarFavoritoButton;

    CharacterDao characterDao;
    ListView comicsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        imageViewHero = findViewById(R.id.imageViewHero);
        textViewHeroName = findViewById(R.id.textViewHeroName);
        textViewHeroDescription = findViewById(R.id.textViewHeroDescription);
        comicsListView = findViewById(R.id.listViewHeroComics);
        guardarFavoritoButton = findViewById(R.id.button);
        characterDao = new CharacterDao(this);

        Character c = (Character) getIntent().getSerializableExtra("character");

        List<String> comicsNames = new ArrayList<>();
        for (int i = 0;
             i < c.getComics().getItems().size();
             i++) {
            comicsNames.add(c.getComics().getItems().get(i).getName());

        }
        ArrayAdapter<String> comicsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comicsNames);
        comicsListView.setAdapter(comicsAdapter);
        mostrarHero(c);

        guardarFavoritoButton.setOnClickListener(this::guardarAFavoritos);
    }

    private void mostrarHero(Character character) {
        String imageUrl = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension();

        Picasso.get().load(imageUrl).into(imageViewHero);
        textViewHeroName.setText(character.getName());
        if (character.getDescription().isEmpty()) {
            textViewHeroDescription.setText(R.string.no_description);
        } else {
            textViewHeroDescription.setText(character.getDescription());
        }
    }


    private void guardarAFavoritos(View view) {
        Character c = (Character) getIntent().getSerializableExtra("character");
        List<CharacterDto> listaDb = characterDao.obtenerTodos();
        boolean siExiste = false;
        for (int i = 0; i < listaDb.size(); i++
        ) {
            if (listaDb.get(i).getNombre().compareTo(c.getName()) == 0) {
                siExiste = true;
                System.out.println("El personaje ya existe " + c.getName());
            } else {
                siExiste = false;
                System.out.println("no existe");
            }

        }
        if (!siExiste) {
            CharacterDto dto = new CharacterDto();
            dto.setNombre(c.getName());
            dto.setDescripcion(c.getDescription());
            dto.setDtGuardado(new Date());
            characterDao.guardar(dto);
            Toast.makeText(this, "El personaje " + dto.getNombre() + "se ha guardado con exito!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El personaje ya existe!", Toast.LENGTH_SHORT).show();
        }


    }
}