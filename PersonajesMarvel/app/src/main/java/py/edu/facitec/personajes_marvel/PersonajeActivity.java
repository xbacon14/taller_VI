package py.edu.facitec.personajes_marvel;

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

public class PersonajeActivity extends AppCompatActivity {
    ImageView imageViewPersonaje;
    TextView textViewPersonajeName;
    TextView textViewPersonajeDescription;
    Button btnGuardarFavorito;

    PersonajeMarvelDao personajeMarvelDao;
    
    ListView personajesListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        imageViewPersonaje = findViewById(R.id.imageViewPersonaje);
        textViewPersonajeName = findViewById(R.id.textViewPersonajeName);
        textViewPersonajeDescription = findViewById(R.id.textViewPersonajeDescription);
        personajesListView = findViewById(R.id.listViewPersonajeComics);
        personajeMarvelDao =new PersonajeMarvelDao(this);
        btnGuardarFavorito = findViewById(R.id.button);

        PersonajeMarvel personaje = (PersonajeMarvel) getIntent().getSerializableExtra("personaje");


        List<String> comicsPersonaje = new ArrayList<>();
        for (int i = 0; i < personaje.getComics().getItems().size(); i++) {

                comicsPersonaje.add(personaje.getComics().getItems().get(i).getName());


        }
        ArrayAdapter<String> comicsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comicsPersonaje);
        personajesListView.setAdapter(comicsAdapter);
        mostrarHero(personaje);

        btnGuardarFavorito.setOnClickListener(this::guardarAFavoritos);
    }

    private void mostrarHero(PersonajeMarvel p) {
        String imageUrl = p.getThumbnail().getPath() + "." + p.getThumbnail().getExtension();

        Picasso.get().load(imageUrl).into(imageViewPersonaje);
        textViewPersonajeName.setText(p.getName());
        if (p.getDescription().isEmpty()) {
            textViewPersonajeDescription.setText(R.string.no_description);
        } else {
            textViewPersonajeDescription.setText(p.getDescription());
        }
    }


    private void guardarAFavoritos(View view) {
        PersonajeMarvel p = (PersonajeMarvel) getIntent().getSerializableExtra("personaje");
        List<PersonajeMarveloDto> listaDb = personajeMarvelDao.obtenerTodos();
        boolean siExiste = false;
        for (int i = 0; i < listaDb.size(); i++
        ) {
            if (listaDb.get(i).getName().compareTo(p.getName()) == 0) {
                siExiste = true;
                System.out.println("El personaje ya existe " + p.getName());
            } else {
                siExiste = false;
                System.out.println("Aún no existe");
            }

        }
        if (!siExiste) {
            PersonajeMarveloDto dto = new PersonajeMarveloDto();
            dto.setName(p.getName());
            dto.setDescription(p.getDescription());
            dto.setDtCreated(new Date());
            personajeMarvelDao.guardar(dto);
            Toast.makeText(this, "El personaje " + dto.getName() + "se ha guardado con exito!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El personaje ya existe!", Toast.LENGTH_SHORT).show();
        }


    }
}
