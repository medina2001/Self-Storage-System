package Scenes;

import DAO.ClienteDAO;
import Models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCliente {
    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtSenha;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel senhaLabel;


    public CadastroCliente() {
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

        JButton cadastrarBtn = new JButton("Cadastrar");
        cadastrarBtn.setBounds(180, 159, 117, 29);
        frame.getContentPane().add(cadastrarBtn);

        txtNome = new JTextField();
        txtNome.setForeground(new Color(255, 255, 255));
        txtNome.setBackground(new Color(147, 112, 219));
        txtNome.setBounds(173, 45, 130, 26);
        frame.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setForeground(new Color(255, 255, 255));
        txtEmail.setBackground(new Color(147, 112, 219));
        txtEmail.setBounds(173, 83, 130, 26);
        frame.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        txtSenha = new JTextField();
        txtSenha.setForeground(new Color(255, 255, 255));
        txtSenha.setBackground(new Color(147, 112, 219));
        txtSenha.setBounds(173, 121, 130, 26);
        frame.getContentPane().add(txtSenha);
        txtSenha.setColumns(10);

        JLabel cadastroLbl = new JLabel("Cadastro Cliente");
        cadastroLbl.setBounds(208, 6, 61, 16);
        frame.getContentPane().add(cadastroLbl);

        nameLabel = new JLabel("Nome");
        nameLabel.setBounds(100, 50, 61, 16);
        frame.getContentPane().add(nameLabel);

        emailLabel = new JLabel("E-Mail");
        emailLabel.setBounds(100, 88, 61, 16);
        frame.getContentPane().add(emailLabel);

        senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(100, 126, 61, 16);
        frame.getContentPane().add(senhaLabel);

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
                String name = txtNome.getText();
                String email = txtEmail.getText();
                String senha = txtSenha.getText();
                Cliente cliente = new Cliente(name, email, senha);
                ClienteDAO clienteDAO = new ClienteDAO();
                try {
                    clienteDAO.criarCliente(cliente);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
