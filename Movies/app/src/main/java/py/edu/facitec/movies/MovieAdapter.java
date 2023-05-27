package py.edu.facitec.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter  extends BaseAdapter {
final private Context context;

final private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movieList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null){
            view =LayoutInflater.from(context).inflate(R.layout.item_movie, null);
        }
        Movie movie = (Movie) getItem(position);
        ImageView imageView = view.findViewById(R.id.imageViewPortada);
        TextView textViewTitle= view.findViewById(R.id.textViewTitle);
        TextView textViewAverage= view.findViewById(R.id.textViewAverage);
        TextView textViewDate= view.findViewById(R.id.textViewFecha);
        TextView textViewOverview= view.findViewById(R.id.textViewOverview);
        textViewTitle.setText(movie.getTitle());
        textViewAverage.setText(Double.toString(movie.getVote_average()));
        textViewDate.setText(movie.getRelease_date());
        textViewOverview.setText(movie.getOverview());
        Picasso.get().load("https://image.tmdb.org/t/p/w185_and_h278_bestv2" + movie.getPoster_path()).into(imageView);
        return view;
    }
}
