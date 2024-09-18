package com.folhadepagamento.connection;


import java.sql.Connection;

public class TesteConnection {
    public static void main(String[] args) {


        Connection connection = new ConnectionFactory().getConnection(); // Criando a instância da Classe ConnectionFactory

        System.out.println(connection);
    }
}
