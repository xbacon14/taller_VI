package py.edu.facitec.personajes_marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<Respuesta> {
    ListView personajesListView;
    ProgressBar progressBar;
    TextView errorTextView;
    Button btnReintentar;
    PersonajeMarvelService personajeMarvelService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        personajesListView = findViewById(R.id.listViewPersonajes);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        btnReintentar = findViewById(R.id.btnReintentar);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://leodufer.github.io").build();
        personajeMarvelService = restAdapter.create(PersonajeMarvelService.class);
        personajeMarvelService.obtenerPersonajes(this);

        personajesListView.setOnItemClickListener((parent, view, position, id) -> {
            PersonajeMarvel p = (PersonajeMarvel) parent.getAdapter().getItem(position);
            Intent intent = new Intent(MainActivity.this, PersonajeActivity.class);
            intent.putExtra("personaje", p);
            startActivity(intent);
        });
    }

    @Override
    public void success(Respuesta respuesta, Response response) {
        progressBar.setVisibility(View.GONE);

        PersonajeAdapter personajeAdapter = new PersonajeAdapter(this, respuesta.getData().getResults());

        personajesListView.setVisibility(View.VISIBLE);
        personajesListView.setAdapter(personajeAdapter);
    }

    @Override
    public void failure(RetrofitError error) {
        System.out.println(error.getMessage());
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.errorMessage);
        btnReintentar.setVisibility(View.VISIBLE);
    }

    public void reintentar(View view) {
        btnReintentar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        personajeMarvelService.obtenerPersonajes(this);
    }
}