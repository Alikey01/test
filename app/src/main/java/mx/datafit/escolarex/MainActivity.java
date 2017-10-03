package mx.datafit.escolarex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoTextView = (TextView)findViewById(R.id.ResultadoTextView);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://192.168.1.81/escolarex").build();

        TareasServicio servicio = restAdapter.create(TareasServicio.class);
        servicio.getTarea(new retrofit.Callback<List<Tareas>>() {
            @Override
            public void success(List<Tareas> tareases, retrofit.client.Response response) {
                resultadoTextView.setText(tareases.toString());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                resultadoTextView.setText(retrofitError.getMessage());
            }
        });


                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
