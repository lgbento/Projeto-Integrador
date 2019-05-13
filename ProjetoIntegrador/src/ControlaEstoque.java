
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
public class ControlaEstoque {
    
    
    public void realizaPedido(){
        
    }
    public static ProdutoEstoque checaEstoque(){
        
        ProdutoEstoque ProdutoEstoqueBaixo = new ProdutoEstoque(0,"","",0,0,0,0); 
        
        for(ProdutoEstoque x: Principal.produtosEstoque){
           if(x.getQuantidade()<=x.getQuantMinima()){
               ProdutoEstoqueBaixo = x;
            
           }  
        }
        
        return ProdutoEstoqueBaixo;
    }
    public void adicionaEstoque(){
        
    }
    public void removeEstoque(){
        
    }
    public void gerarRelatorio(){
        
    }
}
 
