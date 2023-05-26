package py.edu.facitec.githubusers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<User>> {

    ProgressBar progressBar;
    ListView listView;
    TextView textView;
    Button btnReintentar;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.errorTextView);
        btnReintentar = findViewById(R.id.btnReintentar);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com/").build();
        userService = restAdapter.create(UserService.class);
        userService.getUsers(this);


    }

    @Override
    public void success(List<User> userList, Response response) {

        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
       // ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,userList);
        UserAdapter userAdapter = new UserAdapter(this,userList);

        listView.setAdapter(userAdapter);
    }

    @Override
    public void failure(RetrofitError error) {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
        textView.setText(getString(R.string.errorMsj) + error.getLocalizedMessage());
        btnReintentar.setVisibility(View.VISIBLE);

    }

    public void tryAgain(View view) {
        btnReintentar.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        userService.getUsers(this);
    }
}