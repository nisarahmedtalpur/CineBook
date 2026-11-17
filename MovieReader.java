package cinebook;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieReader {

    public static void main(String[] args) {

        String sql = "SELECT * FROM movies";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            System.out.println("================================");
            System.out.println("       CINEBOOK MOVIES");
            System.out.println("================================");

            while (result.next()) {

                int id = result.getInt("movie_id");
                String title = result.getString("title");
                String genre = result.getString("genre");
                int duration = result.getInt("duration_minutes");

                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Duration: " + duration + " minutes");
                System.out.println("--------------------------------");
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
