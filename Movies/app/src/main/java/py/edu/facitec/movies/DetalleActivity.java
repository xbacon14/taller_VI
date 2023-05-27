package py.edu.facitec.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    ImageView imageViewDetallePortada;
    TextView textViewDetalleTitle;
    TextView textViewDetalleAge;
    TextView textViewDetalleOriginalTitleData;
    TextView textViewDetalleAverage;
    TextView textViewDetalleVotesData;
    TextView textViewDetalleOverview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imageViewDetallePortada = findViewById(R.id.imageViewDetallePortada);
        textViewDetalleTitle = findViewById(R.id.textViewDetalleTitle);
        textViewDetalleAge = findViewById(R.id.textViewDetalleAge);
        textViewDetalleOriginalTitleData = findViewById(R.id.textViewDetalleOriginalTitleData);
        textViewDetalleAverage = findViewById(R.id.textViewDetalleAverage);
        textViewDetalleVotesData = findViewById(R.id.textViewDetalleVotesData);
        textViewDetalleOverview = findViewById(R.id.textViewOverview);


        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        mostrarMovie(movie);
    }

    private void mostrarMovie(Movie movie) {
        Picasso.get().load("https://image.tmdb.org/t/p/w185_and_h278_bestv2" + movie.getPoster_path()).into(imageViewDetallePortada);
        textViewDetalleTitle.setText(movie.getTitle());
        textViewDetalleAge.setText(movie.getRelease_date());
        textViewDetalleOriginalTitleData.setText(movie.getOriginal_title());
        textViewDetalleAverage.setText(Double.toString(movie.getVote_average()));
        textViewDetalleVotesData.setText(Double.toString(movie.getVote_average()));
        textViewDetalleOverview.setText(movie.getOverview());

    }
}