package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Dependente;
import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;
import com.folhadepagamento.com.folhadepagamento.entidade.TipoParentesco;
import com.folhadepagamento.com.folhadepagamento.exceptions.DependentException;
import com.folhadepagamento.connection.ConnectionFactory;
import com.folhadepagamento.dao.FuncionarioDao;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeituraArquivo {

    private List<Funcionario> funcionarios = new ArrayList<>();


    public LeituraArquivo() {
    }

    public List<Funcionario> lerFuncionario(String caminhoArquivo) throws FileNotFoundException {

        Scanner lerArquivo = new Scanner((new File(caminhoArquivo)));

        List<String> linhas = new ArrayList<>(); //Criação do Array para armazenar as linhas
        while (lerArquivo.hasNextLine()) {
            linhas.add(lerArquivo.nextLine());
        }
        Funcionario funcionario = new Funcionario(); //Instanciando um funcionário vazio fora do FOR para quando ele rodar começar vazio. Para isso criei o construtor vazio.
        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] dadosDaLinha = linha.split(";"); //Criando array de String para separar as informações de cada linha.

                int indexFinal = dadosDaLinha.length - 1; //Sem -1 estava pegando a posição errada.
                // Essa foi a única maneira que encontrei para a finalidade da variável indexFinal ser atendida.

                if (TipoParentesco.obterParentesco(dadosDaLinha[indexFinal]) == null) {
                    funcionario.setNome(dadosDaLinha[0]);
                    funcionario.setCpf(dadosDaLinha[1]);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    LocalDate dataNascimento = LocalDate.parse(dadosDaLinha[2], formatter);
                    funcionario.setDataNascimento(dataNascimento);
                    dadosDaLinha[2] = dataNascimento.format(formatter);

                    funcionario.setSalarioBruto(Double.valueOf(dadosDaLinha[3]));


                } else {

                    // Trata como dependente
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // Formatação da data
                    LocalDate dataNascimento = LocalDate.parse(dadosDaLinha[2], formatter);

                    // Obtém o tipo de parentesco da string
                    TipoParentesco parentesco = TipoParentesco.valueOf(dadosDaLinha[3]);
                    Dependente dependente = null;

                    try {
                        // Instancia o dependente
                        dependente = new Dependente(dadosDaLinha[0], dadosDaLinha[1], dataNascimento, parentesco);

                        try {
                            // Adiciona o dependente ao funcionário
                            funcionario.adicionarDependente(dependente);


                        } catch (DependentException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } catch (DependentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }


                }
            } else {
                funcionarios.add(funcionario);
                funcionario = new Funcionario();
            }

        }
        lerArquivo.close();
        return funcionarios;
    }

    public void inserirFuncionario() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        LeituraArquivo leituraArquivo = new LeituraArquivo();
        for (Funcionario funcionario : funcionarios) {
            String nome = funcionario.getNome();
            String cpf = funcionario.getCpf();

            try {
                Funcionario fun = new Funcionario(nome, cpf);
                funcionarioDao.inserir(funcionario);

            } catch (DependentException e) {
            }
        }
    }


    public List<Funcionario> getFuncionarios() {
    return funcionarios;
    }
}


