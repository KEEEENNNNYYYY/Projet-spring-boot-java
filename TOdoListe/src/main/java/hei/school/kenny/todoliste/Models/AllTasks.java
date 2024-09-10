package hei.school.kenny.todoliste.Models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllTasks implements Serializable {

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

    public String fetchTasks() {
        Connection conn = connectToDb("todolistjava", "postgres", "0000");

        JSONArray tasksArray = new JSONArray();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String query = "SELECT * FROM task";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    JSONObject taskObject = new JSONObject();
                    taskObject.put("id", rs.getString("id"));
                    taskObject.put("name", rs.getString("name"));
                    taskObject.put("state", rs.getString("state"));
                    tasksArray.put(taskObject);
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tasksArray.toString(2);
    }
}
