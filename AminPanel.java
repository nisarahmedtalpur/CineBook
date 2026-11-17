

package cinebook;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AminPanel {

    public void showAdminDashboard() {

        Stage stage = new Stage();

        Label title = new Label("CINEBOOK ADMIN");
        title.setFont(Font.font("Arial", 30));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("Movie Management Dashboard");
        subtitle.setTextFill(Color.LIGHTGRAY);

        Button addMovieButton = new Button("Add Movie");
        Button deleteMovieButton = new Button("Delete Movie");
        Button viewMoviesButton = new Button("View Movies");
        Button logoutButton = new Button("Logout");

        Button[] buttons = {
            addMovieButton,
            deleteMovieButton,
            viewMoviesButton,
            logoutButton
        };

        for (Button button : buttons) {
            button.setPrefWidth(250);
            button.setPrefHeight(45);
            button.setStyle(
                "-fx-background-color: #8B5CF6;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-background-radius: 10;"
            );
        }

        addMovieButton.setOnAction(e ->
            System.out.println("Add Movie selected"));

        deleteMovieButton.setOnAction(e ->
            System.out.println("Delete Movie selected"));

        viewMoviesButton.setOnAction(e ->
            System.out.println("View Movies selected"));

        logoutButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        layout.setStyle("-fx-background-color: #120B24;");

        layout.getChildren().addAll(
            title,
            subtitle,
            addMovieButton,
            deleteMovieButton,
            viewMoviesButton,
            logoutButton
        );

        Scene scene = new Scene(layout, 600, 500);

        stage.setTitle("CineBook Admin Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}



