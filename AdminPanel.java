package cinebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminPanel {

    private ObservableList<String> movieList =
            FXCollections.observableArrayList();

    private ListView<String> movieView = new ListView<>(movieList);

    public void showAdminDashboard() {

        Stage stage = new Stage();

        Label title = new Label("CINEBOOK ADMIN");
        title.setFont(Font.font("Arial", 30));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("Movie Management Dashboard");
        subtitle.setTextFill(Color.LIGHTGRAY);

        Button addButton = new Button("Add Movie");
        Button deleteButton = new Button("Delete Movie");
        Button refreshButton = new Button("View Movies");
        Button logoutButton = new Button("Logout");

        Button[] buttons = {
            addButton, deleteButton, refreshButton, logoutButton
        };

        for (Button button : buttons) {
            button.setPrefWidth(220);
            button.setPrefHeight(40);

            button.setStyle(
                "-fx-background-color: #8B5CF6;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-background-radius: 10;"
            );
        }

        movieView.setPrefHeight(250);

        addButton.setOnAction(e -> addMovie());

        deleteButton.setOnAction(e -> deleteMovie());

        refreshButton.setOnAction(e -> loadMovies());

        logoutButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(15);

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        layout.setStyle("-fx-background-color: #120B24;");

        layout.getChildren().addAll(
            title,
            subtitle,
            addButton,
            deleteButton,
            refreshButton,
            movieView,
            logoutButton
        );

        Scene scene = new Scene(layout, 600, 650);

        stage.setTitle("CineBook Admin Dashboard");
        stage.setScene(scene);

        loadMovies();

        stage.show();
    }

    // Add Movie

    private void addMovie() {

        TextField titleField = new TextField();
        titleField.setPromptText("Enter Movie Title");

        TextField genreField = new TextField();
        genreField.setPromptText("Enter Movie Genre");

        TextField durationField = new TextField();
        durationField.setPromptText("Duration in Minutes");

        VBox layout = new VBox(10);

        layout.getChildren().addAll(
            new Label("Movie Title"),
            titleField,
            new Label("Movie Genre"),
            genreField,
            new Label("Duration"),
            durationField
        );

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Add Movie");
        alert.setHeaderText("Enter Movie Details");
        alert.getDialogPane().setContent(layout);

        ButtonType saveButton =
                new ButtonType("Save Movie", ButtonBar.ButtonData.OK_DONE);

        alert.getButtonTypes().setAll(
                saveButton,
                ButtonType.CANCEL
        );

        alert.showAndWait().ifPresent(response -> {

            if (response == saveButton) {

                String title = titleField.getText().trim();
                String genre = genreField.getText().trim();

                if (title.isEmpty() || genre.isEmpty()
                        || durationField.getText().trim().isEmpty()) {

                    showMessage(
                        Alert.AlertType.WARNING,
                        "Please fill all movie details."
                    );

                    return;
                }

                try {

                    int duration = Integer.parseInt(
                            durationField.getText().trim()
                    );

                    if (duration <= 0) {
                        showMessage(
                            Alert.AlertType.WARNING,
                            "Duration must be greater than zero."
                        );
                        return;
                    }

                    Connection connection =
                            DatabaseConnection.getConnection();

                    String idQuery =
                            "SELECT COALESCE(MAX(movie_id), 0) + 1 FROM movies";

                    PreparedStatement idStatement =
                            connection.prepareStatement(idQuery);

                    ResultSet result = idStatement.executeQuery();

                    int movieId = 1;

                    if (result.next()) {
                        movieId = result.getInt(1);
                    }

                    String sql =
                            "INSERT INTO movies " +
                            "(movie_id, title, genre, duration_minutes) " +
                            "VALUES (?, ?, ?, ?)";

                    PreparedStatement statement =
                            connection.prepareStatement(sql);

                    statement.setInt(1, movieId);
                    statement.setString(2, title);
                    statement.setString(3, genre);
                    statement.setInt(4, duration);

                    statement.executeUpdate();

                    statement.close();
                    result.close();
                    idStatement.close();
                    connection.close();

                    showMessage(
                        Alert.AlertType.INFORMATION,
                        "Movie added successfully!"
                    );

                    loadMovies();

                } catch (NumberFormatException ex) {

                    showMessage(
                        Alert.AlertType.ERROR,
                        "Duration must be a valid number."
                    );

                } catch (Exception ex) {

                    ex.printStackTrace();

                    showMessage(
                        Alert.AlertType.ERROR,
                        "Unable to add movie. Check database connection."
                    );
                }
            }
        });
    }

    // Load Movies

    private void loadMovies() {

        movieList.clear();

        String sql =
                "SELECT movie_id, title, genre, duration_minutes FROM movies";

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                String movie =
                        "ID: " + result.getInt("movie_id") +
                        " | Title: " + result.getString("title") +
                        " | Genre: " + result.getString("genre") +
                        " | Duration: " +
                        result.getInt("duration_minutes") + " minutes";

                movieList.add(movie);
            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {

            ex.printStackTrace();

            showMessage(
                Alert.AlertType.ERROR,
                "Unable to load movies from database."
            );
        }
    }

    // Delete Movie

    private void deleteMovie() {

        String selectedMovie = movieView.getSelectionModel()
                .getSelectedItem();

        if (selectedMovie == null) {

            showMessage(
                Alert.AlertType.WARNING,
                "Please select a movie first."
            );

            return;
        }

        try {

            int movieId = Integer.parseInt(
                    selectedMovie.substring(
                        selectedMovie.indexOf("ID: ") + 4,
                        selectedMovie.indexOf(" |")
                    )
            );

            Alert confirmation =
                    new Alert(Alert.AlertType.CONFIRMATION);

            confirmation.setTitle("Delete Movie");

            confirmation.setHeaderText("Confirm Movie Deletion");

            confirmation.setContentText(
                    "Are you sure you want to delete this movie?"
            );

            confirmation.showAndWait().ifPresent(response -> {

                if (response == ButtonType.OK) {

                    try {

                        Connection connection =
                                DatabaseConnection.getConnection();

                        String sql =
                                "DELETE FROM movies WHERE movie_id = ?";

                        PreparedStatement statement =
                                connection.prepareStatement(sql);

                        statement.setInt(1, movieId);

                        statement.executeUpdate();

                        statement.close();
                        connection.close();

                        showMessage(
                            Alert.AlertType.INFORMATION,
                            "Movie deleted successfully!"
                        );

                        loadMovies();

                    } catch (Exception ex) {

                        ex.printStackTrace();

                        showMessage(
                            Alert.AlertType.ERROR,
                            "Movie cannot be deleted. It may be linked " +
                            "to existing shows."
                        );
                    }
                }
            });

        } catch (Exception ex) {

            showMessage(
                Alert.AlertType.ERROR,
                "Unable to identify selected movie."
            );
        }
    }

    // Display Messages

    private void showMessage(Alert.AlertType type, String message) {

        Alert alert = new Alert(type);

        alert.setTitle("CineBook");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}