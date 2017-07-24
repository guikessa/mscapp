package br.com.megasoares.megasoares.model;

/**
 * Created by guikessa on 23/07/17.
 */

public class ProdutoPromocao {

    private String percentualDesconto = "15%";
    private String imagemProduto;
    private String nomeProduto = "Iphone 7";
    private String precoProduto = "R$ 3.999,00";

    public ProdutoPromocao() {
    }

    public static ProdutoPromocao of() {
        return new ProdutoPromocao();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoPromocao that = (ProdutoPromocao) o;

        return nomeProduto != null ? nomeProduto.equals(that.nomeProduto) : that.nomeProduto == null;

    }

    @Override
    public int hashCode() {
        return nomeProduto != null ? nomeProduto.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProdutoPromocao{" +
                "nomeProduto='" + nomeProduto + '\'' +
                '}';
    }

    public String getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(String percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(String precoProduto) {
        this.precoProduto = precoProduto;
    }
}
