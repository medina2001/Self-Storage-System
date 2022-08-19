import DAO.ClienteDAO;
import Models.Cliente;
import Scenes.Cadastro;
import com.mysql.cj.xdevapi.Client;

public class Main {
    public static void main(String[] args) throws Exception {
        Cadastro cadastro = new Cadastro();
        cadastro.getFrame().setVisible(true);
    }
}
