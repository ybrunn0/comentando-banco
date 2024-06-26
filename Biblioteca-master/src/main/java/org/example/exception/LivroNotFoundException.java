package org.example.exception;

public class LivroNotFoundException extends Exception{ //Este código define uma classe de exceção personalizada, LivroNotFoundException.
    public LivroNotFoundException() {
        super("Livro não encontrado na base de dados."); } //Usada para indicar que um livro não pôde ser encontrado na base de dados.
}
