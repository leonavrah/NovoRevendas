package com.example.novorevendas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Conexao conexao;
    private SQLiteDatabase  banco;

    public ProdutoDAO (Context context){

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Produtos produtos) {
        ContentValues values = new ContentValues();
        values.put("nome",produtos.getNomeProduto());
        values.put("valor",produtos.getValorProduto());
        values.put("tipo",produtos.getTipoProduto());
        values.put("descricao",produtos.getDescricaoProduto());
      return banco.insert("produto", null, values);

    }

    public List<Produtos> obterTodos(){
        List<Produtos> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produto", new String[]{"id","nome","valor","tipo","descricao"},null,null, null,
                null,null);

        while(cursor.moveToNext()){
            Produtos p = new Produtos();
            p.setId(cursor.getInt(0));
            p.setNomeProduto(cursor.getString(1));
            p.setValorProduto(cursor.getString(2));
            p.setTipoProduto(cursor.getString(3));
            p.setDescricaoProduto(cursor.getString(4));
            produtos.add(p);


        }

        return produtos;
    }
}
