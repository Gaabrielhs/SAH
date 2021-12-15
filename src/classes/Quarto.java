/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Quarto {

    public final int DESOCUPADO = 0;
    public final int OCUPADO = 1;
    public final int LIMPEZA = 2;
    public final int RESERVADO = 3;

    private long idQuarto;
    private Tipo tipo;
    private int situacao;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;

    public Quarto(Tipo tipo) {
        pedidos = new ArrayList<Pedido>();
        clientes = new ArrayList<Cliente>();
        this.tipo = tipo;
        situacao = 0;
    }

    public Quarto() {
        pedidos = new ArrayList<Pedido>();
        clientes = new ArrayList<Cliente>();
        situacao = 0;

    }

    public void limparPedido(){
        pedidos.clear();
    }
    
    public void limparCliente(){
        clientes.clear();
    }
    
    public void adicionarCLiente(Cliente cliente) {
        clientes.add(cliente);
        situacao = 1;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

//    public Quarto(long idQuarto, int situacao){
//        this.idQuarto = idQuarto;
//        this.situacao = situacao;
//    }
    public long getIdQuarto() {
        return idQuarto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getTxtSituacao() {
        switch (situacao) {
            case 0:
                return "Desocupado";
            case 1:
                return "Ocupado";
            case 2:
                return "Limpeza";
            case 3:
                return "Reservado";
            default: throw new IllegalArgumentException();
        }
    }

    public int getSituacao() {
        return situacao;
    }

    public Color getCorSituacao() {
        switch (getSituacao()) {
            case 0:
                return new Color(0, 255, 0);
            case 1:
                return new Color(255, 0, 0);
            case 2:
                return new Color(255, 142, 0);
            case 3:
                return new Color(255, 255, 0);
            default:
                return null;
        }
    }

    /**
     * @return the pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * @param idQuarto the idQuarto to set
     */
    public void setIdQuarto(long idQuarto) {
        this.idQuarto = idQuarto;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String toString() {
        return ""
                + idQuarto + clientes;
    }
}
