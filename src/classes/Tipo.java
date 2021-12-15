/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;

/**
 *
 * @author Gaabrielhs
 */
public class Tipo {
    private long idTipo;
    private int qntCamas;
    private String nome;
    private Color cor;
    private double preco_diaria;
    private boolean ar_condicionado;
    private boolean tv;
    private boolean telefone;
    private boolean frigobar;
    private boolean banheiro;
    private int qntQuartos;
    
    public Tipo() {
    }
    

    public Tipo(int qntCamas, String nome, Color cor, double preco_diaria, boolean ar_condicionado, boolean tv, boolean telefone, boolean frigobar, boolean banheiro) {
        this.qntCamas = qntCamas;
        this.nome = nome;
        this.cor = cor;
        this.preco_diaria = preco_diaria;
        this.ar_condicionado = ar_condicionado;
        this.tv = tv;
        this.telefone = telefone;
        this.frigobar = frigobar;
        this.banheiro = banheiro;
    }

    public long getIdTipo(){
        return idTipo;
    }
    
    public void setIdTipo(long idTipo){
        this.idTipo = idTipo;
    }
    
    /**
     * @return the qnt
     */
    public int getQntCamas() {
        return qntCamas;
    }

    /**
     * @param qnt the qnt to set
     */


    public void setQnTCamas(int qntCamas){
        this.qntCamas = qntCamas;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cor
     */
    public Color getCor() {
        return cor;
    }

    public int getRed(){
        return getCor().getRed();
    }
    
    public int getGreen(){
        return getCor().getGreen();
    }
    
    public int getBlue(){
        return getCor().getBlue();
    }
    /**
     * @param cor the cor to set
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    public void setCor(int r, int g, int b){
        setCor(new Color(r, g, b));
    }

    /**
     * @return the preco_diaria
     */
    public double getPreco_diaria() {
        return preco_diaria;
    }

    /**
     * @param preco_diaria the preco_diaria to set
     */
    public void setPreco_diaria(double preco_diaria) {
        this.preco_diaria = preco_diaria;
    }

    /**
     * @return the ar_condicionado
     */
    public boolean isAr_condicionado() {
        return ar_condicionado;
    }

    /**
     * @param ar_condicionado the ar_condicionado to set
     */
    public void setAr_condicionado(boolean ar_condicionado) {
        this.ar_condicionado = ar_condicionado;
    }

    /**
     * @return the tv
     */
    public boolean isTv() {
        return tv;
    }

    /**
     * @param tv the tv to set
     */
    public void setTv(boolean tv) {
        this.tv = tv;
    }

    /**
     * @return the telefone
     */
    public boolean isTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(boolean telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the frigobar
     */
    public boolean isFrigobar() {
        return frigobar;
    }

    /**
     * @param frigobar the frigobar to set
     */
    public void setFrigobar(boolean frigobar) {
        this.frigobar = frigobar;
    }

    /**
     * @return the banheiro
     */
    public boolean isBanheiro() {
        return banheiro;
    }

    /**
     * @param banheiro the banheiro to set
     */
    public void setBanheiro(boolean banheiro) {
        this.banheiro = banheiro;
    }

   

    /**
     * @return the qntQuartos
     */
    public int getQntQuartos() {
        return qntQuartos;
    }

    /**
     * @param qntQuartos the qntQuartos to set
     */
    public void setQntQuartos(int qntQuartos) {
        this.qntQuartos = qntQuartos;
    }
    
    public String toString(){
        return nome;
    }
    
}
