/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luís Gabriel
 */
public class Fornecedor {
    
    private int id;
    private String nomeFornecedor;
    private String email;
    private String telefone;

    public Fornecedor(int id, String nomeFornecedor, String email, String telefone) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public class ProdutoFornecedor{
        private int idFornecedor;
        private int id;
        private String nomeProduto;	
        private String marcaProduto;
        private double precoProduto;

        public ProdutoFornecedor(int idFornecedor, int id, String nomeProduto, String marcaProduto, double precoProduto) {
            this.idFornecedor = idFornecedor;
            this.id = id;
            this.nomeProduto = nomeProduto;
            this.marcaProduto = marcaProduto;
            this.precoProduto = precoProduto;
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

        public double getPrecoProduto() {
            return precoProduto;
        }

        public void setPrecoProduto(double precoProduto) {
            this.precoProduto = precoProduto;
        }


        public int getIdFornecedor() {
            return idFornecedor;
        }

        public void setIdFornecedor(int idFornecedor) {
            this.idFornecedor = idFornecedor;
        }

    }
    
}
