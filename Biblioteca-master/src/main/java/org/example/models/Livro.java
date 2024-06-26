package org.example.models;

import java.util.Date;

// Classe que representa um livro.
public class Livro {
    private String id;              // Identificador único do livro.
    private String nome;            // Nome do livro.
    private String dataLancamento;  // Data de lançamento do livro.
    private Autor autor;            // Autor do livro (associado à classe Autor).
    private Genero genero;          // Gênero do livro (associado à enumeração Genero).

    // Construtor que inicializa todos os campos da classe Livro.
    public Livro(String id, String nome, Autor autor, String dataLancamento, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
    }

    // Construtor padrão (default) que não inicializa nenhum campo.
    public Livro() {
    }

    // Métodos getters e setters para acessar e modificar os atributos privados da classe.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Sobrescrita do método toString para retornar uma representação em string do objeto Livro.
    @Override
    public String toString() {
        return "Livro{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", autor=" + autor +
                ", genero=" + genero +
                '}';
    }
}
