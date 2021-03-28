package com.example.bienvenido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SumarActivity extends AppCompatActivity {
    private EditText txt_primervalor;
    private EditText txt_segundovalor;
    private TextView lbl_resultado;

    private int sumando1, sumando2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);
        //Obtenemos las referencias a los elementos gráficos de la GUI
        txt_primervalor=findViewById(R.id.txt_primervalor);
        txt_segundovalor=findViewById(R.id.txt_segundovalor);
        lbl_resultado=findViewById(R.id.lbl_resultado);

        Bundle bundle=getIntent().getExtras();
        Log.d("Debug_bienvenido","Valor recibido:"+bundle.getString("usuario"));
        Toast notificacion;
        notificacion = Toast.makeText(this, "Hola "+bundle.getString("usuario"),
                Toast.LENGTH_LONG);
        notificacion.show();
    }
    public void oyente_btnSumar(View view){
        Log.d("Debug_bienvenido","Se pulsó el botón Sumar");
        sumando1 = sumando2 = 0;
        if (!txt_primervalor.getText().toString().equals("")) {
            sumando1 = Integer.parseInt(txt_primervalor.getText().toString());
        }
        if (!txt_segundovalor.getText().toString().equals("")) {
            sumando2 = Integer.parseInt(txt_segundovalor.getText().toString());
            lbl_resultado.setText(String.valueOf(sumando1 + sumando2));
        }
    }
    public void oyente_btnVolver(View view){
        Log.d("Debug_bienvenido","Se pulsó el botón Volver");
        Intent resultado = new Intent();
        resultado.putExtra("resultado",lbl_resultado.getText().toString());
        setResult(RESULT_OK, resultado);
        finish();
    }
}