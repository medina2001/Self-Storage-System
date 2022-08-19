package DAO;

import Infrastructure.Extensions.DateExtension;
import Models.Aluguel;
import Models.Armazenamento;
import Models.Cliente;
import ServiceLayer.DatabaseConnectionSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AluguelDAO {
    private final Connection conexao;

    public AluguelDAO() {
        this.conexao = DatabaseConnectionSetup.getConnection();
    }
    private Date dataInicio;
    private Date dataFim;
    private Integer seguro;
    private Integer chaveExtra;
    private Integer controleClimatico;
    private Integer clientId;
    private Integer armazenamentoId;

    public void criarAluguel(Aluguel aluguel) {
        DateExtension dateExtension = new DateExtension();
        try {
            Statement st = conexao.createStatement();
            String query = String.format("INSERT INTO self_storage.aluguel (dataInicio, dataFim, seguro, chaveExtra, controleClimatico, clienteId, armazenamentoId) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    dateExtension.dateToString(aluguel.getDataInicio()), dateExtension.dateToString(aluguel.getDataFim()), aluguel.getSeguro(), aluguel.getChaveExtra(), aluguel.getControleClimatico(), aluguel.getClientId(), aluguel.getArmazenamentoId()
            );
            st.executeUpdate(query);
            System.out.println("Aluguel realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public List<Armazenamento> getArmazenamentosDisponiveis() {
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM self_storage.armazenamentos a  WHERE NOT EXISTS (SELECT * FROM self_storage.aluguel a2 WHERE a.id  = a2.armazenamentoId);");

            List<Armazenamento> armazenamentos = new ArrayList<>();

            while (rs.next()){
                armazenamentos.add(new Armazenamento(rs.getInt("id"),
                        rs.getString("endereco"),
                        rs.getString("categoria"),
                        rs.getString("volume"),
                        rs.getFloat("custo")));

            }
            System.out.println(armazenamentos.size());
            return armazenamentos;
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
