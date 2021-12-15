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
public class ItemPedido {
    private long idItemPedido;
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public double getValor(){
        return getProduto().getPreco() * getQuantidade();
    }
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the qnt
     */
    public int getQnt() {
        return getQuantidade();
    }

    /**
     * @param qnt the qnt to set
     */
    public void setQnt(int qnt) {
        this.setQuantidade(qnt);
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the idItemPedido
     */
    public long getIdItemPedido() {
        return idItemPedido;
    }

    /**
     * @param idItemPedido the idItemPedido to set
     */
    public void setIdItemPedido(long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }
    
}
