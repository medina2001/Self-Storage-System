package DAO;

import Models.Armazenamento;
import ServiceLayer.DatabaseConnectionSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Armazenamento> getArmazenamentos(){
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM self_storage.armazenamentos");

            List<Armazenamento> armazenamentos = new ArrayList<>();

            while (rs.next()){
                armazenamentos.add(new Armazenamento(rs.getInt("id"),
                        rs.getString("endereco"),
                        rs.getString("categoria"),
                        rs.getString("volume"),
                        rs.getFloat("custo")));

            }
            return armazenamentos;
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public void atualizaArmazenamentoPorID(Armazenamento armazenamento, Armazenamento newArmazenamento){
        try{
            Statement st = conexao.createStatement();
            String query = String.format("UPDATE self_storage.armazenamentos SET armazenamentos.categoria = '%s', armazenamentos.endereco = '%s', armazenamentos.volume = '%s', armazenamentos.custo = '%s' WHERE armazenamentos.id = '%s';",
                    newArmazenamento.getCategoria(),
                    newArmazenamento.getEndereco(),
                    newArmazenamento.getVolume(),
                    newArmazenamento.getCusto(),
                    armazenamento.getId());
            st.executeUpdate(query);
            System.out.printf("Armazenamento do tipo %s atualizado com sucesso!", newArmazenamento.getCategoria());
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public Integer getArmazenamentoIdByName(String nomeArmazenamento){
        try{
            Statement st = conexao.createStatement();
            String query = String.format("SELECT id FROM self_storage.armazenamentos WHERE categoria='%s';", nomeArmazenamento);
            ResultSet rs = st.executeQuery(query);
            Integer id = null;
            if (rs.next()){
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Armazenamento getArmazenamentoByName(String nomeArmazenamento){
        try{
            Statement st = conexao.createStatement();
            String query = String.format("SELECT * FROM self_storage.armazenamentos WHERE categoria='%s';", nomeArmazenamento);
            ResultSet rs = st.executeQuery(query);
            Armazenamento armazenamento = new Armazenamento();

            if (rs.next()){
                armazenamento.setEndereco(rs.getString("endereco"));
                armazenamento.setCategoria(rs.getString("categoria"));
                armazenamento.setCusto(rs.getInt("custo"));
                armazenamento.setVolume(rs.getString("volume"));
            }
            return armazenamento;
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
