package DAO;

import Models.Armazenamento;
import Models.Cliente;
import ServiceLayer.DatabaseConnectionSetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ArmazenamentoDAO {

    private final Connection conexao;

    public ArmazenamentoDAO() {
        this.conexao = DatabaseConnectionSetup.getConnection();
    }

    public void criarArmazenamento(Armazenamento armazenamento) {
        try{
            Statement st = conexao.createStatement();
            String query = String.format("INSERT INTO self_storage.armazenamentos (categoria, endereco, volume, custo) VALUES ('%s', '%s', '%s', '%s')",
                    armazenamento.getCategoria(), armazenamento.getEndereco(), armazenamento.getVolume(), armazenamento.getCusto()
            );
            st.executeUpdate(query);
            System.out.printf("Armazenamento do tipo %s cadastrado com sucesso!", armazenamento.getCategoria());
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
