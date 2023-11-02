package com.example.practica_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);

        new CountDownTimer(5000, 1000) { // 5000 milisegundos = 5 segundos

            public void onTick(long millisUntilFinished) {
                txt1.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        }.start();
    }
}