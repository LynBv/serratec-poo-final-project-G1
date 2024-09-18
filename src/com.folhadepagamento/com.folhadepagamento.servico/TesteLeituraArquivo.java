package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;

import java.io.IOException;
import java.util.List;

public class TesteLeituraArquivo {

    public static void main(String[] args) {
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        String caminhoArquivo = "C:\\Users\\Matheus\\Desktop\\Serratec\\POO\\Codigos\\ProjetoFinalPOO\\serratec-poo-final-project-G1\\src\\com.folhadepagamento\\com.folhadepagamento.resources\\tabela_funcionario.csv";

        try {

           List<Funcionario> funcionarios = leituraArquivo.lerFuncionario(caminhoArquivo);

            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Data de Nascimento: " + funcionario.getDataNascimento());
                System.out.println("Salário Bruto: " + funcionario.getSalarioBruto());
                System.out.println("Dependentes: " + funcionario.getDependentes());
                System.out.println("------");
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
