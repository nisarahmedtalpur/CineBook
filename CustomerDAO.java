package cinebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    // Customer ko database mein save karne ka method
    public static int saveCustomer(String name, String email) {

        try {
            Connection connection = DatabaseConnection.getConnection();

            // Pehle check karo customer already database mein hai ya nahi
            String checkSQL =
                    "SELECT customer_id FROM customers WHERE name = ? LIMIT 1";

            PreparedStatement check =
                    connection.prepareStatement(checkSQL);

            check.setString(1, name);

            ResultSet result = check.executeQuery();

            // Agar customer already exist karta hai
            if (result.next()) {

                int existingId = result.getInt("customer_id");

                result.close();
                check.close();
                connection.close();

                return existingId;
            }

            result.close();
            check.close();

            // New customer ke liye next ID
            String idSQL =
                    "SELECT COALESCE(MAX(customer_id), 100) + 1 AS next_id " +
                    "FROM customers";

            PreparedStatement idStatement =
                    connection.prepareStatement(idSQL);

            ResultSet idResult = idStatement.executeQuery();

            int customerId = 101;

            if (idResult.next()) {
                customerId = idResult.getInt("next_id");
            }

            idResult.close();
            idStatement.close();

            // Customer insert karo
            String insertSQL =
                    "INSERT INTO customers " +
                    "(customer_id, name, email) VALUES (?, ?, ?)";

            PreparedStatement insert =
                    connection.prepareStatement(insertSQL);

            insert.setInt(1, customerId);
            insert.setString(2, name);
            insert.setString(3, email);

            insert.executeUpdate();

            insert.close();
            connection.close();

            System.out.println("Customer Saved Successfully!");
            System.out.println("Customer ID: " + customerId);

            return customerId;

        } catch (Exception e) {

            System.out.println("Customer Save Failed!");
            e.printStackTrace();

            return -1;
        }
    }


    // Testing ke liye
    public static void main(String[] args) {

        int customerId =
                saveCustomer("Ali", "ali@gmail.com");

        System.out.println("================================");
        System.out.println(" CUSTOMER TEST");
        System.out.println("================================");
        System.out.println("Customer ID: " + customerId);
    }
}
