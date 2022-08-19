package DAO;

import Infrastructure.Extensions.DateExtension;
import Models.Aluguel;
import Models.Armazenamento;
import ServiceLayer.DatabaseConnectionSetup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
        try{
            Statement st = conexao.createStatement();
            String query = String.format("INSERT INTO self_storage.aluguel (dataInicio, dataFim, seguro, chaveExtra, controleClimatico, clienteId, armazenamentoId) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    dateExtension.dateToString(aluguel.getDataInicio()), dateExtension.dateToString(aluguel.getDataFim()), aluguel.getSeguro(), aluguel.getChaveExtra(), aluguel.getControleClimatico(), aluguel.getClientId(), aluguel.getArmazenamentoId()
            );
            st.executeUpdate(query);
            System.out.println("Aluguel realizado com sucesso!");
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
