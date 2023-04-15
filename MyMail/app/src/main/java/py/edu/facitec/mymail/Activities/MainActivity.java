package py.edu.facitec.mymail.Activities;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import py.edu.facitec.mymail.Fragments.DataFragment;
import py.edu.facitec.mymail.Fragments.DetailsFragment;
import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;

public class MainActivity extends FragmentActivity implements DataFragment.OnFragmentInteractionListener {

    DetailsFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();

        detailFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
    }


    @Override
    public void onFragmentInteraction(Email email) {
        if(detailFragment!=null){
            detailFragment.render(email);
        }else{
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra("email",email);
            startActivity(i);
        }
    }
    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}