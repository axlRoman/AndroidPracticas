package mx.itl.nc19130971.u2cuadrosmensajeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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
    public void btnMensajeListaSimpleClick (View v) {

    }
    //----------------------------------------------------------------------------------------------
    public void btnMensajeOpcionesSelUnicaClick (View v) {

    }
    //----------------------------------------------------------------------------------------------
    public void btnMensajeOpcionesSelMultipleClick (View v) {

    }
    //----------------------------------------------------------------------------------------------
    public void btnMensajeLayoutIncrustadoClick (View v) {

    }
    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick (View v) {

    }
    //----------------------------------------------------------------------------------------------

    public void mostrarToast(CharSequence mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
}