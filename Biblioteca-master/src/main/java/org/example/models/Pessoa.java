package org.example.models;

// Classe abstrata que representa uma Pessoa.
public abstract class Pessoa {
    private String cpf;              // CPF da pessoa
    private String nome;             // Nome da pessoa
    private String dataNascimento;   // Data de nascimento da pessoa
    private String telefone;         // Telefone da pessoa
    private String email;            // Email da pessoa

    // Construtor que inicializa todos os campos da classe Pessoa.
    public Pessoa(String cpf, String nome, String dataNascimento, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    // Construtor padrão (default) que não inicializa nenhum campo.
    public Pessoa() {
    }

    // Métodos getters e setters para acessar e modificar os atributos privados da classe.

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
