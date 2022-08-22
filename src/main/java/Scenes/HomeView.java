package Scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView {

    private JFrame frame;

    public HomeView() {
        initialize();
        this.frame.setVisible(true);
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Self Storage System");
        lblNewLabel.setBounds(0, 0, 450, 21);
        lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel);

        JButton btnAluguelDeArmazenamento = new JButton("Aluguel de Armazenamento");
        btnAluguelDeArmazenamento.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btnAluguelDeArmazenamento.setBounds(107, 46, 236, 29);
        frame.getContentPane().add(btnAluguelDeArmazenamento);

        JButton btnCadastroDeCliente = new JButton("Cadastro de Cliente");
        btnCadastroDeCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btnCadastroDeCliente.setBounds(136, 121, 179, 29);
        frame.getContentPane().add(btnCadastroDeCliente);

        JButton btnCadastroDeArmazenamentos = new JButton("Cadastro de Armazenamento");
        btnCadastroDeArmazenamentos.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btnCadastroDeArmazenamentos.setBounds(99, 196, 252, 29);
        frame.getContentPane().add(btnCadastroDeArmazenamentos);

        btnAluguelDeArmazenamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlugarArmazenamento alugarArmazenamento = new AlugarArmazenamento();
                frame.setVisible(false);
            }
        });

        btnCadastroDeCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroCliente cadastroCliente = new CadastroCliente();
                frame.setVisible(false);
            }
        });

        btnCadastroDeArmazenamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroArmazenamento cadastroArmazenamento = new CadastroArmazenamento();
                frame.setVisible(false);
            }
        });

    }

}
