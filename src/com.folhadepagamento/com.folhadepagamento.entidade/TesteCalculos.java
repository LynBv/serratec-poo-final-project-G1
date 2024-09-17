package com.folhadepagamento.com.folhadepagamento.entidade;

import com.folhadepagamento.com.folhadepagamento.exceptions.DependentException;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

public class TesteCalculos {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Elyn", "1234", LocalDate.now(), 5600.56);
        try {
            Dependente d1 = new Dependente
                    ("ana", "1234", LocalDate.now(), TipoParentesco.FILHO);
            try{
                f.adicionarDependente(d1);
            } catch (DependentException e){
                System.out.println(e.getMessage());
            }
        } catch (DependentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Dependente d1 = new Dependente
                    ("maria", "1224dasd",  LocalDate.now(), TipoParentesco.OUTROS);
            try{
                f.adicionarDependente(d1);
            } catch (DependentException e){
                System.out.println(e.getMessage());
            }
        } catch (DependentException e) {
            System.out.println(e.getMessage());
        }
       /* try {
            Dependente d1 = new Dependente
                    ("julia", "123dsad4",  LocalDate.now(), TipoParentesco.FILHO);
            try{
                f.adicionarDependente(d1);
            } catch (DependentException e){
                System.out.println(e.getMessage());
            }
        } catch (DependentException e) {
            System.out.println(e.getMessage());
        } */
        f.gerarFolhaPagamento();
        System.out.println(f.toString());

    }
}
