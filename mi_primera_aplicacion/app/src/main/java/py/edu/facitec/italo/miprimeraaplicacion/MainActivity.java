package py.edu.facitec.italo.miprimeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText messageEditText;

public static final String EXTRA_MESSAGE = "py.edu.facitec.italo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageEditText= findViewById(R.id.editTextMessage);

    }

    public void sendMessage(View view) {
        String msg = messageEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
    }
}