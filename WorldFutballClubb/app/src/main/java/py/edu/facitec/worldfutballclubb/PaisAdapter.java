package py.edu.facitec.worldfutballclubb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PaisAdapter extends BaseAdapter {
    final private Context context;
    final private List<Pais> paisList;

    public PaisAdapter(Context context, List<Pais> paisList) {
        this.context = context;
        this.paisList = paisList;
    }

    @Override
    public int getCount() {
        return paisList.size();
    }

    @Override
    public Object getItem(int position) {
        return paisList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return paisList.get(position).getTeam_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_pais,null);
        }
        Pais p = (Pais) getItem(position);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewGroup = v.findViewById(R.id.textViewGrupo);
        TextView textViewPoints = v.findViewById(R.id.textViewPuntosLabel);
        TextView textViewGF = v.findViewById(R.id.textViewGFData);
        TextView textViewGC = v.findViewById(R.id.textViewGCData);
        TextView textViewDG = v.findViewById(R.id.textViewDGData);

        Picasso.get().load("https://livescore-api.com" + "/api-client/countries/flag.json?team_id="+p.getTeam_id()+"&"+ "key=HliwntsFmkCtu2L9"+"&"+"secret=16sCObJKlVVXV2mDnFaL9CqvX3Zs5KB7").into(imageView);
        textViewName.setText(p.getName());
        textViewGroup.setText("Group "+p.getGroup_name());
        if(p.getPoints()==null){
            textViewPoints.setText("0");
        }else{
            textViewPoints.setText(Long.toString(p.getPoints()));
        }
        textViewGF.setText(Long.toString(p.getGoals_scored()));
        textViewGC.setText(Long.toString(p.getGoals_conceded()));
        textViewDG.setText(Long.toString(p.getGoal_diff()));

        return v;


    }
}
