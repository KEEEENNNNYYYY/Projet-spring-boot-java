package hei.school.kenny.todoliste.Models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskByID implements Serializable {
    private Connection connectToDb(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + dbname + "?sslmode=disable";
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Failed to connect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public String fetchTasks(int idToFind) {
        Connection conn = connectToDb("todolistjava", "postgres", "0000");
        String result = null;
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String query = "SELECT * FROM task WHERE id = "+ idToFind;
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    idToFind = rs.getInt("id");
                    String name = rs.getString("name");
                    String state = rs.getString("state");
                    result = (("ID: " + idToFind + " name : " + name + " state : " + state));
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
