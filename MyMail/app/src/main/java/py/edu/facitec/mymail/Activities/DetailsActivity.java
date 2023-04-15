package py.edu.facitec.mymail.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import py.edu.facitec.mymail.Fragments.DetailsFragment;
import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent().getExtras()!=null){
            Email email = (Email) getIntent().getExtras().getSerializable("email");
            DetailsFragment detailFragment= (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailFragment.render(email);
        }

    }
}