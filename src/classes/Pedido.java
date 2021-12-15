/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Gaabrielhs
 */
public class Pedido {
    private long idPedido;
    private List<ItemPedido> itens;
    private DateTime data;
    private double valor;

    public Pedido(ArrayList<ItemPedido> itens){
        this.itens = itens;
        valor = getValorPedido();
    }
    
    public Pedido(){
        itens = new ArrayList<ItemPedido>();
        valor = 0;
    }
    
    public void addItem(ItemPedido item){
        itens.add(item);
        valor = getValorPedido();
    }
    
    public void addItem(Produto produto, int quantidade){
        itens.add(new ItemPedido(produto, quantidade));
        valor = getValorPedido();
    }
    
    public double getValorPedido(){
        double valor = 0;
        for(ItemPedido i: itens){
            valor += i.getValor();
        }
        return valor;
    }

    @Override
    public String toString() {
        return "ID: " + idPedido + " Data: " + data.toString("dd MMM HH:mm:ss") + " Valor: " + valor;
    }
    /**
     * @return the itens
     */
    public List<ItemPedido> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    /**
     * @return the data
     */
    public DateTime getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(DateTime data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the idPedido
     */
    public long getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }
    
    
}
