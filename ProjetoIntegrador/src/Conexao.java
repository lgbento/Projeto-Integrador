
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luís Gabriel
 */
public class Conexao {
        
    public static boolean conectLogin(String login, String senha){
        boolean logar = false;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("select * from usuarios where login = ? and senha = ?");
            consulta.setString(1,login);
            consulta.setString(2,senha);
            ResultSet usuarios = consulta.executeQuery();
            
            if(usuarios.next()){
                logar = true;
            }else{
               logar = false;
            }
             
        } catch (Exception ex) {
            
            System.out.println("Conexão com o Banco de Dados Indisponível!");    
        }
    return logar;
    
    }
    public static int cadastraProdutoEstoque(String nomeProduto, String marcaProduto,
            int quantidade, int quantMinima, double preco, double valorTotal){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("INSERT INTO produto_estoque(nomeProduto, "
                    + "marcaProduto, quantidade, quantMinima, preco, valorTotal) VALUES(?,?,?,?,?,?)");
            
            stmt.setString(1, nomeProduto);
            stmt.setString(2, marcaProduto);
            stmt.setInt(3, quantidade);
            stmt.setInt(4, quantMinima);
            stmt.setDouble(5, preco);
            stmt.setDouble(6, valorTotal);
            
            stmt.executeUpdate();
            
            
            stmt = (PreparedStatement) conn.prepareStatement("SELECT id FROM produto_estoque WHERE nomeProduto = ? AND marcaProduto = ?");
            
            stmt.setString(1, nomeProduto);
            stmt.setString(2, marcaProduto);
            ResultSet resultado = stmt.executeQuery();
            
            int id = 0;
            while(resultado.next()){
                id = resultado.getInt("id");
            }
            
            JOptionPane.showMessageDialog(null, "Produto cadstrado com sucesso!");
           
            return id;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!");
            int id = 0;
            return id;
        }
        
    }
    
    public static void cadastraProdutoFornecedor(int idFornecedor, String nomeProduto, String marcaProduto,
            double precoProduto){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into produto_fornecedor(idFornecedor, "
                    + "nomeProduto, marcaProduto,precoProduto) values(?,?,?,?)");
        
            consulta.setInt(1, idFornecedor);
            consulta.setString(2, nomeProduto);
            consulta.setString(3, marcaProduto);
            consulta.setDouble(4, precoProduto);
            
            consulta.executeUpdate();
      
            
            JOptionPane.showMessageDialog(null, "Produto do fornecedor cadastrado com sucesso!");
            
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro do Produto no Fornecedor!");      
        } 
    }
    
      public static void cadastraFornecedor(String nomeFornecedor, String email,
            String telefone){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into fornecedor(nomeFornecedor, "
                    + "email, telefone) values(?,?,?)");
        
            consulta.setString(1, nomeFornecedor);
            consulta.setString(2, email);
            consulta.setString(3, telefone);
            
            consulta.executeUpdate();
            
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!");   
        }
    }
    
         public static void cadastraPedido(int idPrClienteTemp,int idFornecedorTemp,String dataTemp,double precoProdutoTemp,int quantCompradaTemp,double valorCompraTemp){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("INSERT INTO pedido(idPrCliente,idFornecedor,dataCompra,precoProduto,quantComprada,valorCompra) values(?,?,?,?,?,?)");
            
            int idPrCliente = idPrClienteTemp;
            int idFornecedor = idFornecedorTemp;
            String dataCompra = dataTemp;
            double precoProduto = precoProdutoTemp;
            int quantComprada = quantCompradaTemp;
            double valorCompra = valorCompraTemp;
            
            stmt.setInt(1,idPrCliente);
            stmt.setInt(2,idFornecedor);
            stmt.setString(3, dataCompra);
            stmt.setDouble(4,precoProduto);
            stmt.setInt(5, quantComprada);
            stmt.setDouble(6, valorCompra);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pedido Cadastrado com sucesso!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Pedido não pode ser cadastrado!");
            
        }
        
    } 
      
    public static void iniciarVariaveisProdutoEstoque(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("SELECT * FROM produto_estoque");
            ResultSet resultado = consulta.executeQuery();
            
            int id;
            String nomeProduto;
            String marcaProduto;
            int quantidade;
            int quantMinima;
            double preco;
            double valorTotal;
            
            Principal.produtosEstoque = new ArrayList<ProdutoEstoque>();
            
            while(resultado.next()){
                id = resultado.getInt("id");
                nomeProduto = resultado.getString("nomeProduto");
                marcaProduto = resultado.getString("marcaProduto");
                quantidade = resultado.getInt("quantidade");
                quantMinima = resultado.getInt("quantMinima");
                preco = resultado.getDouble("preco");
                valorTotal = resultado.getDouble("valorTotal");
                Principal.produto = new ProdutoEstoque(id,nomeProduto,marcaProduto,
                        quantidade,quantMinima,preco,valorTotal);
                Principal.produtosEstoque.add(Principal.produto);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão com o banco de dados!");
            
        }
    }
    
    public static void iniciarVariaveisFornecedor(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("select * from fornecedor");
            ResultSet resultado = consulta.executeQuery();
            
            int id;
            String nomeFornecedor;
            String email;
            String telefone;
            
            Principal.fornecedores = new ArrayList<Fornecedor>();
            
            while(resultado.next()){
                id = resultado.getInt("id");
                nomeFornecedor = resultado.getString("nomeFornecedor");
                email = resultado.getString("email");
                telefone = resultado.getString("telefone");
                
                Principal.fornecedor = new Fornecedor(id,nomeFornecedor,email,
                        telefone);
                Principal.fornecedores.add(Principal.fornecedor);
        
        }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão com o banco de dados!");
            
        }
    }
    
    public static void iniciarVariaveisProdutoFornecedor(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("select * from produto_fornecedor");
            ResultSet resultado = consulta.executeQuery();
            
            int idFornecedor;
            int id;
            String nomeProduto;
            String MarcaProduto;
            double precoProduto;
            
            Principal.produtosFornecedor = new ArrayList<Fornecedor.ProdutoFornecedor>();
            
            while(resultado.next()){
                idFornecedor = resultado.getInt("idFornecedor");
                id = resultado.getInt("id");
                nomeProduto = resultado.getString("nomeProduto");
                MarcaProduto = resultado.getString("MarcaProduto");
                precoProduto = resultado.getDouble("precoProduto");
                
                Principal.produtoFornecedor = new Fornecedor(0,"","","").new ProdutoFornecedor(idFornecedor,id,nomeProduto,MarcaProduto,precoProduto);
                Principal.produtosFornecedor.add(Principal.produtoFornecedor);
                
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão com o banco de dados!");
            
        }
    }
    
    public static void iniciarVariaveisItemPedido(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("select * from pedido");
            ResultSet resultado = consulta.executeQuery();
            
            int id;
            int idPrCliente;
            int idFornecedor;
            String dataCompleta;
            java.sql.Date data;
            double precoProduto;
            int quantComprada;
            double valorCompra;
            
            Principal.pedidos = new ArrayList<ItemPedido>();
            
            while(resultado.next()){
                
                id = resultado.getInt("id");
                idPrCliente = resultado.getInt("idPrCliente");
                idFornecedor = resultado.getInt("idFornecedor");
                data = resultado.getDate("dataCompra");
                precoProduto = resultado.getDouble("precoProduto");
                quantComprada = resultado.getInt("quantComprada");
                valorCompra = resultado.getDouble("valorCompra");
                
                
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dataCompleta = format.format(data);
                
                Principal.pedido = new ItemPedido(id, idPrCliente, idFornecedor, dataCompleta, precoProduto, quantComprada, valorCompra);
                Principal.pedidos.add(Principal.pedido);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão com o banco de dados!");
            
        }
    }

    public static void editaProdutoEstoque(int id,String nomeProduto, String marcaProduto,
            int quantidade, int quantMinima, double preco, double valorTotal){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) conn.prepareStatement("update produto_cliente set nomeProduto = ?, marcaProduto = ?, "
                    + "quantidade = ?, quantMinima = ?, preco = ?, valorTotal = ? "
                    + "where id = ?");
            int tempid = id;
            String tempNomeProduto = nomeProduto;
            String tempMarcaProduto = marcaProduto;
            int tempQuantidade = quantidade;
            int tempQuantMinima = quantMinima;
            double tempPreco = preco;
            double tempValorTotal = valorTotal;
            
            consulta.setString(1, tempNomeProduto);
            consulta.setString(2, tempMarcaProduto);
            consulta.setInt(3, tempQuantidade);
            consulta.setInt(4, tempQuantMinima);
            consulta.setDouble(5, tempPreco);
            consulta.setDouble(6, tempValorTotal);
            consulta.setInt(7, tempid);
            
            consulta.executeUpdate();
            
            iniciarVariaveisProdutoEstoque();
            
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o produto!");
        }
    }
    
    public static void editaProdutoFornecedor(int id,String nomeProduto, String marcaProduto, double preco){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("UPDATE produto_fornecedor"
                    + " SET nomeProduto = ?, marcaProduto = ?, precoProduto = ? where id = ?");
           
            stmt.setString(1, nomeProduto);
            stmt.setString(2, marcaProduto);
            stmt.setDouble(3, preco);
            stmt.setInt(4, id);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto Fornecedor editado com sucesso!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o produto!");
        }
    }
    
    public static void excuirProdutoFornecedor(int id){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("DELETE FROM produto_fornecedor WHERE id = ?");
        
            consulta.setInt(1, id);
            
            consulta.executeUpdate();
            
            iniciarVariaveisProdutoFornecedor();
            
            JOptionPane.showMessageDialog(null, "Produto do Fornecedor excluído com sucesso!");
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto!");
            
        }
        
    }
    
    public static void editaFornecedor(int id, String nomeFornecedor,String email, String telefone){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("update fornecedor"
                    + " set nomeFornecedor = ?, email = ?, "
                    + "telefone = ? where id = ?");
            int tempid = id;
            String tempNomeFornecedor = nomeFornecedor;
            String tempEmail = email;
            String tempTelefone = telefone;
            
            
            consulta.setString(1, tempNomeFornecedor);
            consulta.setString(2, tempEmail);
            consulta.setString(3, tempTelefone);
            consulta.setInt(4, tempid);
            
            consulta.executeUpdate();
            
            iniciarVariaveisFornecedor();
            
            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o fornecedor!");
        }
    }      
    
    public static ArrayList<Relatorio> geraRelatorio(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT"
            + " ped.id, ped.dataCompra, f.nomeFornecedor, pe.nomeProduto, pe.marcaProduto, ped.precoProduto, ped.quantComprada, ped.valorCompra"
                    + " FROM pedido ped"
                    + " INNER JOIN fornecedor f ON f.id=ped.idFornecedor"
                    + " INNER JOIN produto_estoque pe on pe.id=ped.idPrCliente");
            
            ResultSet resultado = stmt.executeQuery();
        
           int id;
           String nomeFornecedor;
           String nomeProduto;
           String marcaProduto;
           java.sql.Date data;
           String dataCompra;
           double precoProduto;
           int quantComprada;
           double valorCompra;
           
           ArrayList<Relatorio> relatorios = new ArrayList<Relatorio>();
           
           while(resultado.next()){
               id = resultado.getInt("id");
               nomeFornecedor = resultado.getString("nomeFornecedor");
               nomeProduto = resultado.getString("nomeProduto");
               marcaProduto = resultado.getString("marcaProduto");
               data = resultado.getDate("dataCompra");
               precoProduto = resultado.getDouble("precoProduto");
               quantComprada = resultado.getInt("quantComprada");
               valorCompra = resultado.getDouble("valorCompra");
               
               SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dataCompra = format.format(data);
               
               Relatorio temp = new Relatorio(id, nomeFornecedor, nomeProduto, marcaProduto, dataCompra, precoProduto, quantComprada, valorCompra);
               relatorios.add(temp);
           }
           
           return relatorios;
        
        } catch (Exception ex) {
            Relatorio temp = new Relatorio(0, "", "", "", "", 0, 0, 0);
            ArrayList<Relatorio> relatorios = new ArrayList<Relatorio>();
            relatorios.add(temp);
            return relatorios;
            
        }
    }
    
    public static void darbaixa(int id, int quantidadeBaixa,int quantidade){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("UPDATE produto_estoque set quantidade = (quantidade - ?) WHERE id=?");

            if(quantidade>=quantidadeBaixa){
                
                stmt.setInt(1, quantidadeBaixa);
                stmt.setInt(2,id);
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "Valor da baixa maior que o estoque, informe outro valor!");
            }
            
            Conexao.iniciarVariaveisProdutoEstoque();
            
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi Possível reealizar a baixa do Produto no Estoque!");
        }
    }
   
    public static void adicionaEstoque(int id,int quantidade,double precoProduto, double valorTotal){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gerenciador_de_estoque", "root", "");
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("UPDATE produto_estoque SET "
                    + "quantidade = ?, preco = ?, valorTotal = ? WHERE id = ?");
        
            stmt.setInt(1, quantidade);
            stmt.setDouble(2, precoProduto);
            stmt.setDouble(3, valorTotal);
            stmt.setInt(4, id);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Estoque atualizado!");
            
    }catch(Exception Ex){
        
        JOptionPane.showMessageDialog(null, "Estoque não pôde ser atualizado!");
    }
   
        
    }
}

    
    

