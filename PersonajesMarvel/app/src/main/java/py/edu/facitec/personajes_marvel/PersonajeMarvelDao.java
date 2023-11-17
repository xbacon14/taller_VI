package py.edu.facitec.personajes_marvel;

import android.content.Context;

public class PersonajeMarvelDao extends Dba<PersonajeMarveloDto> {
    public PersonajeMarvelDao(Context context) {
        init(context, PersonajeMarveloDto.class);
    }
}
