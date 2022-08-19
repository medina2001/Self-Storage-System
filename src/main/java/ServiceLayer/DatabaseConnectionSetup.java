package ServiceLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSetup {
    private static final String url = "jdbc:mysql://localhost:3306/self_storage";
    private static final String cliente ="root";
    private static final String password="";
    protected static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null){
            connect();
        }
        return connection;
    }

    public static void disconnect(){
        try{
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void connect(){
        try{
            connection = DriverManager.getConnection(url, cliente,password);
            System.out.println("Conectado ao Banco de Dados");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}