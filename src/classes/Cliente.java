/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.joda.time.DateTime;

/**
 *
 * @author Usuario
 */
public class Cliente extends Pessoa{
    private long idCliente;
    private DateTime dataNasc;
    private String telefone;
    private String email;

    public Cliente(long idCliente, String nome, String rg, String cpf, String endereco, DateTime dataNasc, String telefone, String email) {
        super(nome , rg, cpf, endereco);
        this.idCliente = idCliente;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(){
        
    }
    /**
     * @return the dataNasc
     */
    public DateTime getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(int dia, int mes, int ano) {
        setDataNasc(new DateTime(ano, mes, dia, 0, 0));
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(DateTime dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the idCliente
     */
    public long getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    public String toString(){
        return super.getNome();
    }
    
}
