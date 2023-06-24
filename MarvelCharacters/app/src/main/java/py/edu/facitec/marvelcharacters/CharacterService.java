package py.edu.facitec.marvelcharacters;

import py.edu.facitec.marvelcharacters.models.RestClientResponse;
import retrofit.Callback;
import retrofit.http.GET;

public interface CharacterService {

    @GET("/marvel-hero/characters.json")
    void getCharacters(Callback<RestClientResponse> callback);
}
