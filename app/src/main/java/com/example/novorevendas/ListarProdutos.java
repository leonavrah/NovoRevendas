package com.example.novorevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarProdutos extends AppCompatActivity {

    private ListView listview;
    private ProdutoDAO dao;
    private List<Produtos> produtos;
    private List<Produtos> produtosFiltros = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listview = findViewById(R.id.listaProdutos);
        dao = new ProdutoDAO(this);
        produtos = dao.obterTodos();
        produtosFiltros.addAll(produtos);

        //ArrayAdapter<Produtos> adaptador = new ArrayAdapter<Produtos>(this, android.R.layout.simple_list_item_1, produtos);
        ProdutoAdapter adaptador = new ProdutoAdapter(this,produtosFiltros);
        listview.setAdapter(adaptador);



    }
}
