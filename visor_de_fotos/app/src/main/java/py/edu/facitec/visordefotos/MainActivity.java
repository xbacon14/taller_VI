package py.edu.facitec.visordefotos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<Imagen>> {


    ProgressBar progressBar;
    TextView errorTextView;
    Button reintentarButton;
    RecyclerView imagenesRecyclerView;
    private boolean isLoading = false;
    private int currentPage = 1;
    ImagenAdapter imagenAdapter;
    private ImagenService imagenService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenesRecyclerView = findViewById(R.id.imagenesRecyclerView);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        reintentarButton = findViewById(R.id.btnReintentar);
        progressBar.setVisibility(View.GONE);


        imagenesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        imagenAdapter = new ImagenAdapter(this);
        imagenesRecyclerView.setVisibility(View.VISIBLE);
        imagenesRecyclerView.setAdapter(imagenAdapter);

        imagenesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = imagenesRecyclerView.getLayoutManager().getItemCount();
                int lastVisibleItem = ((LinearLayoutManager) imagenesRecyclerView.getLayoutManager()).findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + 5)) {

                    currentPage++;
                    cargarMasImagenes(currentPage);
                    isLoading = true;
                }
            }
        });
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://picsum.photos/v2").build();
        imagenService = restAdapter.create(ImagenService.class);
        imagenService.getImagenes(currentPage,this);
        cargarImagenes(currentPage);
}
    private void cargarImagenes(int page) {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        reintentarButton.setVisibility(View.GONE);
        imagenService.getImagenes(currentPage,this);
    }

    private void cargarMasImagenes(int page) {
        progressBar.setVisibility(View.VISIBLE);
        errorTextView.setVisibility(View.GONE);
        reintentarButton.setVisibility(View.GONE);
        imagenService.getImagenes(currentPage,this);
    }

    @Override
    public void success(List<Imagen> imagens, Response response) {
        progressBar.setVisibility(View.GONE);

        if (currentPage == 1) {
            imagenAdapter.setImagenes(imagens);
        } else {
            imagenAdapter.addImagenes(imagens);
            isLoading = false;
        }

        imagenesRecyclerView.setVisibility(View.VISIBLE);

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
        imagenService.getImagenes(currentPage,this);
    }
}