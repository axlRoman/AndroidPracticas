package mx.itl.nc21130561.u4juegoasteroideapp;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JuegoActivity extends AppCompatActivity implements SensorEventListener, VistaJuegoView.GameEventListener {
    private VistaJuegoView vistaJuegoView;
    private MediaPlayer mplayAudioFondo;
    private MediaPlayer mplayAudioDisparo;

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float lastX, lastY, lastZ;

    private int disparos = 0;
    private int aciertos = 0;

    private SharedPreferences sharedPreferences;
    private String currentGameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Obtener el tema seleccionado
        SharedPreferences configuracion = getSharedPreferences("configuracion", MODE_PRIVATE);
        String tema = configuracion.getString("tema", "asteroides");
        if (tema.equals("asteroides")) {
            setContentView(R.layout.juego_layout_asteroides);
        } else {
            setContentView(R.layout.juego_layout_oswi_vs_android);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        vistaJuegoView = findViewById(R.id.vistaJuegoView);

        if (tema.equals("asteroides")) {
            mplayAudioFondo = MediaPlayer.create(this, R.raw.audio_fondo);
            mplayAudioDisparo = MediaPlayer.create(this, R.raw.audio_disparo);
        } else {
            mplayAudioFondo = MediaPlayer.create(this, R.raw.pacman);
            mplayAudioDisparo = MediaPlayer.create(this, R.raw.latigo);
        }

        mplayAudioFondo.setLooping(true);
        vistaJuegoView.setMplayAudioDisparo(mplayAudioDisparo);

        // Inicializar el sensor del acelerómetro
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                Toast.makeText(this, "Acelerómetro no disponible", Toast.LENGTH_SHORT).show();
            }
        }

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("registros", MODE_PRIVATE);
        iniciarNuevoJuego();

        // Configurar el listener para eventos del juego
        vistaJuegoView.setGameEventListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mplayAudioFondo != null) mplayAudioFondo.start();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mplayAudioFondo != null) mplayAudioFondo.pause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        if (mplayAudioFondo != null) mplayAudioFondo.stop();
        if (mplayAudioFondo != null) mplayAudioFondo.stop();

        vistaJuegoView.setCorriendo(false);
        VistaJuegoThread hilo = vistaJuegoView.getVistaJuegoThread();
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Log.e("Asteroide", ex.toString());
        }
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            vistaJuegoView.actualizarPosicion(x, y);

            lastX = x;
            lastY = y;
            lastZ = z;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Puedes manejar cambios en la precisión del sensor aquí si es necesario.
    }

    private void iniciarNuevoJuego() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        currentGameKey = currentDateandTime;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(currentGameKey, currentDateandTime + "     Disparos: 0     Aciertos: 0");
        editor.apply();
    }

    private void actualizarRegistro() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String registroActualizado = currentGameKey + "     Disparos: " + disparos + "     Aciertos: " + aciertos;
        editor.putString(currentGameKey, registroActualizado);
        editor.apply();
    }

    @Override
    public void onDisparoRealizado() {
        disparos++;
        actualizarRegistro();
    }

    @Override
    public void onAciertoRealizado() {
        aciertos++;
        actualizarRegistro();
    }
}
