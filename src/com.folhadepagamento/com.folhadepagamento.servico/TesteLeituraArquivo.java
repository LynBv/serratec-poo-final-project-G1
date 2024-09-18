package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;

import java.io.IOException;
import java.util.List;

public class TesteLeituraArquivo {

    public static void main(String[] args) {

        try {

         //   List<Funcionario> funcionarios = LeituraArquivo.lerFuncionario("");

            LeituraArquivo leituraArquivo = new LeituraArquivo();
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Funcionário: " + funcionario.getNome() + " - CPF: " + funcionario.getCpf() + " Salário Bruto" + funcionario.getSalarioBruto());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
