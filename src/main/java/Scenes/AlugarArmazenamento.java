package Scenes;

import DAO.AluguelDAO;
import DAO.ArmazenamentoDAO;
import DAO.ClienteDAO;
import Models.Armazenamento;
import Models.Cliente;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
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

        JLabel lblNewLabel = new JLabel("Aluguel de Armazenamento");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblNewLabel.setBounds(145, 6, 218, 20);
        frame.getContentPane().add(lblNewLabel);

        JComboBox categoriasComboBox = new JComboBox();
        categoriasComboBox.setBackground(new Color(147, 112, 219));
        categoriasComboBox.setBounds(145, 38, 218, 27);
        this.getArmazenamentos(categoriasComboBox);
        frame.getContentPane().add(categoriasComboBox);

        JComboBox clientesComboBox = new JComboBox();
        clientesComboBox.setBackground(new Color(147, 112, 219));
        clientesComboBox.setBounds(145, 77, 218, 27);
        this.getClientes(clientesComboBox);
        frame.getContentPane().add(clientesComboBox);

        JFormattedTextField textField = new JFormattedTextField(df);
        textField.setBounds(145, 116, 218, 26);
        textField.setColumns(11);
        try {
            MaskFormatter dateMask = new MaskFormatter("####/##/##");
            dateMask.install(textField);
        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        frame.getContentPane().add(textField);

        JFormattedTextField textField_1 = new JFormattedTextField(df);
        textField_1.setColumns(11);
        try {
            MaskFormatter dateMask = new MaskFormatter("####/##/##");
            dateMask.install(textField_1);
        } catch (ParseException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        textField_1.setBounds(145, 154, 218, 26);
        frame.getContentPane().add(textField_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Seguro");
        chckbxNewCheckBox.setBounds(145, 192, 75, 23);
        frame.getContentPane().add(chckbxNewCheckBox);

        JCheckBox chckbxChaveExtra = new JCheckBox("Chave Extra");
        chckbxChaveExtra.setBounds(145, 227, 106, 23);
        frame.getContentPane().add(chckbxChaveExtra);

        JCheckBox chckbxControleClimtico = new JCheckBox("Controle Climático");
        chckbxControleClimtico.setBounds(145, 262, 150, 23);
        frame.getContentPane().add(chckbxControleClimtico);

        JButton btnNewButton = new JButton("Alugar");
        btnNewButton.setBackground(new Color(255, 255, 0));
        btnNewButton.setBounds(196, 297, 117, 29);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Data de Início:");
        lblNewLabel_1.setBounds(16, 121, 91, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Data de Devolução:");
        lblNewLabel_1_1.setBounds(16, 159, 122, 16);
        frame.getContentPane().add(lblNewLabel_1_1);
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
