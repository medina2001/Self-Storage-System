import DAO.AluguelDAO;
import Infrastructure.Extensions.DateExtension;
import Models.Aluguel;
import Models.Armazenamento;
import Scenes.CadastroArmazenamento;
import Scenes.CadastroCliente;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Aluguel aluguel = new Aluguel();
        DateExtension dateExtension = new DateExtension();

        aluguel.setDataInicio(dateExtension.stringToDate("2022-08-19"));
        aluguel.setDataFim(dateExtension.stringToDate("2022-08-22"));
        aluguel.setSeguro(1);
        aluguel.setChaveExtra(1);
        aluguel.setControleClimatico(1);
        aluguel.setClientId(1);
        aluguel.setArmazenamentoId(1);

        AluguelDAO aluguelDAO = new AluguelDAO();
        aluguelDAO.criarAluguel(aluguel);
//        CadastroArmazenamento cadastroArmazenamento = new CadastroArmazenamento();
//        cadastroArmazenamento.getFrame().setVisible(true);
//        CadastroCliente cadastroCliente = new CadastroCliente();
//        cadastroCliente.getFrame().setVisible(true);
    }
}
