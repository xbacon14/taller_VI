package py.edu.facitec.visordefotos;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ImagenService {
    @GET("/list")
    default void getImagenes(@Query("page") int position,Callback<List<Imagen>> callback) {

    }
}
