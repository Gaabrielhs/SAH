/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


/**
 *
 * @author Usuario
 */
public class Funcionario{
    private long idFuncionario;
    private boolean gerente;
    private String nome;
    private String login;
    private String senha;

    public Funcionario(int idFuncionario, boolean gerente, String nome, String login, String senha) {
        this.idFuncionario = idFuncionario;
        this.gerente = gerente;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Funcionario() {
    }
    
    /**
     * @return the gerente
     */
    public boolean isGerente() {
        return gerente;
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the idFuncionario
     */
    public long getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @param gerente the gerente to set
     */
    public void setGerente(boolean gerente) {
        this.gerente = gerente;
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


    
    
}
