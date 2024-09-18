package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.exceptions.DependentException;
import com.folhadepagamento.com.folhadepagamento.fiscal.CalculosFolhaDePagamento;
import com.folhadepagamento.com.folhadepagamento.fiscal.TabelaINSS;
import com.folhadepagamento.com.folhadepagamento.fiscal.TabelaIR;
import com.folhadepagamento.com.folhadepagamento.servico.LeituraArquivo;
import com.folhadepagamento.connection.ConnectionFactory;
import com.folhadepagamento.dao.FuncionarioDao;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements CalculosFolhaDePagamento {

    private Double salarioBruto;
    private Double salarioLiquido;
    private Double descontoINSS;
    private Double descontoIR;
    private Double deducaoDependentes;
    private final Double DESCONTO_DEPENDENTE = 189.59;
    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf) {
    }

    @Override
    public String toString() {
        return "\nFuncionario:" + "salarioBruto=" + salarioBruto + ", salarioLiquido=" + salarioLiquido + ", descontoINSS="
                + descontoINSS + ", descontoIR=" + descontoIR + ", descontoPorDependente=" + deducaoDependentes;
    }

    public Double getDescontoIR() {
        return descontoIR;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public Double getDescontoINSS() {
        return descontoINSS;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void adicionarDependente(Dependente dependente) {
        for (Dependente d : dependentes) {
            if (d.getCpf().equals(dependente.getCpf())) {
                throw new DependentException
                        ("O cpf de " + dependente.getNome() + " é igual ao de " + d.getNome() + ".");
            }
        }
        dependentes.add(dependente);
    }

    public void calcularValorPorDependente() {
        int numeroDependentes = dependentes.size();
        deducaoDependentes = numeroDependentes * DESCONTO_DEPENDENTE;
    }

    public void calcularInss() {
        TabelaINSS tabelaINSS = TabelaINSS.FAIXA4;
        if (salarioBruto < tabelaINSS.getValorMaximo()) {
            for (TabelaINSS tabelaINSS1 : TabelaINSS.values()) {
                boolean acimaDoMinimo = salarioBruto >= tabelaINSS1.getValorMinimo();
                boolean abaixoDoMaximo = salarioBruto <= tabelaINSS1.getValorMaximo();
                if (acimaDoMinimo && abaixoDoMaximo) {
                    tabelaINSS = tabelaINSS1;
                    descontoINSS = ((salarioBruto * tabelaINSS.getAliquota()) / 100) - tabelaINSS.getDeducao();
                    break;
                }
            }
        } else {
            descontoINSS = ((tabelaINSS.getValorMaximo() * tabelaINSS.getAliquota()) / 100) - tabelaINSS.getDeducao();
        }
    }

    public void calcularIR() {
        TabelaIR tabelaIR = TabelaIR.FAIXA5;
        Double salarioBase = salarioBruto - deducaoDependentes - descontoINSS;
        if (salarioBase <= tabelaIR.getValorMinimo()) {
            for (TabelaIR tabelaIR1 : TabelaIR.values()) {
                boolean acimaDoMinimo = salarioBase >= tabelaIR1.getValorMinimo();
                boolean abaixoDoMaximo = salarioBase <= tabelaIR1.getValorMaximo();
                if (acimaDoMinimo && abaixoDoMaximo) {
                    tabelaIR = tabelaIR1;
                    break;
                }
            }
        }
        descontoIR = (salarioBase * tabelaIR.getAliquota()) / 100 - tabelaIR.getDeducao();
    }

    public void calcularSalarioLiquido() {
        salarioLiquido = salarioBruto - descontoINSS - descontoIR;
    }

    public void gerarFolhaPagamento() {
        this.calcularInss();
        this.calcularValorPorDependente();
        this.calcularIR();
        this.calcularSalarioLiquido();
    }


}


