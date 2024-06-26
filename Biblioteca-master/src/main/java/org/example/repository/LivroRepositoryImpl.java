package org.example.repository;

import org.example.models.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Implementação da interface LivroRepository utilizando JDBC para interação com banco de dados.
public class LivroRepositoryImpl implements LivroRepository {

    private Connection connection;  // Conexão com o banco de dados

    // Construtor que recebe uma conexão como parâmetro.
    public LivroRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    // Método para salvar um livro no banco de dados.
    @Override
    public Livro salvar(Livro livro) {
        String sql = "INSERT INTO livros(id, nome, data_lancamento, id_autor, genero) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livro.getId());
            statement.setString(2, livro.getNome());
            statement.setString(3, livro.getDataLancamento());  // Supondo que getDataLancamento retorna uma String.
            statement.setString(4, livro.getAutor().getCpf());
            statement.setString(5, livro.getGenero().toString());
            statement.executeUpdate();  // Executa a inserção no banco de dados.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar salvar o livro: " + e.getMessage());
        }

        return livro;
    }

    // Método para deletar um livro do banco de dados dado o seu ID.
    @Override
    public void deletar(String id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();  // Executa a exclusão no banco de dados.
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar deletar o livro: " + e.getMessage());
        }
    }

    // Método para buscar um livro no banco de dados dado o seu ID.
    @Override
    public Livro buscar(String id) {
        Livro livro = null;
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();  // Executa a consulta no banco de dados.
            if (result.next()) {
                livro = new Livro(
                        result.getString("id"),
                        result.getString("nome"),
                        null,  // O autor e o gênero não são recuperados diretamente aqui.
                        result.getString("data_lancamento"),
                        null
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar buscar o livro: " + e.getMessage());
        }
        return livro;
    }

    // Método para atualizar um livro no banco de dados dado o seu ID e um novo objeto Livro.
    @Override
    public Livro atualizar(String id, Livro livro) {
        // Implementação da atualização.
        return null;
    }

    // Método para verificar se um livro existe no banco de dados dado o seu ID.
    @Override
    public boolean existe(String id) {
        Livro livro = buscar(id);
        return livro != null;
    }
}
