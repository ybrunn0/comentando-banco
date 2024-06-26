package org.example.repository;

import org.example.models.Livro;

// Interface que define operações para manipulação de livros em um repositório.
public interface LivroRepository {

    // Método para salvar um livro no repositório.
    Livro salvar(Livro livro);

    // Método para deletar um livro do repositório dado seu ID.
    void deletar(String id);

    // Método para buscar um livro no repositório dado seu ID.
    Livro buscar(String id);

    // Método para atualizar um livro no repositório dado seu ID e um novo objeto Livro.
    Livro atualizar(String id, Livro livro);

    // Método para verificar se um livro existe no repositório dado seu ID.
    boolean existe(String id);
}
