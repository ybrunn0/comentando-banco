package org.example.service;

import org.example.exception.LivroNotFoundException;
import org.example.models.Livro;
import org.example.repository.LivroRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.infra.DatabaseConfig.connection;

// Serviço que encapsula a lógica de negócio relacionada a livros.
public class LivroService {

    private LivroRepository livroRepository;

    // Construtor que recebe um LivroRepository como dependência.
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Método para criar um novo livro.
    public Livro criarLivro(Livro livro) {
        Livro livroSalvo = null;
        if (livro.getId() != null) {
            if (livroRepository.existe(livro.getId())) {
                throw new RuntimeException("Livro já existe");
            }
            livroSalvo = livroRepository.salvar(livro);
        }
        return livroSalvo;
    }

    // Método para buscar um livro pelo seu ID.
    public Livro buscarLivro(String id) throws LivroNotFoundException {
        Livro livro = livroRepository.buscar(id);
        if (livro == null) {
            throw new LivroNotFoundException();
        } else {
            return livro;
        }
    }

    // Método para deletar um livro pelo seu ID.
    public void deletar(String id) throws LivroNotFoundException {
        if (livroRepository.existe(id)) {
            livroRepository.deletar(id);
        } else {
            throw new LivroNotFoundException();
        }
    }

    // Método para atualizar um livro pelo seu ID.
    public Livro atualizar(String id, Livro livro) {
        String sql = "UPDATE livros SET nome = ?, data_lancamento = ?, id_autor = ?, genero = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, livro.getNome());
            statement.setString(2, livro.getDataLancamento().toString());  // Supondo que getDataLancamento retorna uma String.
            statement.setString(3, livro.getAutor().getCpf());
            statement.setString(4, livro.getGenero().toString());
            statement.setString(5, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return livro;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar atualizar o livro: " + e.getMessage());
        }

        return null;
    }
}
