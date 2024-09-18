package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;
import com.folhadepagamento.dao.FuncionarioDao;

import java.io.IOException;
import java.util.List;

public class TesteLeituraArquivo {

    public static void main(String[] args) {

        try {
            LeituraArquivo leitura = new LeituraArquivo();
            List<Funcionario> funcionarios = leitura.lerFuncionario("C:\\Users\\Matheus\\Desktop\\Serratec\\POO\\Codigos\\ProjetoFinalPOO\\serratec-poo-final-project-G1\\src\\com.folhadepagamento\\com.folhadepagamento.resources\\tabela_funcionario.csv");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Funcionário: " + funcionario.getNome() + " - CPF: " + funcionario.getCpf() + " Salário Bruto" + funcionario.getSalarioBruto());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        FuncionarioDao funcionarioDao = new FuncionarioDao();
    }
}
