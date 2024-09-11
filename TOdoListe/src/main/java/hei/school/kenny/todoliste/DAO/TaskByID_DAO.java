package hei.school.kenny.todoliste.DAO;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository

public class TaskByID_DAO implements Serializable {

    private Connection connectToDb() {
        String url = "jdbc:postgresql://localhost:5432/todolistjava?sslmode=disable";
        String user = "postgres";
        String password = "0000";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray fetchTaskByID(int idToFind) {
        Connection conn = connectToDb();
        JSONArray tasksArray = new JSONArray();
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM task WHERE id = "+ idToFind);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    JSONObject taskObject = new JSONObject();
                    taskObject.put("id", rs.getString("id"));
                    taskObject.put("name", rs.getString("name"));
                    taskObject.put("state", rs.getString("state"));
                    tasksArray.put(taskObject);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return tasksArray;
    }
}