package py.edu.facitec.parcial.golin.italo;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import py.edu.facitec.parcial.golin.italo.dao.impl.CustomerDao;
import py.edu.facitec.parcial.golin.italo.model.Customer;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton button;


    CustomerDao customerDao;

    ListView customerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        button = findViewById(R.id.goCustomerForm);
        button.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

                            Intent i = new Intent(MainActivity.this,CustomerFormActivity.class);
                            startActivity(i);
                        }

                }
        );

        customerListView = findViewById(R.id.listViewCustomer);

        customerDao = new CustomerDao(this);

        loadData();

       customerListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Customer customer = (Customer) adapterView.getAdapter().getItem(i);
            deleteCustomer(customer);
            return true;
           }
       });
    }


    private void deleteCustomer(Customer customer) {
        new AlertDialog.Builder(this).setTitle("Estás seguro que deseas eliminar el cliente?").setMessage(customer.getName()).setPositiveButton(
                android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("THE CUSTOMER WILL BE DELETED IS:",customer.toString());
                        customerDao.delete(customer.getId());
                        loadData();
                    }
                }
        ).show();
    }

    private void loadData() {
        List<Customer> customers = customerDao.obtenerTodos();
        ArrayAdapter<Customer> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,customers);
        customerListView.setAdapter(arrayAdapter);
    }


}