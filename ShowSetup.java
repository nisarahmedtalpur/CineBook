package cinebook;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ShowSetup {

    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Cinema add
            String cinemaSQL =
                    "INSERT IGNORE INTO cinemas (cinema_id, name) VALUES (?, ?)";

            PreparedStatement cinema =
                    connection.prepareStatement(cinemaSQL);

            cinema.setInt(1, 1);
            cinema.setString(2, "CineBook Cinema");
            cinema.executeUpdate();

            // Screen add
            String screenSQL =
                    "INSERT IGNORE INTO screens " +
                    "(screen_id, cinema_id, total_seats) VALUES (?, ?, ?)";

            PreparedStatement screen =
                    connection.prepareStatement(screenSQL);

            screen.setInt(1, 1);
            screen.setInt(2, 1);
            screen.setInt(3, 5);
            screen.executeUpdate();

            // Shows add
            String showSQL =
                    "INSERT IGNORE INTO shows " +
                    "(show_id, movie_id, screen_id, show_date, show_time) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement show =
                    connection.prepareStatement(showSQL);

            // Avengers
            show.setInt(1, 1);
            show.setInt(2, 1);
            show.setInt(3, 1);
            show.setDate(4, java.sql.Date.valueOf("2026-09-10"));
            show.setTime(5, java.sql.Time.valueOf("18:00:00"));
            show.executeUpdate();

            // Game of Thrones
            show.setInt(1, 2);
            show.setInt(2, 2);
            show.setInt(3, 1);
            show.setDate(4, java.sql.Date.valueOf("2026-09-10"));
            show.setTime(5, java.sql.Time.valueOf("20:00:00"));
            show.executeUpdate();

            // The Odyssey
            show.setInt(1, 3);
            show.setInt(2, 3);
            show.setInt(3, 1);
            show.setDate(4, java.sql.Date.valueOf("2026-09-10"));
            show.setTime(5, java.sql.Time.valueOf("22:00:00"));
            show.executeUpdate();

            System.out.println("================================");
            System.out.println(" SHOW DATA ADDED SUCCESSFULLY!");
            System.out.println("================================");

            show.close();
            screen.close();
            cinema.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
