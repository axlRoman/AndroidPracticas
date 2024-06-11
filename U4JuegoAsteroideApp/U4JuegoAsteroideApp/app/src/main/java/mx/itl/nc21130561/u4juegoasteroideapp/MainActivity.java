package mx.itl.nc21130561.u4juegoasteroideapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private SharedPreferences sharedPreferences;
    private boolean isSubmenuVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layaut);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        sharedPreferences = getSharedPreferences("configuracion", MODE_PRIVATE);

        // Establecer el tema predeterminado si no hay ninguno guardado
        if (!sharedPreferences.contains("tema")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("tema", "asteroides");
            editor.apply();
        }

        // Si la actividad se inicia por primera vez, abrir el fragmento predeterminado
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_jugar);
        }

        TextView title = findViewById(R.id.title);
        title.setText(R.string.app_name);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_jugar){
            Intent jugarIntent = new Intent(MainActivity.this, JuegoActivity.class);
            startActivity(jugarIntent);
        }

        if (item.getItemId() == R.id.nav_configurar_tema) {
            findViewById(R.id.nav_asteroides).setVisibility(isSubmenuVisible ? View.VISIBLE : View.GONE);
            findViewById(R.id.nav_oswi_vs_android).setVisibility(isSubmenuVisible ? View.VISIBLE : View.GONE);
            isSubmenuVisible = !isSubmenuVisible;
        }

        if (item.getItemId() == R.id.nav_asteroides){
            SharedPreferences.Editor editorAsteroides = sharedPreferences.edit();
            editorAsteroides.putString("tema", "asteroides");
            editorAsteroides.apply();
        }
        if (item.getItemId() == R.id.nav_oswi_vs_android){
            SharedPreferences.Editor editorOswi = sharedPreferences.edit();
            editorOswi.putString("tema", "oswi_vs_android");
            editorOswi.apply();
        }
        if (item.getItemId() == R.id.nav_ver_registro){
            Intent registroIntent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(registroIntent);
        }
        if (item.getItemId() == R.id.nav_acerca_de){
            mostrarPopupAcercaDe();
        }
        if (item.getItemId() == R.id.nav_salir){
            finishAffinity();
        }

//        switch (item.getItemId()) {
//            case R.id.nav_jugar:
//                // Llamar a LoadingActivity cuando se selecciona "Jugar"
//                Intent jugarIntent = new Intent(MainActivity.this, LoadingActivity.class);
//                startActivity(jugarIntent);
//                break;
//            case R.id.nav_configurar_tema:
//                // Expandir o colapsar el submenú de "Configurar Tema"
//                isSubmenuVisible = !isSubmenuVisible;
//                findViewById(R.id.nav_asteroides).setVisibility(isSubmenuVisible ? View.VISIBLE : View.GONE);
//                findViewById(R.id.nav_oswi_vs_android).setVisibility(isSubmenuVisible ? View.VISIBLE : View.GONE);
//                break;
//            case R.id.nav_asteroides:
//                // Cambiar tema a "asteroides"
//                SharedPreferences.Editor editorAsteroides = sharedPreferences.edit();
//                editorAsteroides.putString("tema", "asteroides");
//                editorAsteroides.apply();
//                break;
//            case R.id.nav_oswi_vs_android:
//                // Cambiar tema a "OSWI vs Android"
//                SharedPreferences.Editor editorOswi = sharedPreferences.edit();
//                editorOswi.putString("tema", "oswi_vs_android");
//                editorOswi.apply();
//                break;
//            case R.id.nav_ver_registro:
//                // Llamar a RegistroActivity cuando se selecciona "Ver Registro"
//                Intent registroIntent = new Intent(MainActivity.this, RegistroActivity.class);
//                startActivity(registroIntent);
//                break;
//            case R.id.nav_acerca_de:
//                // Mostrar popup de "Acerca de"
//                mostrarPopupAcercaDe();
//                break;
//            case R.id.nav_salir:
//                // Salir de la aplicación
//                finishAffinity();
//                break;
//        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void mostrarPopupAcercaDe() {
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.acerca_de_popup, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);

        final AlertDialog dialog = builder.create();

        dialog.show();

        popupView.findViewById(R.id.btn_ok).setOnClickListener(v -> dialog.dismiss());
    }
}
