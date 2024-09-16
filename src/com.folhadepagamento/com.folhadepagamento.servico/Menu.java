package com.folhadepagamento.com.folhadepagamento.servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private String titulo = "Folha de Pagamento";
    private String instrucaoSelecionarArquivo = "Escolha o arquivos com os dados dos funcionarios";
    private String selecionarArquivoCaminho = "Digite o caminho do arquivo:";
    private String selecionarArquivoExplorer = "Selecionar pelo Explorer";
    private String gerarFP = "Gerar Folha de Pagamento";
    private String procurarArquivo = "PROCURAR";



    public Menu() {

        var cabecalho = new JLabel(titulo);
        cabecalho.setHorizontalAlignment(JLabel.CENTER);

        var instrucao = new JLabel(instrucaoSelecionarArquivo);
        instrucao.setForeground(Color.WHITE);
        instrucao.setHorizontalAlignment(JLabel.LEFT);

        var caminho = new JLabel(selecionarArquivoCaminho);
        caminho.setHorizontalAlignment(JLabel.LEFT);

        var explorer = new JLabel(selecionarArquivoExplorer);

        var procurar = new JButton(procurarArquivo);
        procurar.setLayout(null);
        procurar.setSize(100,100);
        procurar.setVisible(true);
        procurar.setFont(new Font("Tahoma", Font.ITALIC, 12));

        var painelCabecalho = new JPanel();
        painelCabecalho.setBounds(0,0,750,50);
        painelCabecalho.setVisible(true);
        painelCabecalho.setLayout(new BorderLayout());
        painelCabecalho.add(cabecalho);

        var painelInstrucao = new JPanel();
        painelInstrucao.setBackground(Color.blue);
        painelInstrucao.setBounds(0,50,750,50);
        painelInstrucao.setVisible(true);
        painelInstrucao.setLayout(new BorderLayout());
        painelInstrucao.add(instrucao);

        var painelInstrucaoCaminho = new JPanel();
        painelInstrucaoCaminho.setBackground(Color.green);
        painelInstrucaoCaminho.setBounds(0,100,750,50);
        painelInstrucaoCaminho.setVisible(true);
        painelInstrucaoCaminho.setLayout(new BorderLayout());
        painelInstrucaoCaminho.add(caminho);

        var painelCaminho = new JPanel();
        painelCaminho.setBackground(Color.yellow);
        painelCaminho.setBounds(0,150,750,50);
        painelCaminho.setVisible(true);
        painelCaminho.add(procurar);

        this.setTitle(titulo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.add(painelCabecalho);
        this.add(painelInstrucao);
        this.add(painelInstrucaoCaminho);
        this.add(painelCaminho);


    }
}
