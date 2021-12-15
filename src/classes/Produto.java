/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Gaabrielhs
 */
public class Produto {
    private long idProduto;
    private int qnt_estoque;
    private String descricao;
    private double preco;

    public Produto(){
        
    }
    public Produto(long idProduto, int qnt_estoque, String descricao, double preco){
        this.idProduto = idProduto;
        this.qnt_estoque = qnt_estoque;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public Produto(int qnt_estoque, String descricao, double preco){
        this.idProduto = idProduto;
        this.qnt_estoque = qnt_estoque;
        this.descricao = descricao;
        this.preco = preco;
    }
    /**
     * @return the qnt_estoque
     */
    public int getQnt_estoque() {
        return qnt_estoque;
    }

    /**
     * @param qnt_estoque the qnt_estoque to set
     */
    public void setQnt_estoque(int qnt_estoque) {
        this.qnt_estoque = qnt_estoque;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the idProduto
     */
    public long getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
}
