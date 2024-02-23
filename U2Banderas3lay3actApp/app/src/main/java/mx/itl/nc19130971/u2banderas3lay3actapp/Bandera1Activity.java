/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2024    HORA: 08-09 HRS
:*
                  Activity que despliega la bandera de mexico
:*
:*  Autor       : Francisco Axel Roman Cardoza     19130971
:*  Fecha       : 20/Feb/2024
:*  Compilador  : Android Studio Hedgehog
:*  Descripción : Este activity despliega la bandera de Mexico y contiene
                  botones para salir de la app y otro para pasar a un
                  segundo activity con la bandera de Grecia
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

public class Bandera1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bandera_mexico);
        Toast.makeText(this, "Mexico: onCreate();", Toast.LENGTH_SHORT).show();
    }

    public void btnAccionClick(View v){
        if(v.getId() == R.id.btnSalirClick){
            finish();
        } else if(v.getId() == R.id.btnMexicoSig){
            //Mostrar Bandera Grecia
            Intent  intent = new Intent(this,Bandera2Activity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Mexico: onStart();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Mexico: onResume();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Mexico: onPause();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Toast.makeText(this, "Mexico: onStop();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "Mexico: onDestroy();", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast.makeText(this, "Mexico: onRestart();", Toast.LENGTH_SHORT).show();
    }

}