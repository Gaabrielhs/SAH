/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaabrielhs
 */
public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Produto produto) {
        long idGerado = -1;
        try {
            String sql = "INSERT INTO produto (idProduto, descricao, quantidade, preco) VALUES(?, ?, ?, ?);";

            PreparedStatement pstmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, produto.getIdProduto());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setInt(3, produto.getQnt_estoque());
            pstmt.setDouble(4, produto.getPreco());

            int quantos = pstmt.executeUpdate();
            if (quantos == 1) {
                System.out.println("Inserção efetuada com sucesso");
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        produto.setIdProduto(rs.getLong(1));
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

    public List<Produto> buscarTodos() {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produto;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getLong("idProduto"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQnt_estoque(rs.getInt("quantidade"));

                    produtos.add(produto);
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
        return produtos;
    }

    public Produto buscar(long idProduto) {
        Produto produto = null;
        try {
            String sql = "SELECT * FROM produto WHERE idProduto = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, idProduto);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getLong("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQnt_estoque(rs.getInt("quantidade"));
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
        return produto;
    }

    public List<Produto> buscar(String nome) {
        List<Produto> produtos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM produto WHERE UPPER(nome) LIKE UPPER(?);";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, "%" + nome + "%");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                do {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getLong("idProduto"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setQnt_estoque(rs.getInt("quantidade"));

                    produtos.add(produto);
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
        return produtos;
    }

    public void atualizar(Produto produto) {
        try {
            String sql = "UPDATE Produto SET descricao = ?, quantidade = ?, preco = ? WHERE idProduto = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQnt_estoque());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setLong(4, produto.getIdProduto());

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

    public void remover(Produto produto) {
        try {
            String sql = "DELETE FROM produto WHERE idProduto = ?;";
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setLong(1, produto.getIdProduto());

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
