package py.edu.facitec.italo.blocdenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText descriptionEditText;
NotaDao notaDao;
ListView notasListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descriptionEditText= findViewById(R.id.editTextTextDescription);
        notasListView = findViewById(R.id.listViewNotas);
        notaDao = new NotaDao(this);
        cargarDatos();

        notasListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Nota nota = (Nota) adapterView.getAdapter().getItem(i);
                eliminarNota(nota);
                return true;
            }


        });
    }

    private void eliminarNota(Nota nota) {
        new AlertDialog.Builder(this).setTitle("Estas segudo que deseas eliminar resta nota?").setMessage(nota.getDescription()).setPositiveButton(
                android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("NOTA A ELIMINAR: ", nota.toString());
                        notaDao.delete(nota.getId());
                        cargarDatos();
                    }
                }
        ).show();

    }

    private void cargarDatos() {
        List<Nota> notas = notaDao.obtenerTodos();
        ArrayAdapter<Nota> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notas);
        notasListView.setAdapter(arrayAdapter);
    }

    public void saveNote(View view){
        Nota nota = new Nota();
        nota.setDescription(descriptionEditText.getText().toString());
        nota.setDate(new Date());
        if(nota.getDescription().isEmpty()){
            descriptionEditText.setError("La descripción es requerida");
            return;
        }
        notaDao.guardar(nota);
        descriptionEditText.setText(null);
        cargarDatos();

    }
}