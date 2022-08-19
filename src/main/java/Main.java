import Models.Armazenamento;
import Scenes.CadastroArmazenamento;
import Scenes.CadastroCliente;

public class Main {
    public static void main(String[] args) throws Exception {
        CadastroArmazenamento cadastroArmazenamento = new CadastroArmazenamento();
        cadastroArmazenamento.getFrame().setVisible(true);
//        CadastroCliente cadastroCliente = new CadastroCliente();
//        cadastroCliente.getFrame().setVisible(true);
    }
}
