package com.example.novorevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class cadastrarProduto extends AppCompatActivity {

    private EditText edNomeProduto, edValorProduto, edDescricaoProduto;
    private Spinner spnTipoProduto;
    private ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        edNomeProduto = findViewById(R.id.txtNomeProduto);
        edValorProduto = findViewById(R.id.txtValorProduto);
        edDescricaoProduto = findViewById(R.id.txtDescricaoProduto);
        dao = new ProdutoDAO(this);

    }

    public void salvar (View view){

        Produtos p = new Produtos();
        p.setNomeProduto(edNomeProduto.getText().toString());
        p.setValorProduto(edValorProduto.getText().toString());
        p.setDescricaoProduto(edDescricaoProduto.getText().toString());
        long id = dao.inserir(p);
        Toast.makeText(this,"Produto Cadastrado com Sucesso: " + id, Toast.LENGTH_SHORT).show();

    }
}
