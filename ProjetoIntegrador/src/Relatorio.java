/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisg_000
 */
public class Relatorio {
    
    private int id;
    private String nomeFornecedor;
    private String nomeProduto;
    private String marcaProduto;
    private String dataCompra;
    private double precoProduto;
    private int quantComprada;
    private double valorCompra;

    public Relatorio(int id, String nomeFornecedor, String nomeProduto, String marcaProduto, String dataCompra, double precoProduto, int quantComprada, double valorCompra) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.dataCompra = dataCompra;
        this.precoProduto = precoProduto;
        this.quantComprada = quantComprada;
        this.valorCompra = valorCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantComprada() {
        return quantComprada;
    }

    public void setQuantComprada(int quantComprada) {
        this.quantComprada = quantComprada;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "id=" + id + ", nomeFornecedor=" + nomeFornecedor + ", nomeProduto=" + nomeProduto + ", marcaProduto=" + marcaProduto + ", dataCompra=" + dataCompra + ", precoProduto=" + precoProduto + ", quantComprada=" + quantComprada + ", valorCompra=" + valorCompra + '}';
    }
    
    
    
}
