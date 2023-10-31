package com.example.practica_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        verificar();
    }

    private void verificar() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int Permiso2 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        int Permiso3 = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE   );
        if(permiso == PackageManager.PERMISSION_GRANTED && Permiso2 == PackageManager.PERMISSION_GRANTED && Permiso3 == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Tienes permiso", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{android.Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        }
    }
}