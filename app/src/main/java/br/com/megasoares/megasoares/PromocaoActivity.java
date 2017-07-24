package br.com.megasoares.megasoares;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.megasoares.megasoares.model.ProdutoPromocao;

public class PromocaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocao);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ImageButton imgCarrinho = (ImageButton) findViewById(R.id.imgCarrinho);
        imgCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PromocaoActivity.this, "Carrinho", Toast.LENGTH_SHORT).show();
            }
        });

        GridView listView = (GridView) findViewById(R.id.list);
        PromocaoListAdapter adapter = new PromocaoListAdapter(this, getProdutoPromocaoList());
        listView.setAdapter(adapter);
    }


    private ArrayList<ProdutoPromocao> getProdutoPromocaoList() {
        ArrayList list =  new ArrayList<ProdutoPromocao>();

        for (int i = 0; i <= 50; i++) {
            list.add(ProdutoPromocao.of());
        }

        return list;
    }
}
