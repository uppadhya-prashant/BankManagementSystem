package bank;
import java.sql.*;
public class ConnectionSQL {
    public Connection c;
    public Statement s;
    public ConnectionSQL(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","cheapthrills");
            s=c.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
