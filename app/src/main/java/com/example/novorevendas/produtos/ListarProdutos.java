package com.example.novorevendas.produtos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.novorevendas.R;

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

        registerForContextMenu(listview);


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
                procuraProduto(s);
                return false;
            }
        });

        return true;
    }

    public void cadastrar(MenuItem item){
        Intent intent2 = new Intent(this, cadastrarProduto.class);
        startActivity(intent2);

    }  public void excluir (MenuItem item){
        AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
       final  Produtos produtosExcluir = produtosFiltros.get(menuinfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this ).setTitle("Atenção")
                .setMessage("Deseja excluir o produto?")
                .setNegativeButton("NÃO",null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        produtosFiltros.remove(produtosExcluir);
                        produtos.remove(produtosExcluir);
                        dao.excluir(produtosExcluir);
                        listview.invalidateViews();
                    }
                }).create();
        dialog.show();

    }   public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final  Produtos produtosAtualizar = produtosFiltros.get(menuinfo.position);
        Intent intent3 = new Intent(this, cadastrarProduto.class);
        intent3.putExtra("produtos", produtosAtualizar);
        startActivity(intent3);

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v , menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_context, menu);


    }
    public void procuraProduto (String nome){
        produtosFiltros.clear();
        for(Produtos p: produtos) {
            if (p.getNomeProduto().toLowerCase().contains(nome.toLowerCase())){
                produtosFiltros.add(p);

            }

            listview.invalidateViews();
        }


    }


    @Override
    public void onResume() {
        super.onResume();
        produtos = dao.obterTodos();
        produtosFiltros.addAll(produtos);
        listview.invalidateViews();

    }


}
