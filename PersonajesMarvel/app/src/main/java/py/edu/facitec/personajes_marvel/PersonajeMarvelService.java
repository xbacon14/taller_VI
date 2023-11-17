package py.edu.facitec.personajes_marvel;

import retrofit.Callback;
import retrofit.http.GET;

public interface PersonajeMarvelService {
    @GET("/marvel-hero/characters.json")
    void obtenerPersonajes(Callback<Respuesta> callback);
}
