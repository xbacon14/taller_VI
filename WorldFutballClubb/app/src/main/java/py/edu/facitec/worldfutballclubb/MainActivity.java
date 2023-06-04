package py.edu.facitec.worldfutballclubb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<PaisDto> {
    ListView paisListView;
    ProgressBar progressBar;
    TextView errorTextView;
    Button reintentarButton;
    PaisService paisService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paisListView = findViewById(R.id.listViewPais);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        reintentarButton = findViewById(R.id.btnReintentar);


        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(getString(R.string.end_point)).build();
        paisService = restAdapter.create(PaisService.class);
        paisService.getPaises(this);


    }

    @Override
    public void success(PaisDto dto, Response response) {
        progressBar.setVisibility(View.GONE);
        PaisAdapter paisAdapter = new PaisAdapter(this,dto.getData().getTable());

        paisListView.setVisibility(View.VISIBLE);
        paisListView.setAdapter(paisAdapter);
    }

    @Override
    public void failure(RetrofitError error) {
        System.out.println(error.getMessage());
        progressBar.setVisibility(View.GONE);
        errorTextView.setVisibility(View.VISIBLE);
        errorTextView.setText(R.string.errorMessage);
        reintentarButton.setVisibility(View.VISIBLE);

    }

    public void tryAgain(View view) {
        reintentarButton.setVisibility(View.GONE);
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        paisService.getPaises(this);
    }
}