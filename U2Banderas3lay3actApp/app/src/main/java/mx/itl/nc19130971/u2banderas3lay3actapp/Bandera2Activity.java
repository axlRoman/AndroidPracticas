/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2024    HORA: 08-09 HRS
:*
                  Activity que despliega la bandera de Grecia
:*
:*  Autor       : Francisco Axel Roman Cardoza     19130971
:*  Fecha       : 20/Feb/2024
:*  Compilador  : Android Studio Hedgehog
:*  Descripción : Este activity despliega la bandera de Grecia y contiene
                  botones para regresar al anterior activity y otro para pasar a un
                  tercer activity con la bandera de Canada
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

public class Bandera2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandera_grecia);
        Toast.makeText(this, "Grecia: onCreate();", Toast.LENGTH_SHORT).show();


    }

    public void btnAccionClick(View v) {
        if (v.getId() == R.id.btnGreciaAntClic){
            finish();
        } else if( v.getId() == R.id.btnGreciaSigClick) {
            Intent intent = new Intent(this, Bandera3Activity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Grecia: onStart();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Grecia: onResume();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Grecia: onPause();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Toast.makeText(this, "Grecia: onStop();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Grecia: onDestroy();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(this, "Grecia: onRestart();", Toast.LENGTH_SHORT).show();
    }
}

