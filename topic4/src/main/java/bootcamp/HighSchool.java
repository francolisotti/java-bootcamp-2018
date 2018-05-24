package bootcamp;

import java.sql.*;

public class HighSchool {

    private static HighSchool instance;
    private Connection connection;

    public static HighSchool getInstance() {
        if (instance == null) {
            instance = new HighSchool();
        }
        return instance;
    }

    private HighSchool() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/highschool", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timelineByTeacher(int id) {

        try {
            String query = "call teacher_timeline(?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
