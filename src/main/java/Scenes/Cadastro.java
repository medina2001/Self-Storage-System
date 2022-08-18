package Scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro {
    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtSenha;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;


    public Cadastro() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setBounds(180, 159, 117, 29);
        frame.getContentPane().add(btnNewButton);

        txtNome = new JTextField();
        txtNome.setBackground(new Color(147, 112, 219));
        txtNome.setBounds(173, 45, 130, 26);
        frame.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setBackground(new Color(147, 112, 219));
        txtEmail.setBounds(173, 83, 130, 26);
        frame.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        txtSenha = new JTextField();
        txtSenha.setBackground(new Color(147, 112, 219));
        txtSenha.setBounds(173, 121, 130, 26);
        frame.getContentPane().add(txtSenha);
        txtSenha.setColumns(10);

        JLabel lblNewLabel = new JLabel("Cadastro");
        lblNewLabel.setBounds(208, 6, 61, 16);
        frame.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Nome");
        lblNewLabel_1.setBounds(100, 50, 61, 16);
        frame.getContentPane().add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("E-Mail");
        lblNewLabel_2.setBounds(100, 88, 61, 16);
        frame.getContentPane().add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Senha");
        lblNewLabel_3.setBounds(100, 126, 61, 16);
        frame.getContentPane().add(lblNewLabel_3);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtNome.getText();
                String email = txtEmail.getText();
                String senha = txtSenha.getText();
            }
        });
    }
}
