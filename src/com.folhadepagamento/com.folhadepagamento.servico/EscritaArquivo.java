package com.folhadepagamento.com.folhadepagamento.servico;

import com.folhadepagamento.com.folhadepagamento.entidade.Funcionario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritaArquivo {


    //Metodo para escrever os dados dos funcionários em um arquivo CSV

    public static void gravarFuncionarios(List<Funcionario> funcionarios, String teste) throws IOException {

        FileWriter gravador = new FileWriter(teste);
        gravador.append("Nome_do_funcionario;CPF_do_Funcionario;Desconto_INSS;Desconto_IR;SalarioLiquido\n");

        for (Funcionario funcionario : funcionarios) {
            funcionario.gerarFolhaPagamento();

            gravador.append(funcionario.getNome()).append(";");
            gravador.append(funcionario.getCpf()).append(";");
            gravador.append(String.format("%.2f", funcionario.getDescontoINSS())).append(";");
            gravador.append(String.format("%.2f", funcionario.getDescontoIR())).append(";");
            gravador.append(String.format("%.2f", funcionario.getSalarioLiquido())).append("\n");
        }

        gravador.flush();
        gravador.close();
    }


}

