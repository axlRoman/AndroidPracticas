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

package mx.itl.nc19130971.u2cuadrosmensajeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //----------------------------------------------------------------------------------------------
    //Toast de duracion corta
    public void btnToastCortoClick(View v) {
        Toast.makeText(this, "Toast corto", Toast.LENGTH_SHORT).show();
    }
    //----------------------------------------------------------------------------------------------
    //Toast de duracion larga
    public void btnToastLargoClick (View v) {
        Toast.makeText(this, "Toast largo", Toast.LENGTH_LONG).show();
    }
    //----------------------------------------------------------------------------------------------
    //Snackbar de duracion corta
    public void btnSnackbarClick (View v) {
        Snackbar.make(v,"Snackbar de duracion corta", Snackbar.LENGTH_SHORT).show();
    }
    //----------------------------------------------------------------------------------------------
    // Cuadro de mensaje simple sin botones
    public void btnCuadroMensajeSimpleClick (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Cuadro de mensaje simple").create().show();
    }
    //----------------------------------------------------------------------------------------------
    //Cuadro de mensaje con boton aceptar
    public void btnMensajeOKClick (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mensaje con boton aceptar")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Click Aceptar");
                    }
                })
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    public void btnMensajeOKyCANCELClick (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Mensaje con botones Aceptar y Cancelar")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Click aceptar");
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Click cancelar");
                    }
                })
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    CharSequence colores [] = {"Verde", "Blanco", "Rojo", "Morado"};
    public void btnMensajeListaSimpleClick (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione: ")
                .setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Se selecciono un elemento de la lista
                        mostrarToast("Seleccione colores: " + colores[which]);
                    }
                })
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    public void btnMensajeOpcionesSelUnicaClick (View v) {
        int colorDefinitivo = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione un color: ")
                .setSingleChoiceItems(colores, colorDefinitivo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Color seleccionado: " + colores[which]);
                        //colorSeleccionado = which;
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Color definitivo: " + colores[which]);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cerrar el cuadro de mensaje explicitamente
                        dialog.dismiss();
                    }
                })
                .setCancelable(false) // anulamos que el cuadro se cierre al hacer tap fuera de el
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    //Cuadro de mensaje con lista de opciones con casillas de verificacion (checkboxes)
    boolean coloresDefault [] = {true, false, false, true};
    ArrayList<CharSequence> coloresFavoritos = new ArrayList<>();
    public void btnMensajeOpcionesSelMultipleClick (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccione sus colores favoritos:")
                .setMultiChoiceItems(colores, coloresDefault, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked) {
                            //Se marco un color favorito, agregarlo a los colores favoritos
                            coloresFavoritos.add(colores[which]);
                        } else {
                            //Se desmarco un color favorito, eliminarlo de colores favoritos
                            coloresFavoritos.remove(colores[which]);
                        }
                    }
                })
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarToast("Sus colores favoritos son: " + coloresFavoritos);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    //Cuadro mensaje con layout incrustado
    public void btnMensajeLayoutIncrustadoClick (View v) {
        View layout = getLayoutInflater().inflate(R.layout.login_layout, null);
        EditText usuario = layout.findViewById(R.id.edtUsuario);
        EditText contraseña = layout.findViewById(R.id.edtpContraseña);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acceso")
                .setIcon(R.drawable.itl)
                .setView(layout)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Obtener el usuario y contraseña tecleados
                        String usr = usuario.getText().toString();
                        String psw = contraseña.getText().toString();
                        mostrarToast("Usuario: "+usr + "\nContraseña: "+psw);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }
    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick (View v) {

    }
    //----------------------------------------------------------------------------------------------

    public void mostrarToast(CharSequence mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
}