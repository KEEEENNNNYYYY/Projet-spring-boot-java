package hei.school.kenny.todoliste;

import java.sql.Connection;
import java.sql.DriverManager;

public class Todo {
    public Object connec_to_db(String dbname,String user,String pass){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432");

            if (conn != null){
                System.out.println("Connected");
            }
            else{
                return ("failed");

            }
        }
        catch (Exception e){
            return (Connection)e;
        }
        return dbname;
    }
}
