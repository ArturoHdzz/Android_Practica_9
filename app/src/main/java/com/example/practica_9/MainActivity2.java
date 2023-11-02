package com.example.practica_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.practica_9.adapter.PermisoAdapter;
import com.example.practica_9.model.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements PermisoAdapter.PermissionRequester {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        verificar();

        List<Permiso> Lista_permisos = new ArrayList<>();
        Lista_permisos.add(new Permiso("Leer SMS", "Permite el acceso a los mensajes", Manifest.permission.READ_SMS));
        Lista_permisos.add(new Permiso("Contactos", "Permite el acceso a los contactos", Manifest.permission.READ_CONTACTS));
        Lista_permisos.add(new Permiso("Llamar", "Permite el acceso a la llamada", Manifest.permission.CALL_PHONE));

        PermisoAdapter pa = new PermisoAdapter(Lista_permisos);
        RecyclerView rc = findViewById(R.id.rcPermisos);
        rc.setAdapter(pa);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);
    }

    @Override
    public void requestPermission(String permission) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, 590);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int Permiso2 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int Permiso3 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permiso == PackageManager.PERMISSION_GRANTED && Permiso2 == PackageManager.PERMISSION_GRANTED && Permiso3 == PackageManager.PERMISSION_GRANTED){
            Intent i = new Intent(this, MainActivity3.class);
            startActivity(i);
        }
    }

    private void verificar() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int Permiso2 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int Permiso3 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(permiso == PackageManager.PERMISSION_GRANTED && Permiso2 == PackageManager.PERMISSION_GRANTED && Permiso3 == PackageManager.PERMISSION_GRANTED){
            Intent i = new Intent(this, MainActivity3.class);
            startActivity(i);
        }
    }
}