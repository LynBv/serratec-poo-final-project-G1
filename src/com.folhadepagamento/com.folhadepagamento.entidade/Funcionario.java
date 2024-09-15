package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.fiscal.CalculosFolhaDePagamento;
import com.folhadepagamento.com.folhadepagamento.fiscal.TabelaINSS;
import com.folhadepagamento.com.folhadepagamento.fiscal.TabelaIR;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements CalculosFolhaDePagamento {

    private String profissao;
    private Double salarioBruto;
    private Double salarioLiquido= 0.;
    private Double descontoINSS = 0.;
    private Double descontoIR = 0.;
    private Double descontoPorDependente = 0.;
    private final Double DESCONTO_DEPENDENTE = 189.59;
    private List<Dependente> dependentes = new ArrayList<Dependente>();

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, Double salarioBruto){
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
    }

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, String profissao, Double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.profissao = profissao;
        this.salarioBruto = salarioBruto;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salarioBruto=" + salarioBruto +
                ", salarioLiquido=" + salarioLiquido +
                ", descontoINSS=" + descontoINSS +
                ", descontoIR=" + descontoIR +
                ", descontoPorDependente=" + descontoPorDependente +
                '}';
    }

    public Double getDescontoIR() {
        return descontoIR;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
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

    public void adicionarDependente(Dependente dependente){
        dependentes.add(dependente);
    }

    private void calcularSalarioLiquido() {
        salarioLiquido += salarioBruto - descontoINSS - descontoIR;
    }

    private void calcularInss() {
        TabelaINSS tabelaINSS = TabelaINSS.FAIXA4;
        if (salarioBruto < tabelaINSS.getValorMaximo()){
            for (TabelaINSS tabelaINSS1 : TabelaINSS.values()){
                boolean acimaDoMinimo = salarioBruto > tabelaINSS1.getValorMinimo();
                boolean abaixoDoMaximo = salarioBruto < tabelaINSS1.getValorMaximo();
                if (acimaDoMinimo && abaixoDoMaximo) {
                    tabelaINSS = tabelaINSS1;
                    descontoINSS += ((salarioBruto * tabelaINSS.getAliquota())/100) - tabelaINSS.getDeducao();
                    break;
                }
            }
        } else {
            descontoINSS += ((tabelaINSS.getValorMaximo() * tabelaINSS.getAliquota())/100) - tabelaINSS.getDeducao();
        }
    }

    private void calcularValorPorDependente() {
        int numeroDependentes = dependentes.size();
        descontoPorDependente +=  numeroDependentes * DESCONTO_DEPENDENTE;
    }

    private void calcularIR() {
        TabelaIR tabelaIR = TabelaIR.FAIXA5;
        for (TabelaIR tabelaIR1 : TabelaIR.values()){
            if (tabelaIR1.getValorMaximo()!= null) {
                boolean acimaDoMinimo = salarioBruto > tabelaIR1.getValorMinimo();
                boolean abaixoDoMaximo = salarioBruto < tabelaIR1.getValorMaximo();
                if (acimaDoMinimo && abaixoDoMaximo) {
                    tabelaIR = tabelaIR1;
                    break;
                }
            } else {
                tabelaIR = tabelaIR1;
            }
        }
        descontoIR = (((salarioBruto - descontoPorDependente - descontoINSS) * tabelaIR.getAliquota())/100 - tabelaIR.getDeducao());
    }

    public void gerarFolhaPagamento (){
        this.calcularInss();
        this.calcularValorPorDependente();
        this.calcularIR();
        this.calcularSalarioLiquido();
    }
}
