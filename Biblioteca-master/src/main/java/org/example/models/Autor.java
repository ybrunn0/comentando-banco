package org.example.models;

import java.util.Date;

// Definição da classe Autor, que herda de Pessoa.
public class Autor extends Pessoa{
    // Atributo específico da classe Autor
    private String nacionalidade;

    // Construtor que inicializa todos os campos incluindo o da superclasse Pessoa.
    public Autor(String cpf, String nome, String dataNasimento, String telefone, String email, String nacionalidade) {
        super(cpf, nome, dataNasimento, telefone, email);// Chama o construtor da superclasse Pessoa.
        this.nacionalidade = nacionalidade;// Inicializa o atributo nacionalidade específico de Autor.
    }

    // Construtor padrão (default) que chama o construtor padrão da superclasse Pessoa.
    public Autor(){
        super();// Chama o construtor padrão da superclasse Pessoa

    }
    // Método getter para obter a nacionalidade do autor
    public String getNacionalidade() {
        return nacionalidade;// Retorna a nacionalidade do autor
    }
    // Método setter para definir a nacionalidade do autor
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;// Define a nacionalidade do autor
    }
}
