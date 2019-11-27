package com.example.novorevendas.produtos;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.novorevendas.R;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    private List<Produtos> produtos;
    private Activity activity;


    public ProdutoAdapter(Activity activity, List<Produtos> produtos) {
       this.activity = activity;
       this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) {
        return produtos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return produtos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        TextView nome = v.findViewById(R.id.txNome);
        TextView valor = v.findViewById(R.id.txValor);
        TextView tipo = v.findViewById(R.id.txTipo);
        TextView descricao = v.findViewById(R.id.txDescricao);

        Produtos p = produtos.get(i);

        nome.setText(p.getNomeProduto());
        valor.setText(p.getValorProduto());
        tipo.setText(p.getTipoProduto());
        descricao.setText(p.getDescricaoProduto());

        return v;
    }
}
