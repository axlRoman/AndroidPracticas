package mx.itl.nc21130561.u4juegoasteroideapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity {

    private static final int LOADING_DURATION = 3000; // Duración de la pantalla de carga en milisegundos
    private static final int IMAGE_CHANGE_INTERVAL = 150; // Intervalo de cambio de imagen en milisegundos

    private ImageView loadingImage;
    private int[] imageArray = {R.drawable.carga1, R.drawable.carga2, R.drawable.carga3, R.drawable.carga4, R.drawable.carga1, R.drawable.carga2, R.drawable.carga3, R.drawable.carga4,
            R.drawable.carga1, R.drawable.carga2, R.drawable.carga3, R.drawable.carga4,R.drawable.carga1, R.drawable.carga2, R.drawable.carga3, R.drawable.carga4}; // Reemplaza con tus nombres de imágenes
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

        // Cambiar las imágenes periódicamente
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(() -> {
                    currentImageIndex = (currentImageIndex + 1) % imageArray.length;
                    loadingImage.setImageResource(imageArray[currentImageIndex]);
                });
            }
        }, 0, IMAGE_CHANGE_INTERVAL);

        // Iniciar la actividad del juego después de la duración de carga
        handler.postDelayed(() -> {
            timer.cancel();
            Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, LOADING_DURATION);
    }
}
