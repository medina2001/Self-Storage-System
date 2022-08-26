package Scenes;

import DAO.AluguelDAO;
import DAO.ArmazenamentoDAO;
import DAO.ClienteDAO;
import Infrastructure.Extensions.DateExtension;
import Models.Aluguel;
import Models.Armazenamento;
import Models.Cliente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AlugarArmazenamento {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ArmazenamentoDAO armazenamentoDAO = new ArmazenamentoDAO();
    private AluguelDAO aluguelDAO = new AluguelDAO();
    private static final DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    public AlugarArmazenamento() {
        initialize();
        this.frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 390);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton backBtn = new JButton("<Voltar");
        backBtn.setBounds(6, 6, 85, 29);
        frame.getContentPane().add(backBtn);

        JLabel titleLabel = new JLabel("Aluguel de Armazenamento");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        titleLabel.setBounds(145, 6, 218, 20);
        frame.getContentPane().add(titleLabel);

        JLabel categoriaCBLabel = new JLabel("Categoria:");
        categoriaCBLabel.setBounds(75, 40, 91, 16);
        frame.getContentPane().add(categoriaCBLabel);

        JComboBox categoriasComboBox = new JComboBox();
        categoriasComboBox.setBackground(new Color(147, 112, 219));
        categoriasComboBox.setBounds(145, 38, 218, 27);
        this.getArmazenamentos(categoriasComboBox);
        frame.getContentPane().add(categoriasComboBox);

        JLabel clienteCBLabel = new JLabel("Cliente:");
        clienteCBLabel.setBounds(75, 80, 91, 16);
        frame.getContentPane().add(clienteCBLabel);

        JComboBox clientesComboBox = new JComboBox();
        clientesComboBox.setBackground(new Color(147, 112, 219));
        clientesComboBox.setBounds(145, 77, 218, 27);
        this.getClientes(clientesComboBox);
        frame.getContentPane().add(clientesComboBox);

        JFormattedTextField dataInicioTF = new JFormattedTextField();
        dataInicioTF.setBounds(145, 116, 218, 26);
        try {
            MaskFormatter dateMask = new MaskFormatter("####/##/##");
            dateMask.install(dataInicioTF);
        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        frame.getContentPane().add(dataInicioTF);

        JFormattedTextField dataFimTF = new JFormattedTextField();
        try {
            MaskFormatter dateMask = new MaskFormatter("####/##/##");
            dateMask.install(dataFimTF);
        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        dataFimTF.setBounds(145, 154, 218, 26);
        frame.getContentPane().add(dataFimTF);

        JCheckBox seguroCB = new JCheckBox("Seguro");
        seguroCB.setBounds(145, 192, 75, 23);
        frame.getContentPane().add(seguroCB);

        JCheckBox chaveExtraCB = new JCheckBox("Chave Extra");
        chaveExtraCB.setBounds(145, 227, 106, 23);
        frame.getContentPane().add(chaveExtraCB);

        JCheckBox controleClimaticoCB = new JCheckBox("Controle Climático");
        controleClimaticoCB.setBounds(145, 262, 150, 23);
        frame.getContentPane().add(controleClimaticoCB);

        JButton alugarBtn = new JButton("Alugar");
        alugarBtn.setBackground(new Color(255, 255, 0));
        alugarBtn.setBounds(196, 297, 117, 29);
        frame.getContentPane().add(alugarBtn);

        JLabel lblNewLabel_1 = new JLabel("Data de Início:");
        lblNewLabel_1.setBounds(16, 121, 91, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Data de Devolução:");
        lblNewLabel_1_1.setBounds(16, 159, 122, 16);
        frame.getContentPane().add(lblNewLabel_1_1);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView homeView = new HomeView();
                frame.setVisible(false);
            }
        });

        alugarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluguel aluguel = new Aluguel();
                try {
                    DateExtension dateExtension = new DateExtension();
                    String dataInicio = dataInicioTF.getText();
                    String dataFim = dataFimTF.getText();
                    String dataI = dateExtension.normalToDBDate(dataInicio);
                    String dataF = dateExtension.normalToDBDate(dataFim);
                    Integer seguro = seguroCB.isSelected() ? 1 : 0;
                    Integer chaveExtra = chaveExtraCB.isSelected() ? 1 : 0;
                    Integer controleClimativo = controleClimaticoCB.isSelected() ? 1 : 0;
                    String cliente = clientesComboBox.getSelectedItem() !=null ? clientesComboBox.getSelectedItem().toString() : "";
                    String categoria = categoriasComboBox.getSelectedItem() !=null ? categoriasComboBox.getSelectedItem().toString() : "";

                    aluguel.setDataInicio(dateExtension.stringToDate(dataI));
                    aluguel.setDataFim(dateExtension.stringToDate(dataF));
                    aluguel.setClientId(clienteDAO.getClienteIdByName(cliente));
                    aluguel.setArmazenamentoId(armazenamentoDAO.getArmazenamentoIdByName(categoria));
                    aluguel.setSeguro(seguro);
                    aluguel.setChaveExtra(chaveExtra);
                    aluguel.setControleClimatico(controleClimativo);

                    aluguelDAO.criarAluguel(aluguel);
                    HomeView homeView = new HomeView();
                    Relatorio relatorio = new Relatorio(aluguel, cliente, categoria);
                } catch (Exception exception) {
                    System.out.println(exception.getLocalizedMessage());
                }
                frame.setVisible(false);
            }
        });

    }

    private void getClientes(JComboBox comboBox){
        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteDAO.getClientes();
         for (Cliente cliente : clientes) {
             comboBox.addItem(cliente.getName());
         }
    }

    private void getArmazenamentos(JComboBox comboBox){
        List<Armazenamento> armazenamentos = new ArrayList<>();
        armazenamentos = aluguelDAO.getArmazenamentosDisponiveis();
        for (Armazenamento armazenamento : armazenamentos) {
            comboBox.addItem(armazenamento.getCategoria());
        }
    }

}
