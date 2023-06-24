package py.edu.facitec.marvelcharacters.models;

import android.content.Context;

import py.edu.facitec.marvelcharacters.DBA;

public class CharacterDao extends DBA<CharacterDto> {

    public CharacterDao(Context context) {
        init(context, CharacterDto.class);
    }
}
