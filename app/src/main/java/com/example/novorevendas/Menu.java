package com.example.novorevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {



    private Button btClientes, btProdutos, btFinanceiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btClientes = findViewById(R.id.cmdClientes);
        btClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btProdutos = findViewById(R.id.cmdProdutos);
                btProdutos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        btFinanceiro = findViewById(R.id.cmdFinanceiro);
                        btFinanceiro.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });

                        Intent intent = new Intent(getApplicationContext(),menuProdutos.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}