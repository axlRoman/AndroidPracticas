package mx.itl.nc21130561.u4juegoasteroideapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Map;
import java.util.TreeMap;

public class RegistroActivity extends AppCompatActivity {

    private TextView registrosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrosTextView = findViewById(R.id.registros_text_view);

        SharedPreferences sharedPreferences = getSharedPreferences("registros", MODE_PRIVATE);
        Map<String, ?> registros = sharedPreferences.getAll();

        // Usar TreeMap para ordenar los registros por clave en orden inverso
        TreeMap<String, String> sortedRegistros = new TreeMap<>((a, b) -> b.compareTo(a));
        for (Map.Entry<String, ?> entry : registros.entrySet()) {
            sortedRegistros.put(entry.getKey(), (String) entry.getValue());
        }

        StringBuilder registrosBuilder = new StringBuilder();
        registrosBuilder.append("Fecha     Hora     Disparos     Aciertos\n");

        for (Map.Entry<String, String> entry : sortedRegistros.entrySet()) {
            registrosBuilder.append(entry.getValue()).append("\n");
        }

        registrosTextView.setText(registrosBuilder.toString());
    }
}
