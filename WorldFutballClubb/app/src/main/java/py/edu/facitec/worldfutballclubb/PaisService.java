package py.edu.facitec.worldfutballclubb;

import android.provider.Settings;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface PaisService {

        @GET("/api-client/leagues/table.json?"+ "key=HliwntsFmkCtu2L9" + "&"+ "secret=16sCObJKlVVXV2mDnFaL9CqvX3Zs5KB7" +"&"+ "competition_id=362&lang=es")
        void getPaises(Callback<PaisDto> callback);
}
