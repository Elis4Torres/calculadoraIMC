package com.example.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        EditText editPeso, editAltura;
        TextView result, resultNum;
        RadioButton sexoM, sexoF;
        double peso = 0.0;
        double altura = 0.0;
        boolean sexo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            editPeso = findViewById(R.id.txtPeso);
            editAltura = findViewById(R.id.txtAltura);
            result = findViewById(R.id.txtResultado);
            resultNum = findViewById(R.id.txtNum);
            sexoM = findViewById(R.id.rdnMasc);
            sexoF = findViewById(R.id.rdnFemi);
        }

        public void CalcularIMC(View view) {
            peso = Double.parseDouble(editPeso.getText().toString());
            altura = Double.parseDouble(editAltura.getText().toString());

            double resultado = peso/(altura*altura);
            resultNum.setText(Double.valueOf(resultado).toString());
            if (sexoM.isChecked()) {
                if(resultado < 20){
                    result.setText("Abaixo do peso normal");
                } else if(resultado >= 20 && resultado <= 24.9) {
                    result.setText("Normal");
                } else if(resultado >= 25 && resultado <= 29.9){
                    result.setText("Obesidade Leve");
                } else if(resultado >= 30 && resultado <= 39.9) {
                    result.setText("Obesidade Moderada");
                } else if(resultado >= 43) {
                    result.setText("Obesidade Mórbida");
                }
            } else if(sexoM.isChecked() == false && sexoF.isChecked() == true) {
                if(resultado < 19){
                    result.setText("Abaixo do peso normal");
                } else if(resultado >= 19 && resultado <= 23.9) {
                    result.setText("Normal");
                } else if(resultado >= 24 && resultado <= 28.9){
                    result.setText("Obesidade Leve");
                } else if(resultado >= 29 && resultado <= 38.9) {
                    result.setText("Obesidade Moderada");
                } else if(resultado >= 39) {
                    result.setText("Obesidade Mórbida");
                }

            }
        }
    }
