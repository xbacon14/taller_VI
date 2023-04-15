package py.edu.facitec.italo.blocdenotas;

import android.content.Context;

public class NotaDao extends DBA<Nota>{

    public NotaDao(Context context){
        init(context,Nota.class);
    }
}
