package py.edu.facitec.personajes_marvel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdapter extends BaseAdapter {

    final private Context context;

    final private List<PersonajeMarvel> listaPersonajes;

    public PersonajeAdapter(Context context, List<PersonajeMarvel> listaPersonajes) {
        this.context = context;
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public int getCount() {
        return listaPersonajes.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPersonajes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaPersonajes.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_personaje, null);
        }
        PersonajeMarvel personaje = (PersonajeMarvel) getItem(i);
        ImageView imageView = v.findViewById(R.id.circleImageView);
        TextView textViewName = v.findViewById(R.id.textViewPersonajeName);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);

        String imageUrl = personaje.getThumbnail().getPath() + "." + personaje.getThumbnail().getExtension();

        Picasso.get().load(imageUrl).into(imageView);
        textViewName.setText(personaje.getName());
        if (personaje.getDescription().isEmpty()) {
            textViewDescription.setText("Sin descripción");
        } else {
            textViewDescription.setText(personaje.getDescription());
        }

        return v;
    }
}
