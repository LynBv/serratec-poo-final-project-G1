package com.folhadepagamento.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String url = "jdbc:postgresql://localhost:5432/projetofinalpoo";

    String usuario = "postgres";
    String senha = "1914";

    private Connection connection;

    public Connection getConnection() {
        System.out.println("Conectando no banco de dados...");


        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            if (connection != null){
                System.out.println("Conectado com sucesso!");
            } else {
                System.out.println("Erro nos dados da conexão");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar...");
        }
        return connection;

    }

}

