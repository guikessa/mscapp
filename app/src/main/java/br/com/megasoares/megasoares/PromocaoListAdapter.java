package br.com.megasoares.megasoares;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.megasoares.megasoares.model.ProdutoPromocao;

/**
 * Created by guikessa on 23/07/17.
 */

public class PromocaoListAdapter extends ArrayAdapter<ProdutoPromocao> {

    private Context context;
    private ArrayList<ProdutoPromocao> list;

    public PromocaoListAdapter(Context context, ArrayList<ProdutoPromocao> list) {
        super(context, R.layout.content_promocao, list);
        this.list = list;
        this.context = context;
    }


    public static class ViewHolder {
        public TextView txtNomeProduto;
        public TextView txtPerceltualDesconto;
        public TextView txtPreco;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProdutoPromocao produtoPromocao = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.content_promocao, parent, false);
            viewHolder.txtNomeProduto = (TextView) convertView.findViewById(R.id.txtNomeProduto);
            viewHolder.txtPerceltualDesconto = (TextView) convertView.findViewById(R.id.txtPercentualDesconto);
            viewHolder.txtPreco = (TextView) convertView.findViewById(R.id.txtPreco);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtNomeProduto.setText(produtoPromocao.getNomeProduto());
        viewHolder.txtPerceltualDesconto.setText(produtoPromocao.getPercentualDesconto());
        viewHolder.txtPreco.setText(produtoPromocao.getPrecoProduto());

        return convertView;
    }
}
