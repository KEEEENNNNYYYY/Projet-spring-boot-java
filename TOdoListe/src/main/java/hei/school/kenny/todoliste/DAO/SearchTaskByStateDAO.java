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
public class SearchTaskByStateDAO implements Serializable {

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

    public JSONArray fetchTaskByState(String stateToFind) {
        Connection conn = connectToDb();
        JSONArray tasksArray = new JSONArray();
        if (conn != null) {
            try {

                String sql = "SELECT * FROM task WHERE state LIKE ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, "%" + stateToFind + "%");

                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            System.out.println(rs.getInt("id"));
                            JSONObject taskObject = new JSONObject();
                            taskObject.put("id", rs.getInt("id"));
                            taskObject.put("name", rs.getString("name"));
                            taskObject.put("state", rs.getString("state"));
                            tasksArray.put(taskObject);
                        }
                    }
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
