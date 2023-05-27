package py.edu.facitec.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<MovieList> {
    ListView movieListView;
    ProgressBar progressBar;
    TextView errorTextView;
    Button reintentarButton;
    MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListView = findViewById(R.id.listViewMovie);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        reintentarButton= findViewById(R.id.btnReintentar);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.themoviedb.org").build();
        movieService = restAdapter.create(MovieService.class);
        movieService.getMovies(this);

        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie m= (Movie) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this,DetalleActivity.class);
                intent.putExtra("movie",m);
                startActivity(intent);
            }
        });
    }

    @Override
    public void success(MovieList movieList, Response response) {
        progressBar.setVisibility(View.GONE);

        MovieAdapter movieAdapter = new MovieAdapter(this,movieList.getResults());

        movieListView.setVisibility(View.VISIBLE);
        movieListView.setAdapter(movieAdapter);


    }

    @Override
    public void failure(RetrofitError error) {
        System.out.println(error.getMessage());
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.errorMessage);
        reintentarButton.setVisibility(View.VISIBLE);
    }

    public void tryAgain(View view){
        reintentarButton.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        movieService.getMovies(this);
    }
}