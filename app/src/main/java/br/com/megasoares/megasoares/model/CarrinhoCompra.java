package br.com.megasoares.megasoares.model;

import java.util.List;

/**
 * Created by guikessa on 23/07/17.
 */

public class CarrinhoCompra {

    private List<ProdutoPromocao> produtos;

    private CarrinhoCompra() {
    }

    public static CarrinhoCompra of() {
        return new CarrinhoCompra();
    }

    public List<ProdutoPromocao> getProdutos() {
        return produtos;
    }

    public void add(ProdutoPromocao produtoPromocao) {

    }

}
