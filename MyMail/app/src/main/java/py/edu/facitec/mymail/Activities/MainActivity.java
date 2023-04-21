package py.edu.facitec.mymail.Activities;



import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import py.edu.facitec.mymail.Fragments.DataFragment;
import py.edu.facitec.mymail.Fragments.DetailsFragment;
import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;

public class MainActivity extends AppCompatActivity implements DataFragment.OnFragmentInteractionListener {

    DetailsFragment detailFragment;

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();

        detailFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
    }

    public void onFragmentInteraction(Email email) {
        if(detailFragment!=null){
        detailFragment.render(email);
        }else{
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra("subject", email.getSubject());
              i.putExtra("message", email.getMessage());
              i.putExtra("senderName", email.getSender());
            startActivity(i);
        }
    }
    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

}