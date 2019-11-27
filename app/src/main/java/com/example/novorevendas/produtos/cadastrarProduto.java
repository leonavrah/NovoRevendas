package com.example.novorevendas.produtos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.novorevendas.R;

public class cadastrarProduto extends AppCompatActivity {

    private EditText edNomeProduto, edValorProduto, edDescricaoProduto;
    private EditText edTipoProduto;
    private ProdutoDAO dao;
    private Produtos produto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        edNomeProduto = findViewById(R.id.txtNomeProduto);
        edValorProduto = findViewById(R.id.txtValorProduto);
        edDescricaoProduto = findViewById(R.id.txtDescricaoProduto);
        edTipoProduto = findViewById(R.id.txtTipoProduto);
        dao = new ProdutoDAO(this);

        Intent it = getIntent();
        if (it.hasExtra("produtos")){
            produto = (Produtos) it.getSerializableExtra("produtos");
            edNomeProduto.setText(produto.getNomeProduto());
            edValorProduto.setText(produto.getValorProduto());
            edTipoProduto.setText(produto.getTipoProduto());
            edDescricaoProduto.setText(produto.getDescricaoProduto());

        }
    }

    public void salvar (View view){

        if (produto == null){

        produto = new Produtos();
        produto.setNomeProduto(edNomeProduto.getText().toString());
        produto.setValorProduto(edValorProduto.getText().toString());
        produto.setDescricaoProduto(edDescricaoProduto.getText().toString());
        produto.setTipoProduto(edTipoProduto.getText().toString());
        long id = dao.inserir(produto);
        Toast.makeText(this,"Produto Cadastrado com Sucesso: " + id, Toast.LENGTH_SHORT).show();
    }  else {
            produto.setNomeProduto(edNomeProduto.getText().toString());
            produto.setValorProduto(edValorProduto.getText().toString());
            produto.setDescricaoProduto(edDescricaoProduto.getText().toString());
            produto.setTipoProduto(edTipoProduto.getText().toString());
            dao.atualizar(produto);
            Toast.makeText(this, "Produto alterado com sucesso!", Toast.LENGTH_SHORT);
        }

    }
}
