package DAO;

import Models.Cliente;
import ServiceLayer.DatabaseConnectionSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private final Connection conexao;

    public ClienteDAO() {
        this.conexao = DatabaseConnectionSetup.getConnection();
    }

    public void criarCliente(Cliente cliente) throws Exception {
        try{
            Statement st = conexao.createStatement();
            String query = String.format("INSERT INTO self_storage.clientes (name, email, senha) VALUES ('%s', '%s', '%s')",
                    cliente.getName(), cliente.getEmail(), cliente.getSenha()
            );
            st.executeUpdate(query);
            System.out.printf("Cliente %s cadastrado com sucesso!", cliente.getName());
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public List<Cliente> getClientes() throws Exception{
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tap_db.users u WHERE u.type = 'CLIENT'");

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()){
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
            System.out.println(clientes.size());
            return clientes;
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
