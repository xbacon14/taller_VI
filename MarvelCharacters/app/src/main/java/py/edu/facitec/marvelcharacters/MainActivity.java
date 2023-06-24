package py.edu.facitec.marvelcharacters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import py.edu.facitec.marvelcharacters.models.Character;
import py.edu.facitec.marvelcharacters.models.RestClientResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<RestClientResponse> {

    ListView characterListView;
    ProgressBar progressBar;
    TextView errorTextView;
    Button reintentarButton;
    CharacterService characterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterListView = findViewById(R.id.listViewCharacter);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        reintentarButton = findViewById(R.id.btnReintentar);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://leodufer.github.io").build();
        characterService = restAdapter.create(CharacterService.class);
        characterService.getCharacters(this);

        characterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Character c = (Character) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, HeroActivity.class);
                intent.putExtra("character", c);
                startActivity(intent);
            }
        });

    }

    @Override
    public void success(RestClientResponse restClientResponse, Response response) {
        progressBar.setVisibility(View.GONE);

        CharacterAdapter characterAdapter = new CharacterAdapter(this, restClientResponse.getData().getResults());

        characterListView.setVisibility(View.VISIBLE);
        characterListView.setAdapter(characterAdapter);


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
        characterService.getCharacters(this);
    }

}