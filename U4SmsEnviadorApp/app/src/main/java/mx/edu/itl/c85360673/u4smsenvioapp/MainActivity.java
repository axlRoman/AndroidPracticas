package mx.edu.itl.c85360673.u4smsenvioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTelefonoDestino;
    private EditText edtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTelefonoDestino = findViewById ( R.id.edtTelefonoDestino );
        edtMensaje         = findViewById ( R.id.edtMensaje         );
    }
    public void btnEnviarClick(View v) {
        if (validarDatos()) {
            String telefonoDestino = edtTelefonoDestino.getText().toString();
            String mensaje = edtMensaje.getText().toString();

            enviarMensaje(telefonoDestino, mensaje);
            edtMensaje.setText("");
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarDatos() {
        String telefonoDestino = edtTelefonoDestino.getText().toString();
        String mensaje = edtMensaje.getText().toString();

        return !telefonoDestino.isEmpty() && !mensaje.isEmpty();
    }

    private void enviarMensaje(String telefonoDestino, String mensaje) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefonoDestino, null, mensaje, null, null);
            Toast.makeText(this, "Mensaje enviado a " + telefonoDestino, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al enviar el mensaje", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}


