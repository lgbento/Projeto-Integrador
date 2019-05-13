
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisg_000
 */
public class ItemPedido {
    private int id;
    private int idPrCliente;
    private int idFornecedor;
    private String dataCompleta;
    private double precoProduto;
    private int quantComprada;
    private double valorCompra;

    public ItemPedido(int id, int idPrCliente, int idFornecedor, String dataCompleta, double precoProduto, int quantComprada, double valorCompra) {
        this.id = id;
        this.idPrCliente = idPrCliente;
        this.idFornecedor = idFornecedor;
        this.dataCompleta = dataCompleta;
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

    public int getIdPrCliente() {
        return idPrCliente;
    }

    public void setIdPrCliente(int idPrCliente) {
        this.idPrCliente = idPrCliente;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getDataCompleta() {
        return dataCompleta;
    }

    public void setDataCompleta(String dataCompleta) {
        this.dataCompleta = dataCompleta;
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

    
    
   
}
