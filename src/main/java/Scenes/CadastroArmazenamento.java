package Scenes;

import DAO.ArmazenamentoDAO;
import DAO.ClienteDAO;
import Models.Armazenamento;
import Models.Cliente;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroArmazenamento {

    private JFrame frame;
    private JTextField enderecoTextField;
    private JTextField volumeTextField;
    private JTextField custoTextField;

    public CadastroArmazenamento() {
        initialize();
        this.frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton backBtn = new JButton("<Voltar");
        backBtn.setBounds(6, 6, 85, 29);
        frame.getContentPane().add(backBtn);

        JLabel titleLabel = new JLabel("Cadastro de Armazenamentos");
        titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        titleLabel.setBounds(109, 6, 267, 16);
        frame.getContentPane().add(titleLabel);

        JComboBox categoriaComboBox = new JComboBox();
        categoriaComboBox.setBounds(144, 49, 196, 27);
        frame.getContentPane().add(categoriaComboBox);
        categoriaComboBox.addItem("Guarda-Volumes");
        categoriaComboBox.addItem("Contêineres");
        categoriaComboBox.addItem("Quartos");
        categoriaComboBox.addItem("Galpões");

        enderecoTextField = new JTextField();
        enderecoTextField.setForeground(new Color(255, 255, 255));
        enderecoTextField.setBackground(new Color(147, 112, 219));
        enderecoTextField.setBounds(144, 88, 196, 26);
        frame.getContentPane().add(enderecoTextField);
        enderecoTextField.setColumns(10);

        volumeTextField = new JTextField();
        volumeTextField.setForeground(new Color(255, 255, 255));
        volumeTextField.setBackground(new Color(147, 112, 219));
        volumeTextField.setBounds(144, 126, 196, 26);
        frame.getContentPane().add(volumeTextField);
        volumeTextField.setColumns(10);

        custoTextField = new JTextField();
        custoTextField.setForeground(new Color(255, 255, 255));
        custoTextField.setBackground(new Color(147, 112, 219));
        custoTextField.setBounds(144, 164, 196, 26);
        frame.getContentPane().add(custoTextField);
        custoTextField.setColumns(10);

        JButton cadastrarBtn = new JButton("Cadastrar");
        cadastrarBtn.setBounds(184, 202, 117, 29);
        frame.getContentPane().add(cadastrarBtn);

        JLabel enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(60, 93, 61, 16);
        frame.getContentPane().add(enderecoLabel);

        JLabel volumeLabel = new JLabel("Volume");
        volumeLabel.setBounds(60, 131, 61, 16);
        frame.getContentPane().add(volumeLabel);

        JLabel custoLabel = new JLabel("Custo");
        custoLabel.setBounds(60, 169, 61, 16);
        frame.getContentPane().add(custoLabel);

        JLabel categoriaLabel = new JLabel("Categoria");
        categoriaLabel.setBounds(60, 53, 61, 16);
        frame.getContentPane().add(categoriaLabel);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView homeView = new HomeView();
                frame.setVisible(false);
            }
        });

        cadastrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoria = categoriaComboBox.getSelectedItem() !=null ? categoriaComboBox.getSelectedItem().toString() : "";
                String endereco = enderecoTextField.getText();
                String volume = volumeTextField.getText();
                Float custo = Float.parseFloat(custoTextField.getText());

                Armazenamento armazenamento = new Armazenamento(endereco, categoria, volume, custo);
                ArmazenamentoDAO armazenamentoDAO = new ArmazenamentoDAO();
                try {
                    armazenamentoDAO.criarArmazenamento(armazenamento);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
