package cinebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieDAO {

    // SQL se movies read karne ka method
    public static ArrayList<String> getMovieTitles() {

        ArrayList<String> movies = new ArrayList<>();

        String sql = "SELECT title FROM movies";

        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                movies.add(result.getString("title"));
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }


    // Testing ke liye
    public static void main(String[] args) {

        ArrayList<String> movies = getMovieTitles();

        System.out.println("================================");
        System.out.println(" MOVIES FROM DATABASE");
        System.out.println("================================");

        for (String movie : movies) {
            System.out.println(movie);
        }
    }
}