package py.edu.facitec.marvelcharacters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import py.edu.facitec.marvelcharacters.models.Character;

public class CharacterAdapter extends BaseAdapter {
    final private Context context;
    final private List<Character> characterList;

    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @Override
    public int getCount() {
        return characterList.size();
    }

    @Override
    public Object getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return characterList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_character, null);
        }
        Character c = (Character) getItem(position);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textViewName = v.findViewById(R.id.textViewHeroName);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);

        String imageUrl = c.getThumbnail().getPath() + "." + c.getThumbnail().getExtension();

        Picasso.get().load(imageUrl).into(imageView);
        textViewName.setText(c.getName());
        if (c.getDescription().isEmpty()) {
            textViewDescription.setText("Sin descripción");
        } else {
            textViewDescription.setText(c.getDescription());
        }

        return v;


    }
}
