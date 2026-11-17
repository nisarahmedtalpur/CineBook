package cinebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cinebook";
        String user = "root";
        String password = "Myproject056";

        try {
            Connection connection =
                    DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            // Movies table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS movies (" +
                "movie_id INT PRIMARY KEY," +
                "title VARCHAR(100) NOT NULL," +
                "genre VARCHAR(50)," +
                "duration_minutes INT)"
            );

            // Customers table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS customers (" +
                "customer_id INT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(100))"
            );

            // Cinemas table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS cinemas (" +
                "cinema_id INT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL)"
            );

            // Screens table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS screens (" +
                "screen_id INT PRIMARY KEY," +
                "cinema_id INT," +
                "total_seats INT," +
                "FOREIGN KEY (cinema_id) REFERENCES cinemas(cinema_id))"
            );

            // Shows table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS shows (" +
                "show_id INT PRIMARY KEY," +
                "movie_id INT," +
                "screen_id INT," +
                "show_date DATE," +
                "show_time TIME," +
                "FOREIGN KEY (movie_id) REFERENCES movies(movie_id)," +
                "FOREIGN KEY (screen_id) REFERENCES screens(screen_id))"
            );

            // Bookings table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS bookings (" +
                "booking_id INT PRIMARY KEY," +
                "customer_id INT," +
                "show_id INT," +
                "seat_number INT," +
                "price DOUBLE," +
                "confirmed BOOLEAN," +
                "FOREIGN KEY (customer_id) REFERENCES customers(customer_id)," +
                "FOREIGN KEY (show_id) REFERENCES shows(show_id))"
            );

            // Payments table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS payments (" +
                "payment_id INT PRIMARY KEY," +
                "amount DOUBLE," +
                "payment_method VARCHAR(30)," +
                "successful BOOLEAN)"
            );

            // Tickets table
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS tickets (" +
                "ticket_id INT PRIMARY KEY," +
                "booking_id INT," +
                "payment_id INT," +
                "FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)," +
                "FOREIGN KEY (payment_id) REFERENCES payments(payment_id))"
            );

            System.out.println("======================================");
            System.out.println(" CINEBOOK DATABASE SETUP");
            System.out.println("======================================");
            System.out.println("All tables created successfully!");
            System.out.println("======================================");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
