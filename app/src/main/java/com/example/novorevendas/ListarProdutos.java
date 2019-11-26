package com.example.novorevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_produtos, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                System.out.println("Digitou" +s);
                return false;
            }
        });

        return true;
    }

    public void cadastrar(MenuItem item){
        Intent intent2 = new Intent(this,cadastrarProduto.class);
        startActivity(intent2);
    }

    @Override
    public void onResume() {
        super.onResume();
        produtos = dao.obterTodos();
        produtosFiltros.addAll(produtos);
        listview.invalidateViews();

    }


}
