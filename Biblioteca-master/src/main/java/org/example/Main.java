package org.example;

import org.example.exception.LivroNotFoundException;
import org.example.infra.DatabaseConfig;
import org.example.models.Autor;
import org.example.models.Genero;
import org.example.models.Livro;
import org.example.models.Pessoa;
import org.example.repository.LivroRepository;
import org.example.repository.LivroRepositoryImpl;
import org.example.service.LivroService;

import java.sql.Connection;
import java.sql.SQLException;

// Classe principal que demonstra o uso das classes e serviços relacionados a livros.
public class Main {
    public static void main(String[] args) throws LivroNotFoundException {

        // Bloco try-with-resources para garantir o fechamento automático da conexão.
        try (Connection connection = DatabaseConfig.getConnection()) {
            // Instanciando o repositório de livros e o serviço de livros com a conexão obtida.
            LivroRepository livroRepository = new LivroRepositoryImpl(connection);
            LivroService livroService = new LivroService(livroRepository);

            // Exemplo de criação de um novo livro e impressão do resultado.
            System.out.println((livroService.criarLivro(new Livro("a", "Chimpanzé Magrelo",
                    new Autor("123", "Xaolin", "01/01/2001", "", "", "Angolano"),
                    "23/02/2004", Genero.SUSPENSE))));

            // Exemplo de deleção de um livro;
            // livroService.deletar("a");.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
