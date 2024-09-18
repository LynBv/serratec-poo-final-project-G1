package com.folhadepagamento.com.folhadepagamento.servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener {

    private final String TITULO = "Folha de Pagamento";
    private final String INSTRUCAO_SELECIONAR_ARQUIVO_LEITURA = "Escolha o arquivo com os dados dos funcionarios.";
    private final String INSTRUCAO_SELECIONAR_ARQUIVO_ESCRITA = "Escolha o arquivo que deseja gravar a folha de pagamento.";
    private final String SELECIONAR_CAMINHO = "Digite o caminho do arquivo:";
    private final String GERAR_FP = "Gerar Folha de Pagamento";
    private final String PROCURAR_ARQUIVO = "PROCURAR";
    private final String ARQUIVO_ENCONTRADO = "arquivo encontrado!";
    private final String ARQUIVO_NAO_ENCONTRADO = "arquivo nao encontrado.";
    private final String ARQUIVO_GERADO = "arquivo gerado!";
    private final String ARQUIVO_NAO_GERADO = "erro ao gerar arquivo.";
    private final String FOLHA_GERADA = "FOLHA GERADA!";
    JLabel labelCabecalho;
    JLabel labelInstrucaoCaminhoLeitura;
    JLabel labelInstrucaoCaminhoEscrita;
    JLabel labelCaminho;
    JLabel labelCaminhoEscrita;
    JLabel labelResultadoProcura;
    JLabel labelResultadoEscrita;
    JTextField textFieldCaminhoLeitura;
    JTextField textFieldCaminhoGravacao;
    JButton buttonProcurar;
    JButton buttonGerarFP;
    JPanel panelCabecalho;
    JPanel panelProcurar;
    JPanel panelGerarFP;
    LeituraArquivo leitura;


    public Menu() {

        leitura = new LeituraArquivo();
        this.setTitle(TITULO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 320);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(criarPanelCabecalho());
        this.add(criarPanelProcurar());
        this.add(criarPanelGerarFP());

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonProcurar) {
            try {
                leitura.lerFuncionario(textFieldCaminhoLeitura.getText());

                labelInstrucaoCaminhoEscrita.setVisible(true);
                buttonGerarFP.setVisible(true);;
                textFieldCaminhoGravacao.setVisible(true);
                labelResultadoProcura.setText(ARQUIVO_ENCONTRADO);
                labelCaminhoEscrita.setVisible(true);

            } catch (FileNotFoundException ex) {
                labelResultadoProcura.setText(ARQUIVO_NAO_ENCONTRADO);

                buttonGerarFP.setVisible(false);
                textFieldCaminhoGravacao.setVisible(false);
                labelInstrucaoCaminhoEscrita.setVisible(false);
                labelCaminhoEscrita.setVisible(false);
                labelResultadoEscrita.setVisible(false);

            }
            labelResultadoProcura.setVisible(true);
        }
        if (e.getSource() == buttonGerarFP) {
            try {
                EscritaArquivo.gravarFuncionarios(leitura.getFuncionarios(),textFieldCaminhoGravacao.getText());
                labelResultadoEscrita.setText(ARQUIVO_GERADO);

            } catch (IOException ex) {
                System.err.println("Erro ao criar o arquivo : " + ex.getMessage());
                labelResultadoEscrita.setText(ARQUIVO_NAO_GERADO);
            }
            labelResultadoEscrita.setVisible(true);

        }
    }

    public JPanel criarPanelCabecalho() {
        labelCabecalho = new JLabel(TITULO);
        labelCabecalho.setLocation(280,20);
        labelCabecalho.setSize(labelCabecalho.getPreferredSize());
        labelCabecalho.setForeground(Color.white);

        panelCabecalho = new JPanel();
        panelCabecalho.setBackground(Color.gray);
        panelCabecalho.setBounds(0,0,700,50);
        panelCabecalho.setVisible(true);
        panelCabecalho.setLayout(null);
        panelCabecalho.add(labelCabecalho);

        return panelCabecalho;
    }

    public JPanel criarPanelProcurar() {
        labelInstrucaoCaminhoLeitura = new JLabel(INSTRUCAO_SELECIONAR_ARQUIVO_LEITURA);
        labelInstrucaoCaminhoLeitura.setBounds(10, 10, 300, 15);

        labelCaminho = new JLabel(SELECIONAR_CAMINHO);
        labelCaminho.setBounds(10, 30, 300, 15);

        textFieldCaminhoLeitura = new JTextField();
        textFieldCaminhoLeitura.setBounds(9,55,400,26);

        buttonProcurar = new JButton(PROCURAR_ARQUIVO);
        buttonProcurar.setLocation(420,55);
        buttonProcurar.setSize(buttonProcurar.getPreferredSize());
        buttonProcurar.setVisible(true);
        buttonProcurar.setFocusable(false);
        buttonProcurar.setBorder(BorderFactory.createEtchedBorder());
        buttonProcurar.setBackground(Color.LIGHT_GRAY);
        buttonProcurar.addActionListener(this);

        labelResultadoProcura = new JLabel();
        labelResultadoProcura.setBounds(15, 85, 300, 15);
        labelResultadoProcura.setForeground(Color.gray);
        labelResultadoProcura.setVisible(false);

        panelProcurar = new JPanel(null);
        panelProcurar.setBounds(0,50,700,120);
        panelProcurar.setVisible(true);
        panelProcurar.add(labelInstrucaoCaminhoLeitura);
        panelProcurar.add(labelCaminho);
        panelProcurar.add(buttonProcurar);
        panelProcurar.add(textFieldCaminhoLeitura);
        panelProcurar.add(labelResultadoProcura);

        return panelProcurar;
    }

    public JPanel criarPanelGerarFP(){
        labelInstrucaoCaminhoEscrita = new JLabel(INSTRUCAO_SELECIONAR_ARQUIVO_ESCRITA);
        labelInstrucaoCaminhoEscrita.setBounds(10, 10, 400, 15);
        labelInstrucaoCaminhoEscrita.setVisible(false);

        labelCaminhoEscrita = new JLabel(SELECIONAR_CAMINHO);
        labelCaminhoEscrita.setBounds(10, 30, 300, 15);
        labelCaminhoEscrita.setVisible(false);

        textFieldCaminhoGravacao = new JTextField();
        textFieldCaminhoGravacao.setBounds(9,55,400,26);
        textFieldCaminhoGravacao.setVisible(false);

        buttonGerarFP = new JButton(GERAR_FP);
        buttonGerarFP.setLocation(420,55);
        buttonGerarFP.setSize(buttonGerarFP.getPreferredSize());
        buttonGerarFP.setFocusable(false);
        buttonGerarFP.setBorder(BorderFactory.createEtchedBorder());
        buttonGerarFP.setBackground(Color.white);
        buttonGerarFP.addActionListener(this);
        buttonGerarFP.setVisible(false);

        labelResultadoEscrita = new JLabel();
        labelResultadoEscrita.setBounds(15, 85, 300, 15);
        labelResultadoEscrita.setForeground(Color.darkGray);
        labelResultadoEscrita.setVisible(false);

        panelGerarFP = new JPanel(null);
        panelGerarFP.setBounds(0,170,700,300);
        panelGerarFP.setBackground(Color.LIGHT_GRAY);
        panelGerarFP.add(labelInstrucaoCaminhoEscrita);
        panelGerarFP.add(labelCaminhoEscrita);
        panelGerarFP.add(buttonGerarFP);
        panelGerarFP.add(labelResultadoEscrita);
        panelGerarFP.add(textFieldCaminhoGravacao);
        panelGerarFP.setVisible(true);

        return panelGerarFP;
    }

}
