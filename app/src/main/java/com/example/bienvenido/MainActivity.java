package com.example.bienvenido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private EditText txtNombre;
        private static final int SUMA_REQUEST = 1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtNombre = findViewById(R.id.txtNombre);
        }

        public void oyente_btn_entrar(View view) {
            Log.d("Debug_bienvenido", "Se pulsó el botón Entrar");
            //Lanzar la segunda Activity
            Intent i = new Intent(this, SumarActivity.class);
            i.putExtra("usuario", txtNombre.getText().toString());
            startActivityForResult(i, SUMA_REQUEST);


        }
        protected void onActivityResult(int requestCode, int resultCode, Intent data)
        {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == SUMA_REQUEST){
                if (resultCode == RESULT_OK){
                    Toast.makeText(this,"Resultado de la suma..."+data.getStringExtra("resultado"),Toast.LENGTH_LONG).show();
                }
            }
        }
    }
