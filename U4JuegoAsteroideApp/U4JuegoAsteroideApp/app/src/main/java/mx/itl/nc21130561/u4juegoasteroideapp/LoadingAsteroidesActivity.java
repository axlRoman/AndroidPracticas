package mx.itl.nc21130561.u4juegoasteroideapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingAsteroidesActivity extends AppCompatActivity {

    private static final int LOADING_DURATION = 3000; // Duración de la pantalla de carga en milisegundos
    private static final int IMAGE_CHANGE_INTERVAL = 150; // Intervalo de cambio de imagen en milisegundos

    private ImageView loadingImage;
    private int currentImageIndex = 0;
    private Handler handler;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        loadingImage = findViewById(R.id.loading_image);
        handler = new Handler();
        timer = new Timer();

        // Iniciar la actividad del juego después de la duración de carga
        handler.postDelayed(() -> {
            timer.cancel();
            Intent intent = new Intent(LoadingAsteroidesActivity.this, JuegoActivity.class);
            startActivity(intent);
            finish();
        }, LOADING_DURATION);
    }
}
