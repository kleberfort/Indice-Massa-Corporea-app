package com.example.indicedemassacorporeaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPeso, edtAltura, edtResultado;
    private Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        edtResultado = findViewById(R.id.edtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        //ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);

    }

    //TRATADOR DE EVENTOS
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalcular){
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso/Math.pow(altura,2));

            edtResultado.setText(String.format("%.2f", resultado));

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("IMC= %.2f", resultado));
            dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dlg.show();

        }else{
            if(v.getId() == R.id.btnLimpar){
                edtPeso.setText("");
                edtAltura.setText("");
                edtResultado.setText("");
                edtPeso.requestFocus();

                Toast.makeText(this,"Os dados foram apagagados com sucessso",
                        Toast.LENGTH_LONG).show();
            }
        }

    }



}
