package py.edu.facitec.marvelcharacters;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        characterDao = new CharacterDao(this);

        Character c = (Character) getIntent().getSerializableExtra("character");

        List<String> comicsNames = new ArrayList<String>();
        for (int i = 0;
             i < c.getComics().getItems().size();
             i++) {
            comicsNames.add(c.getComics().getItems().get(i).getName());

        }
        ArrayAdapter<String> comicsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comicsNames);
        comicsListView.setAdapter(comicsAdapter);
        mostrarHero(c);
    }

    private void mostrarHero(Character character) {
        String imageUrl = character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension();

        Picasso.get().load(imageUrl).into(imageViewHero);
        textViewHeroName.setText(character.getName());
        if (character.getDescription().isEmpty()) {
            textViewHeroDescription.setText("Sin descripción");
        } else {
            textViewHeroDescription.setText(character.getDescription());
        }
    }

    private void guardarAFavoritos(View view) {

        Character c = (Character) getIntent().getSerializableExtra("character");
        CharacterDto siExiste = characterDao.obtener(c.getId().intValue());
        if (siExiste == null) {
            CharacterDto dto = new CharacterDto();
            dto.setId(c.getId());
            dto.setNombre(c.getName());
            dto.setDescripcion(c.getDescription());
            dto.setDtGuardado(new Date());
            characterDao.guardar(dto);
            Toast.makeText(this, "Personaje guardado con exito!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El personaje ya existe!", Toast.LENGTH_SHORT).show();
        }


    }
}