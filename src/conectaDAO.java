
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Adm
 */
public class conectaDAO {
 
    public static Connection getConnection() throws Exception{
        String url ="jdbc:mysql://localhost:3306/uc11";
        String user = "java";
        String senha = "senha123";
       
        return DriverManager.getConnection(url,user,senha);
    }
    
    
}
