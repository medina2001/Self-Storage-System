package Scenes;

import DAO.ArmazenamentoDAO;
import Infrastructure.Extensions.DateExtension;
import Models.Aluguel;
import Models.Armazenamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Relatorio {

    Aluguel aluguel;
    String nomeCliente;
    String categoriaArmazenamento;
    ArmazenamentoDAO armazenamentoDAO = new ArmazenamentoDAO();
    Armazenamento armazenamento = null;
    DateExtension dateExtension = new DateExtension();

    private JFrame frame;

    public Relatorio() {
        initialize();
        this.frame.setVisible(true);
    }

    public Relatorio(Aluguel aluguel, String nomeCliente, String categoriaArmazenamento){
        this.aluguel = aluguel;
        this.nomeCliente = nomeCliente;
        this.categoriaArmazenamento = categoriaArmazenamento;
        this.armazenamento = this.armazenamentoDAO.getArmazenamentoByName(categoriaArmazenamento);
        initialize();
        this.frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLbl = new JLabel("Relatório de Aluguel");
        titleLbl.setBounds(150, 6, 127, 16);
        frame.getContentPane().add(titleLbl);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(6, 35, 127, 16);
        frame.getContentPane().add(lblCliente);

        JLabel lblArmazenamento = new JLabel("Armazenamento:");
        lblArmazenamento.setBounds(6, 63, 127, 16);
        frame.getContentPane().add(lblArmazenamento);

        JLabel lblNUnidade = new JLabel("Nº Unidade:");
        lblNUnidade.setBounds(6, 91, 127, 16);
        frame.getContentPane().add(lblNUnidade);

        JLabel lblCusto = new JLabel("Custo:");
        lblCusto.setBounds(6, 119, 127, 16);
        frame.getContentPane().add(lblCusto);

        JLabel lblDataAluguel = new JLabel("Data Aluguel:");
        lblDataAluguel.setBounds(6, 147, 127, 16);
        frame.getContentPane().add(lblDataAluguel);

        JLabel lblDataDevoluo = new JLabel("Data Devolução:");
        lblDataDevoluo.setBounds(6, 175, 127, 16);
        frame.getContentPane().add(lblDataDevoluo);

        JLabel lblSeguro = new JLabel("Seguro:");
        lblSeguro.setBounds(6, 203, 127, 16);
        frame.getContentPane().add(lblSeguro);

        JLabel lblChaveExtra = new JLabel("Chave Extra:");
        lblChaveExtra.setBounds(6, 231, 127, 16);
        frame.getContentPane().add(lblChaveExtra);

        JLabel lblControle = new JLabel("Climatização:");
        lblControle.setBounds(6, 259, 127, 16);
        frame.getContentPane().add(lblControle);

        JCheckBox seguroCB = new JCheckBox("");
        seguroCB.setBounds(131, 199, 128, 23);
        switch (aluguel.getSeguro()){
            case 1:
                seguroCB.setSelected(true);
                break;
            case 0:
                seguroCB.setSelected(false);
                break;
            default:
                seguroCB.setText("N/A");
        }
        frame.getContentPane().add(seguroCB);

        JCheckBox chaveCB = new JCheckBox("");
        chaveCB.setBounds(131, 227, 128, 23);
        switch (aluguel.getChaveExtra()){
            case 1:
                chaveCB.setSelected(true);
                break;
            case 0:
                chaveCB.setSelected(false);
                break;
            default:
                chaveCB.setText("N/A");
        }
        frame.getContentPane().add(chaveCB);

        JCheckBox controleClimaCB = new JCheckBox("");
        controleClimaCB.setBounds(131, 255, 128, 23);
        switch (aluguel.getControleClimatico()){
            case 1:
                controleClimaCB.setSelected(true);
                break;
            case 0:
                controleClimaCB.setSelected(false);
                break;
            default:
                controleClimaCB.setText("N/A");
        }
        frame.getContentPane().add(controleClimaCB);

        JLabel nameLabel = new JLabel(nomeCliente);
        nameLabel.setBounds(160, 35, 284, 16);
        frame.getContentPane().add(nameLabel);

        JLabel categoriaLabel = new JLabel(categoriaArmazenamento);
        categoriaLabel.setBounds(160, 63, 284, 16);
        frame.getContentPane().add(categoriaLabel);

        JLabel enderecoLabel = new JLabel(armazenamento.getEndereco());
        enderecoLabel.setBounds(160, 91, 284, 16);
        frame.getContentPane().add(enderecoLabel);

        JLabel custoLabel = new JLabel("");
        custoLabel.setBounds(160, 119, 284, 16);
        String custo = String.format("R$%.2f/mês", armazenamento.getCusto());
        custoLabel.setText(custo);
        frame.getContentPane().add(custoLabel);

        JLabel dataInicioLabel = new JLabel(dateExtension.dateToString(aluguel.getDataInicio()));
        dataInicioLabel.setBounds(160, 147, 284, 16);
        frame.getContentPane().add(dataInicioLabel);

        JLabel dataFimLabel = new JLabel(dateExtension.dateToString(aluguel.getDataFim()));
        dataFimLabel.setBounds(160, 175, 284, 16);
        frame.getContentPane().add(dataFimLabel);

        JButton okBtn = new JButton("Ok");
        okBtn.setBounds(155, 290, 117, 29);
        frame.getContentPane().add(okBtn);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
