package com.folhadepagamento.dao;

import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;
import com.folhadepagamento.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDao {
    private Connection connection;

    public FuncionarioDao() {
        connection = new ConnectionFactory().getConnection();

    }

    public void inserir(Funcionario funcionario) {
        String sql = "insert into Funcionario(nome, cpf) values(?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.execute();

        } catch (SQLException e) {
            System.err.println("Erro ao gravar registro");
        }
    }
}


