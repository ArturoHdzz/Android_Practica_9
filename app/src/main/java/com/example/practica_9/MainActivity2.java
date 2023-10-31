package com.example.practica_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;

import com.example.practica_9.adapter.PermisoAdapter;
import com.example.practica_9.model.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setContentView(R.layout.activity_main);

        List<Permiso> Lista_permisos = new ArrayList<>();
        Lista_permisos.add(new Permiso("Camara", "Permite el acceso a la camara", android.Manifest.permission.CAMERA));
        Lista_permisos.add(new Permiso("Contactos", "Permite el acceso a los contactos", android.Manifest.permission.READ_CONTACTS));
        Lista_permisos.add(new Permiso("Llamar", "Permite el acceso a la llamada", Manifest.permission.CALL_PHONE));

        PermisoAdapter pa = new PermisoAdapter(Lista_permisos);
        RecyclerView rc = findViewById(R.id.rcPermisos);
        rc.setAdapter(pa);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);
    }
}