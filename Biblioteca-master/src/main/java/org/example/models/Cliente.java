package org.example.models;

// Definição da classe Cliente, que herda de Pessoa
public class Cliente extends Pessoa{

    // Construtor que inicializa todos os campos incluindo o da superclasse Pessoa
    public Cliente(String cpf, String nome, String dataNasimento, String telefone, String email) {
        super(cpf, nome, dataNasimento, telefone, email);// Chama o construtor da superclasse Pessoa
    }
    // Construtor padrão (default) que chama o construtor padrão da superclasse Pessoa
    public Cliente() {
    }
}
