package py.edu.facitec.visordefotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagenAdapter extends RecyclerView.Adapter<ImagenAdapter.ImagenViewHolder> {
    private Context context;
    private List<Imagen> imagenes;

    public ImagenAdapter(Context context) {
        this.context = context;
        this.imagenes = new ArrayList<>();
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
        notifyDataSetChanged();
    }

    public void addImagenes(List<Imagen> nuevasImagenes) {
        this.imagenes.addAll(nuevasImagenes);
        notifyDataSetChanged();
    }
    @Override
    public ImagenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_imagen, parent, false);
        return new ImagenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagenViewHolder holder, int position) {
        Imagen imagen = imagenes.get(position);


        Picasso.get()
                .load(imagen.getDownload_url())
                              .into(holder.imageView);

        holder.authorTextView.setText(imagen.getAuthor()); // Reemplaza con la propiedad correspondiente en tu modelo
    }

    @Override
    public int getItemCount() {
        return imagenes.size();
    }

    public class ImagenViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView authorTextView;

        public ImagenViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            authorTextView = itemView.findViewById(R.id.textView);
        }
    }
}