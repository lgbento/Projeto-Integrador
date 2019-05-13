

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luís Gabriel
 */
public class ProdutoEstoque {
    
    private int id;
    private String nomeProduto;
    private String marcaProduto;
    private int quantidade;
    private int quantMinima;
    private double precoMedia;
    private double valorTotal;

    public ProdutoEstoque(int id, String nomeProduto, String marcaProduto, int quantidade, int quantMinima, double precoMedia, double valorTotal) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.quantidade = quantidade;
        this.quantMinima = quantMinima;
        this.precoMedia = precoMedia;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantMinima() {
        return quantMinima;
    }

    public void setQuantMinima(int quantMinima) {
        this.quantMinima = quantMinima;
    }

    public double getPrecoMedia() {
        return precoMedia;
    }

    public void setPrecoMedia(double precoMedia) {
        this.precoMedia = precoMedia;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void adicionaEstoque(){
        
    }
    public void removeEstoque(){
        
    }
    

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProduto=" + nomeProduto + ", marcaProduto=" + marcaProduto + ", quantidade=" + quantidade + ", quantMinima=" + quantMinima + ", precoMedia=" + precoMedia + ", valorTotal=" + valorTotal + '}';
    }
    
    
}
