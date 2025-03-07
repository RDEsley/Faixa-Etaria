package com.example.faixaetaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvClassificacaoFaixaEtaria;
    EditText edtIdade;
    Button btnFaixaEtaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvClassificacaoFaixaEtaria = (TextView) findViewById(R.id.lblClassificacaoFaixaEtaria);
        edtIdade = (EditText) findViewById(R.id.txtIdade);
        btnFaixaEtaria = (Button) findViewById(R.id.cmdFaixaEtaria);

        btnFaixaEtaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int idade;
                    String faixaEtaria;
                    idade = Integer.parseInt(edtIdade.getText().toString());

                    if ((idade > 0) && (idade <= 12)) {
                        faixaEtaria = "Essa é a idade de uma Criança";
                    }
                    else if ((idade > 12) && (idade <= 18)) {
                        faixaEtaria = "Essa é a idade de um Adolescente";
                    }
                    else if ((idade > 18) && (idade <= 59)) {
                        faixaEtaria = "Essa é a idade de um Adulto";
                    }
                    else if ((idade > 60) && (idade < 110)){
                        faixaEtaria = "Essa é a idade de um Idoso";
                    }
                    else {
                        faixaEtaria = "Idade inválido";
                    }
                    tvClassificacaoFaixaEtaria.setText(faixaEtaria);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Ocorreu um erro Inesperado. \nInforme uma idade válida, apenas números positivos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}