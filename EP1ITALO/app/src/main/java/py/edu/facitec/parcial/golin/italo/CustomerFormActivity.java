package py.edu.facitec.parcial.golin.italo;

import static java.time.LocalDateTime.now;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;


import py.edu.facitec.parcial.golin.italo.dao.impl.CustomerDao;
import py.edu.facitec.parcial.golin.italo.model.Customer;

public class CustomerFormActivity extends AppCompatActivity {

    EditText nameEditText;

    EditText emailEditText;

    CustomerDao customerDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_form);

        nameEditText = findViewById(R.id.editTextTextName);
        emailEditText = findViewById(R.id.editTextTextEmail);

        customerDao = new CustomerDao(this);
    }

    public void saveCustomer(View view){
        Customer customer = new Customer();
        customer.setName(nameEditText.getText().toString());
        customer.setEmail(emailEditText.getText().toString());
       customer.setDate(new Date());
        if(customer.getName().isEmpty()){
            nameEditText.setError("Name is required");
            return;
        }
        if(customer.getEmail().isEmpty()){
            emailEditText.setError("Email is required");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(customer.getEmail()).matches()){
            emailEditText.setError("That is not email format");
            return;
        }
            customerDao.guardar(customer);
            nameEditText.setText(null);
            emailEditText.setText(null);
            Toast toast = Toast.makeText(getApplicationContext(),"The customer have been saved",Toast.LENGTH_SHORT);
            toast.setMargin(24,24);
            toast.show();
            Intent i = new Intent(CustomerFormActivity.this,MainActivity.class);
            startActivity(i);

    }


}