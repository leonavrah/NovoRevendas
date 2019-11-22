package com.example.novorevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuProdutos extends AppCompatActivity {

    private Button btNovoProduto, btConsultarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_produtos);

        btNovoProduto = findViewById(R.id.cmdNovoProduto);
        btNovoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), cadastrarProduto.class);
                startActivity(intent);
            }

        });

        btConsultarProduto = findViewById(R.id.cmdConsultarproduto);
        btConsultarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent (getApplicationContext(), ListarProdutos.class);
                startActivity(intent2);
            }
        });
    }
}
