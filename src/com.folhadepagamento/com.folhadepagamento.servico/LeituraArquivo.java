package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Dependente;
import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;
import com.folhadepagamento.com.folhadepagamento.entidade.TipoParentesco;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeituraArquivo {

    private  List<Funcionario> funcionarios = new ArrayList<>();

    public LeituraArquivo() {
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Funcionario> lerFuncionario(String caminhoArquivo) throws FileNotFoundException {


        Scanner lerArquivo = new Scanner((new File("C:\\Users\\Matheus\\Desktop\\Serratec\\POO\\Codigos\\ProjetoFinalPOO\\serratec-poo-final-project-G1\\src\\com.folhadepagamento\\com.folhadepagamento.resources\\tabela_funcionario.csv")));
        //System.out.println("Digite o nome do arquivo:");
        //AQUI EU PEÇO NOME DO ARQUIVO PARA O USUÁRIO

        List<String> linhas = new ArrayList<>(); //Criação do Array para armazenar as linhas
        while (lerArquivo.hasNextLine()) { //Enquanto tiverem linhas no arquivo, cada uma será adicionada na variável
            linhas.add(lerArquivo.nextLine());
        }

        //List<Funcionario> funcionarios = new ArrayList<>(); //Criando Array de Funcionarios
        Funcionario funcionario = new Funcionario(); //Instanciando um funcionário vazio fora do FOR para quando ele rodar começar vazio. Para isso criei o construtor vazio.
        //System.out.println("Teste" + linhas) ;
        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                String[] dadosDaLinha = linha.split(";"); //Criando array de String para separar as informações de cada linha.
                //  if (dadosDaLinha.length >= 4) { //
                int indexFinal = dadosDaLinha.length -1; //Sem -1 estava pegando a posição errada. Essa foi a única maneira que encontrei para a finalidade da variável indexFinal ser atendida.

                if (TipoParentesco.obterParentesco(dadosDaLinha[indexFinal]) == null) { //Aqui eu pego...
                    funcionario.setNome(dadosDaLinha[0]);
                    funcionario.setCpf(dadosDaLinha[1]);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); //Tive que formatar para receber uma string e transformar num LocalDate
                    LocalDate dataNascimento = LocalDate.parse(dadosDaLinha[2], formatter);
                    funcionario.setDataNascimento(dataNascimento);
                    dadosDaLinha[2] = dataNascimento.format(formatter);
                    //System.out.println(dadosDaLinha[2]);
                    funcionario.setSalarioBruto(Double.valueOf(dadosDaLinha[3]));
                    //System.out.println(dadosDaLinha[3]);

                } else {

                    // Trata como dependente
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // Formatação da data
                    LocalDate dataNascimento = LocalDate.parse(dadosDaLinha[2], formatter);

                    // Obtém o tipo de parentesco da string
                    TipoParentesco parentesco = TipoParentesco.valueOf(dadosDaLinha[3]);

                    // Instancia o dependente
                    Dependente dependente = new Dependente(dadosDaLinha[0], dadosDaLinha[1], dataNascimento, parentesco);

                    // Adiciona o dependente ao funcionário
                    funcionario.adicionarDependente(dependente);
                    //System.out.println(dependente);
                }
           }
            else {
               funcionarios.add(funcionario);
               funcionario = new Funcionario();
           }

        }
        lerArquivo.close();
        return funcionarios;
    }
}


