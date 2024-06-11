package mx.edu.itl.c85360673.u4reproaudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
            implements View.OnTouchListener {


    private Button btnFiesta;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiesta = findViewById ( R.id.btnFiesta );

        btnFiesta.setOnTouchListener(this);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v.getId() == R.id.btnFiesta){
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    reproducir_audio();
                    break;
                case MotionEvent.ACTION_UP:
                    detener_audio();
                    break;
            }
        }

        return false;
    }

    private void reproducir_audio(){
        if(mp==null){
            mp = MediaPlayer.create(this, R.raw.tropicalisimo);
        }
        mp.start();
    }

    private void detener_audio(){
        if(mp != null)
            mp.stop();
        mp = null;
    }
}