/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2024    HORA: 08-09 HRS
:*
                  Activity que despliega la bandera de Canada
:*
:*  Autor       : Francisco Axel Roman Cardoza     19130971
:*  Fecha       : 20/Feb/2024
:*  Compilador  : Android Studio Hedgehog
:*  Descripción : Este activity despliega la bandera de Canada y contiene
                  Solo un boton para regresar al activity anterior
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.itl.nc19130971.u2banderas3lay3actapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Bandera3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandera_canada);
        Toast.makeText(this, "Canada: onCreate();", Toast.LENGTH_SHORT).show();

    }

    public void btnAccionClick(View v) {
        if (v.getId() == R.id.btnCanadaAntClick){
            finish();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Canada: onStart();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Canada: onResume();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Canada: onPause();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Toast.makeText(this, "Canada: onStop();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Canada: onDestroy();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(this, "Canada: onRestart();", Toast.LENGTH_SHORT).show();
    }
}