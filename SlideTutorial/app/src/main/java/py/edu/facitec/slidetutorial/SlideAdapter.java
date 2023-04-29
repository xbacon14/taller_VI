package py.edu.facitec.slidetutorial;

import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {

    Context context;

    LayoutInflater inflater;

    public int[] image_list ={
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    public String[] title_list={
        "COSMONAUT",
        "SATELLITE",
        "GALAXY",
        "ROCKET",
    };

    public String[] description_list={
        "Description 1",
        "Description 2",
        "Description 3",
        "Description 4",
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    public int[] color_list={
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
    };

    @Override
    public int getCount() {

        return title_list.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutSlide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgSlide = (ImageView) view.findViewById(R.id.slideimg);
        TextView textTitle = (TextView) view.findViewById(R.id.textTitle);
        TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
        layoutSlide.setBackgroundColor(color_list[position]);
        imgSlide.setImageResource(image_list[position]);
        textTitle.setText(title_list[position]);
        textDescription.setText(description_list[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }
}
