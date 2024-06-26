package org.example.infra; //Define o pacote ao qual a classe DatabaseConfig pertence.

import java.sql.Connection; //Importações necessárias para utilizar as classes e interfaces relacionadas ao JDBC.
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // // Configuração para acessar o banco de dados PostgreSQL local

    private static String URL_DB = "jdbc:postgresql://localhost:5432/teste";
    private static String USER = "postgres";
    private static String PASS = "password";

    // Instância única da conexão com o banco de dados.
    public static Connection connection;
    // Método estático para obter a conexão com o banco de dados.
    public static Connection getConnection() throws SQLException {
        // Verifica se a conexão ainda não foi inicializada ou está fechada.
        if(connection==null || connection.isClosed()) {
            // Se a conexão não existe ou está fechada, cria uma nova conexão.
            connection = DriverManager.getConnection(URL_DB, USER, PASS);
        }
        // Retorna a conexão existente ou que acabou de criar.
        return connection;
    }
}

