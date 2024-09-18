package com.folhadepagamento.com.folhadepagamento.servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener {

    private final String TITULO = "Folha de Pagamento";
    private final String INSTRUCAO_SELECIONAR_ARQUIVO_LEITURA = "Escolha o arquivo com os dados dos funcionarios.";
    private final String INSTRUCAO_SELECIONAR_ARQUIVO_ESCRITA = "Escolha o arquivo que deseja gravar a folha de pagamento.";
    private final String SELECIONAR_CAMINHO = "Digite o caminho do arquivo:";
    private final String GERAR_FP = "GERAR FOLHA DE PAGAMENTO";
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
    JPanel panelBloco;
    LeituraArquivo leitura;


    public Menu() {

        leitura = new LeituraArquivo();
        this.setTitle(TITULO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 340);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(criarPanelCabecalho());
        this.add(criarPanelProcurar());
        this.add(criarPanelGerarFP());
        //this.add(criarPanelBloco());


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonProcurar) {
            try {
                leitura.lerFuncionario(textFieldCaminhoLeitura.getText());

                labelResultadoProcura.setText(ARQUIVO_ENCONTRADO);
                panelGerarFP.setVisible(true);

            } catch (FileNotFoundException ex) {
                labelResultadoProcura.setText(ARQUIVO_NAO_ENCONTRADO);
                panelGerarFP.setVisible(false);
            }
            labelResultadoProcura.setVisible(true);
        }
        if (e.getSource() == buttonGerarFP) {
            try {
                EscritaArquivo.gravarFuncionarios(leitura.getFuncionarios(),textFieldCaminhoGravacao.getText());
                Desktop.getDesktop().open(new File(textFieldCaminhoGravacao.getText()));
                labelResultadoEscrita.setText(ARQUIVO_GERADO);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao criar o arquivo : " + ex.getMessage());
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
        labelInstrucaoCaminhoEscrita.setVisible(true);

        labelCaminhoEscrita = new JLabel(SELECIONAR_CAMINHO);
        labelCaminhoEscrita.setBounds(10, 30, 300, 15);
        labelCaminhoEscrita.setVisible(true);

        textFieldCaminhoGravacao = new JTextField();
        textFieldCaminhoGravacao.setBounds(9,55,400,26);
        textFieldCaminhoGravacao.setVisible(true);

        buttonGerarFP = new JButton(GERAR_FP);
        buttonGerarFP.setLocation(420,55);
        buttonGerarFP.setSize(buttonGerarFP.getPreferredSize());
        buttonGerarFP.setFocusable(false);
        buttonGerarFP.setBorder(BorderFactory.createEtchedBorder());
        buttonGerarFP.setBackground(Color.LIGHT_GRAY);
        buttonGerarFP.addActionListener(this);
        buttonGerarFP.setVisible(true);

        labelResultadoEscrita = new JLabel();
        labelResultadoEscrita.setBounds(15, 85, 300, 15);
        labelResultadoEscrita.setForeground(Color.gray);
        labelResultadoEscrita.setVisible(true);

        panelGerarFP = new JPanel(null);
        panelGerarFP.setBounds(0,170,700,300);
        panelGerarFP.add(labelInstrucaoCaminhoEscrita);
        panelGerarFP.add(labelCaminhoEscrita);
        panelGerarFP.add(buttonGerarFP);
        panelGerarFP.add(labelResultadoEscrita);
        panelGerarFP.add(textFieldCaminhoGravacao);
        panelGerarFP.setVisible(false);

        return panelGerarFP;
    }

    public JPanel criarPanelBloco(){
        panelBloco = new JPanel();
        panelGerarFP.setBounds(0,170,700,300);
        panelGerarFP.setBackground(Color.LIGHT_GRAY);
        panelGerarFP.setVisible(true);

        return panelBloco;
    }

}
