package py.edu.facitec.italo.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        List<String> names = new ArrayList<String>();
        names.add("Italo");
        names.add("Jorge");
        names.add("Mabel");
        names.add("Marcelo");
        names.add("Guille");
        names.add("Pandora");
        names.add("Zeus");
        names.add("Luna");
        names.add("Oky");
        names.add("Marito");
        names.add("Lula");
        names.add("Ghandi");
        names.add("Michel teló");
        names.add("Anibal");
        names.add("Mabel");

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Clicked: "+ names.get(i), Toast.LENGTH_LONG).show();
            }
        });


    }
}