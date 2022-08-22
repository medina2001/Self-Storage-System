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

    public void criarCliente(Cliente cliente) {
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

    public List<Cliente> getClientes(){
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM self_storage.clientes");

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()){
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
            return clientes;
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Integer getClienteIdByName(String nomeCliente){
        try{
            Statement st = conexao.createStatement();
            String query = String.format("SELECT id FROM self_storage.clientes WHERE name='%s';", nomeCliente);
            ResultSet rs = st.executeQuery(query);
            Integer id = null;
            if(rs.next()){
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
