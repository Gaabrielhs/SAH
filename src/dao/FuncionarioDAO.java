/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Gaabrielhs
 */
public class FuncionarioDAO {

    private Connection conexao;

    public FuncionarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO FUNCIONARIO(gerente, nome, login , senha) VALUES(?, ?, ?, ?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setBoolean(1, funcionario.isGerente());
            pstmt.setString(2, funcionario.getNome());
            pstmt.setString(3, funcionario.getLogin());
            pstmt.setString(4, funcionario.getSenha());

            int quantos = pstmt.executeUpdate();
            if (quantos == 1) {
                System.out.println("Inserção efetuada com sucesso");
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        funcionario.setIdFuncionario(rs.getLong(1));
                    }
                }
            } else {
                System.out.println("Problema na inserção!");
            }

            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    public Funcionario buscar(long idFuncionario) {
        Funcionario funcionario = null;
        try {
            String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, idFuncionario);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getLong(1));
                funcionario.setGerente(rs.getBoolean(2));
                funcionario.setNome(rs.getString(3));
                funcionario.setLogin(rs.getString(4));
                funcionario.setSenha(rs.getString(5));
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return funcionario;
    }

    public List<Funcionario> buscarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
        try {
            String sql = "SELECT * FROM funcionario;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getLong(1));
                    funcionario.setGerente(rs.getBoolean(2));
                    funcionario.setNome(rs.getString(3));
                    funcionario.setLogin(rs.getString(4));
                    funcionario.setSenha(rs.getString(5));
                    funcionarios.add(funcionario);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return funcionarios;
    }

    public List<Funcionario> buscar(String nome) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
        try {
            String sql = "SELECT * FROM funcionario WHERE UPPER(nome) LIKE UPPER(?);";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getLong(1));
                    funcionario.setGerente(rs.getBoolean(2));
                    funcionario.setNome(rs.getString(3));
                    funcionario.setLogin(rs.getString(4));
                    funcionario.setSenha(rs.getString(5));
                    funcionarios.add(funcionario);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return funcionarios;
    }

    public void atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE Funcionario SET gerente = ?, nome = ?, login = ?, senha = ? WHERE idFuncionario = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setBoolean(1, funcionario.isGerente());
            pstmt.setString(2, funcionario.getNome());
            pstmt.setString(3, funcionario.getLogin());
            pstmt.setString(4, funcionario.getSenha());
            pstmt.setLong(5, funcionario.getIdFuncionario());

            if (pstmt.executeUpdate() == 1) {
                System.out.println("\nAtualização efetuada com sucesso");
            } else {
                System.out.println("\nProblema na atualização!");
            }

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    public void remover(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM funcionario WHERE idFuncionario = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, funcionario.getIdFuncionario());

            if (pstmt.executeUpdate() == 1) {
                System.out.println("\nRemoção efetuada com sucesso.");
            } else {
                System.out.println("\nProblema na remoção!");
            }

            pstmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }
}
