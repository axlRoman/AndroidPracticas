package mx.itl.nc19130971.u2banderas3lay1actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mexico);
    }

    public void btnAccionClick(View v){
        if(v.getId() == R.id.btnSalirClick){
            finish();
        } else if(v.getId() == R.id.btnMexicoSig){
            //Mostrar Bandera Grecia
            setContentView(R.layout.grecia);
        } else if (v.getId() == R.id.btnGreciaAntClic){
            //Mostrar Bandera Mexico
            setContentView(R.layout.mexico);
        } else if (v.getId() == R.id.btnGreciaSigClick){
            //Mostrar bandera canada
            setContentView(R.layout.canada);
        } else if(v.getId() == R.id.btnCanadaAntClick){
            setContentView(R.layout.grecia);
        }
    }
}