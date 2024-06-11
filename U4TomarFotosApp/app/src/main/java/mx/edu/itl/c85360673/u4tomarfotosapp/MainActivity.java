/*:
 *: Requiere: <uses-permission android:name="android.permission.CAMERA"/>
 *:           <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 *:           <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 *:
 *: Requiere agregar lo siguiente en el AndroidManifest.xml:
 *:
 *:        <provider
 *:             android:name="androidx.core.content.FileProvider"
 *:             android:authorities="mx.edu.itl.c85360673.u4tomarfotosapp.provider"
 *:             android:exported="false"
 *:             android:grantUriPermissions="true">
 *:             <!-- ressource file to create -->
 *:             <meta-data
 *:                 android:name="android.support.FILE_PROVIDER_PATHS"
 *:                 android:resource="@xml/file_paths">
 *:             </meta-data>
 *:        </provider>
 *:
 *: Requiere crear el archivo  file_paths.xml  en la carpeta de recursos xml :
 *:
 *:          <?xml version="1.0" encoding="utf-8"?>
 *:          <paths xmlns:android="http://schemas.android.com/apk/res/android">
 *:                <external-path name="external_files" path="." />
 *:          </paths>
 *:
 */


package mx.edu.itl.c85360673.u4tomarfotosapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import util.permisos.ChecadorDePermisos;
import util.permisos.PermisoApp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private PermisoApp [] permisosReq = {
            new PermisoApp  ( Manifest.permission.CAMERA, "Camara", true  ),
            new PermisoApp  ( Manifest.permission.READ_EXTERNAL_STORAGE, "Almacenamiento", true  ),
            new PermisoApp  ( Manifest.permission.WRITE_EXTERNAL_STORAGE, "Almacenamiento", true )
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChecadorDePermisos.checarPermisos ( this, permisosReq );
    }

    public void btnCapturaSimpleClick ( View v ) {
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );

        if ( requestCode == ChecadorDePermisos.CODIGO_PEDIR_PERMISOS ) {
            ChecadorDePermisos.verificarPermisosSolicitados ( this, permisosReq, permissions, grantResults );
        }
    }

    public void btnCapturaOpcionesClick (View v ) {
        Intent intent = new Intent ( this, CamaraActivity.class ) ;
        startActivity ( intent );
    }
}
