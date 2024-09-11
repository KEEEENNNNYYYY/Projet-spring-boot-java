package hei.school.kenny.todoliste.DAO;

import org.json.JSONArray;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class AddTaskDAO  implements Serializable {

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

    public String addTask(int idToAdd, String nameToAdd, String stateToAdd) {
        Connection conn = connectToDb();
        if (conn != null) {
            String query = "INSERT INTO task (id, name, state) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, idToAdd);
                pstmt.setString(2, nameToAdd);
                pstmt.setString(3, stateToAdd);

                pstmt.executeUpdate();

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
        return "";
    }
}
