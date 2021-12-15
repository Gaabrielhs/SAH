/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.joda.time.DateTime;

/**
 *
 * @author Gaabrielhs
 */
public class Reserva {
    private Cliente cliente;
    private DateTime data_entrada;
    private DateTime data_saida;
    private Quarto quarto;

    private Reserva(Cliente cliente, DateTime data_entrada, DateTime data_saida, Quarto quarto){
        this.cliente = cliente;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.quarto = quarto;
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the data_entrada
     */
    public DateTime getData_entrada() {
        return data_entrada;
    }

    /**
     * @param data_entrada the data_entrada to set
     */
    public void setData_entrada(DateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * @return the data_saida
     */
    public DateTime getData_saida() {
        return data_saida;
    }

    /**
     * @param data_saida the data_saida to set
     */
    public void setData_saida(DateTime data_saida) {
        this.data_saida = data_saida;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
    
}
