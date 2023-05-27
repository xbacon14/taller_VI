package py.edu.facitec.movies;

import android.graphics.Movie;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface MovieService {

    @GET("/3/discover/movie?sort_by=popularity.desc&api_key=4db36c2f48ed384918a6e02a99eb9e5e&language=es&page=1")
    void getMovies(Callback<MovieList> callback);
}
