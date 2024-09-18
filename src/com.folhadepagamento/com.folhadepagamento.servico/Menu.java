package com.folhadepagamento.com.folhadepagamento.servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Menu extends JFrame implements ActionListener {

    private final String TITULO = "Folha de Pagamento";
    private final String INSTRUCAO_SELECIONAR_ARQUIVO = "Escolha o arquivos com os dados dos funcionarios.";
    private final String SELECIONAR_CAMINHO = "Digite o caminho do arquivo:";
    private final String GERAR_FP = "Gerar Folha de Pagamento";
    private final String PROCURAR_ARQUIVO = "PROCURAR";
    private final String ARQUIVO_ENCONTRADO = "arquivo encontrado!";
    private final String ARQUIVO_NAO_ENCONTRADO = "arquivo nao encontrado.";
    private final String FOLHA_GERADA = "FOLHA GERADA!";
    JLabel labelCabecalho;
    JLabel labelInstrucao;
    JLabel labelCaminho;
    JLabel labelResultadoProcura;
    JTextField textFieldCaminho;
    JButton buttonProcurar;
    JButton buttonGerarFP;
    JPanel panelCabecalho;
    JPanel panelProcurar;
    JPanel panelGerarFP;
    JOptionPane popUpFP;


    public Menu() {

        this.setTitle(TITULO);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 300);
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
                LeituraArquivo.lerFuncionario(textFieldCaminho.getText());

                buttonGerarFP.setVisible(true);
                labelResultadoProcura.setVisible(true);
                labelResultadoProcura.setText(ARQUIVO_ENCONTRADO);

            } catch (FileNotFoundException ex) {
                labelResultadoProcura.setText(ARQUIVO_NAO_ENCONTRADO);
                labelResultadoProcura.setVisible(true);
                buttonGerarFP.setVisible(false);
            }
        }
        if (e.getSource() == buttonGerarFP) {

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
        labelInstrucao = new JLabel(INSTRUCAO_SELECIONAR_ARQUIVO);
        labelInstrucao.setBounds(10, 10, 300, 15);

        labelCaminho = new JLabel(SELECIONAR_CAMINHO);
        labelCaminho.setBounds(10, 30, 300, 15);

        textFieldCaminho = new JTextField();
        textFieldCaminho.setBounds(9,55,400,26);

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
        panelProcurar.setBounds(0,50,700,130);
        panelProcurar.setVisible(true);
        panelProcurar.add(labelInstrucao);
        panelProcurar.add(labelCaminho);
        panelProcurar.add(buttonProcurar);
        panelProcurar.add(textFieldCaminho);
        panelProcurar.add(labelResultadoProcura);

        return panelProcurar;
    }

    public JPanel criarPanelGerarFP(){

        buttonGerarFP = new JButton(GERAR_FP);
        buttonGerarFP.setLocation(250,10);
        buttonGerarFP.setSize(buttonGerarFP.getPreferredSize());
        buttonGerarFP.setFocusable(false);
        buttonGerarFP.setBorder(BorderFactory.createEtchedBorder());
        buttonGerarFP.setBackground(Color.white);
        buttonGerarFP.addActionListener(this);
        buttonGerarFP.setVisible(false);

        panelGerarFP = new JPanel(null);
        panelGerarFP.setBounds(0,180,700,300);
        panelGerarFP.setBackground(Color.LIGHT_GRAY);
        panelGerarFP.add(buttonGerarFP);
        panelGerarFP.setVisible(true);

        return panelGerarFP;
    }

    public JOptionPane criarPopUpFP(){
        popUpFP = new JOptionPane(FOLHA_GERADA);
        popUpFP.createDialog(null);
        return popUpFP;
    }
}
