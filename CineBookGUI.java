package cinebook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CineBookGUI extends Application {

    // ================= COLORS =================
    private final String BG = "#120B24";
    private final String CARD = "#1D1233";
    private final String CARD2 = "#271744";
    private final String PURPLE = "#8B5CF6";
    private final String LIGHT_PURPLE = "#A78BFA";
    private final String WHITE = "#FFFFFF";
    private final String GRAY = "#C4BFD0";
    private final String GREEN = "#22C55E";

    private BorderPane root;

    @Override
    public void start(Stage stage) {

        root = new BorderPane();
        root.setStyle("-fx-background-color: " + BG + ";");

        showDashboard();

        Scene scene = new Scene(root, 1200, 720);

        stage.setTitle("CineBook - Movie Ticket Booking");
        stage.setScene(scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(650);
        stage.show();
    }

    // =========================================================
    // HEADER
    // =========================================================

    private HBox createHeader() {

        HBox header = new HBox(35);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(18, 35, 18, 35));

        Label logo = new Label("🎬 CineBook");
        logo.setTextFill(Color.web(WHITE));
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 27));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button home = navButton("Home");
        Button movies = navButton("Movies");
        Button booking = navButton("Book Ticket");
        Button tickets = navButton("My Tickets");
        Button exit = navButton("Exit");

        home.setOnAction(e -> showDashboard());
        movies.setOnAction(e -> showMovies());
        booking.setOnAction(e -> showBooking());
        tickets.setOnAction(e -> showMyTickets());

        exit.setOnAction(e -> {
            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION,
                    "Do you want to exit CineBook?"
            );

            alert.setTitle("Exit CineBook");
            alert.setHeaderText(null);

            alert.showAndWait().ifPresent(result -> {
                if (result == ButtonType.OK) {
                    System.exit(0);
                }
            });
        });

        header.getChildren().addAll(
                logo,
                spacer,
                home,
                movies,
                booking,
                tickets,
                exit
        );

        return header;
    }

    private Button navButton(String text) {

        Button button = new Button(text);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + GRAY + ";" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e ->
                button.setStyle(
                        "-fx-background-color: " + PURPLE + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
                )
        );

        button.setOnMouseExited(e ->
                button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: " + GRAY + ";" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        return button;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================
    
  
 

    private void showDashboard() {
    	 Button adminButton = new Button ("Admin Panel");
    	    
    	    adminButton.setOnAction(e -> {
    	    	AdminPanel admin = new AdminPanel();
    	    	admin.showAdminDashboard();
    	    	
    	    });


        VBox content = new VBox(30);
        content.setPadding(new Insets(55));
        content.setAlignment(Pos.CENTER_LEFT);

        Label small = new Label("WELCOME TO");
        small.setTextFill(Color.web(LIGHT_PURPLE));
        small.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        Label title = new Label("CineBook");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 58));

        Label subtitle = new Label(
                "Your cinematic journey starts here.\n" +
                "Discover movies, choose your seat and book your ticket."
        );

        subtitle.setTextFill(Color.web(GRAY));
        subtitle.setFont(Font.font("Arial", 18));

        Button explore = new Button("🎬  Explore Movies");
        styleMainButton(explore);

        Button book = new Button("🎟  Book Your Ticket");
        styleSecondaryButton(book);

        explore.setOnAction(e -> showMovies());
        book.setOnAction(e -> showBooking());

        HBox buttons = new HBox(15, explore, book, adminButton);
        
        adminButton.setStyle( 
       "-fx-background-color: #00f00" + " -fx-text-fill: black;" + "-fx-font-size: 18px;" + "-fx-font-weight: bold;" + "-fx-background-radius: 15;" + "-fx-padding: 15 25;");
        
      //  adminButton.setStyle("-fx-background-cilor:linear-gradient(to right, #f59e0B,#EF4444);" + "-fx-text-fill: white;" + "fx-font-weight: bold;" + "-fx-font-size: 14x;" + "-fxbackground=radius: 12 20;" + "-fx-padding: 12 20;" + "-fx-cursor: hand;");
        //Hower Effact
      adminButton.setOnMouseEntered(e ->{
       	adminButton.setStyle("-fx-background-color: #00f00;" + "-fx-text-fill: black;" + "-fx-font-weight: bold;" + "-fx-font-size: 18px;" + "-fx-background-radius: 15;" + "-fx-padding: 15 25;" + "-fx-cursor: hand;" );
       } );
        adminButton.setOnMouseExited(e ->{
        	adminButton.setStyle( "-fx-background-color: #00f00;" + "-fx-text-fill: black;" + "-fx-font-weight: bold;" + "-fx-background-radius: 15;" + "-fx-padding: 15 25;" + "-fx-cursor: hand;" );
        	
        	
       } );
        

        HBox features = new HBox(20);

        features.getChildren().addAll(
                featureCard("🎬", "Movies", "Explore available movies"),
                featureCard("💺", "Easy Booking", "Choose your favorite seat"),
                featureCard("🎟", "Digital Ticket", "Get instant confirmation")
        );

        content.getChildren().addAll(
                small,
                title,
                subtitle,
                buttons,
                features
        );

        root.setTop(createHeader());
        root.setCenter(content);

        playDashboardAnimation(content);
    }

    private VBox featureCard(String icon, String title, String desc) {

        VBox card = new VBox(8);
        card.setPadding(new Insets(20));
        card.setPrefSize(210, 120);

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #3B2860;" +
                "-fx-border-radius: 15;"
        );

        Label iconLabel = new Label(icon);
        iconLabel.setFont(Font.font(25));

        Label titleLabel = new Label(title);
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 17));

        Label descLabel = new Label(desc);
        descLabel.setTextFill(Color.web(GRAY));
        descLabel.setFont(Font.font(12));

        card.getChildren().addAll(
                iconLabel,
                titleLabel,
                descLabel
        );

        card.setOnMouseEntered(e -> {
            ScaleTransition scale =
                    new ScaleTransition(Duration.millis(180), card);
            scale.setToX(1.05);
            scale.setToY(1.05);
            scale.play();
        });

        card.setOnMouseExited(e -> {
            ScaleTransition scale =
                    new ScaleTransition(Duration.millis(180), card);
            scale.setToX(1);
            scale.setToY(1);
            scale.play();
        });

        return card;
    }

    private void playDashboardAnimation(VBox content) {

        content.setOpacity(0);
        content.setTranslateY(35);

        FadeTransition fade =
                new FadeTransition(Duration.millis(900), content);
        fade.setFromValue(0);
        fade.setToValue(1);

        TranslateTransition slide =
                new TranslateTransition(Duration.millis(900), content);
        slide.setFromY(35);
        slide.setToY(0);

        ParallelTransition animation =
                new ParallelTransition(fade, slide);

        animation.play();
    }

    // =========================================================
    // MOVIES
    // =========================================================

    private void showMovies() {

        VBox page = new VBox(25);
        page.setPadding(new Insets(40));

        Label title = new Label("Now Showing");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 34));

        Label subtitle = new Label(
                "Choose a movie and continue to booking."
        );
        subtitle.setTextFill(Color.web(GRAY));
        subtitle.setFont(Font.font(15));

        HBox movies = new HBox(25);

        movies.getChildren().addAll(
                movieCard(
                        "AVENGERS",
                        "Action • Adventure",
                        "Rs. 1200"
                ),
                movieCard(
                        "GAME OF THRONES",
                        "Drama • Fantasy",
                        "Rs. 1500"
                ),
                movieCard(
                        "THE ODYSSEY",
                        "Adventure • Epic",
                        "Rs. 1600"
                )
        );

        page.getChildren().addAll(
                title,
                subtitle,
                movies
        );

        root.setTop(createHeader());
        root.setCenter(page);

        playDashboardAnimation(page);
    }

    private VBox movieCard(
            String movie,
            String genre,
            String price
    ) {

        VBox card = new VBox(12);
        card.setPadding(new Insets(18));
        card.setPrefWidth(270);
        card.setPrefHeight(300);

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #3B2860;" +
                "-fx-border-radius: 18;"
        );

        StackPane poster = new StackPane();
        poster.setPrefHeight(150);

        Rectangle posterBackground =
                new Rectangle(230, 150);

        posterBackground.setArcWidth(20);
        posterBackground.setArcHeight(20);
        posterBackground.setFill(
                Color.web("#321957")
        );

        Label filmIcon = new Label("🎬");
        filmIcon.setFont(Font.font(48));

        poster.getChildren().addAll(
                posterBackground,
                filmIcon
        );

        Label name = new Label(movie);
        name.setTextFill(Color.WHITE);
        name.setFont(
                Font.font("Arial", FontWeight.BOLD, 19)
        );

        Label type = new Label(genre);
        type.setTextFill(Color.web(GRAY));

        Label amount = new Label(price);
        amount.setTextFill(Color.web(LIGHT_PURPLE));
        amount.setFont(
                Font.font("Arial", FontWeight.BOLD, 16)
        );

        Button book = new Button("Book Now");
        styleMainButton(book);

        book.setOnAction(e -> showBooking());

        card.getChildren().addAll(
                poster,
                name,
                type,
                amount,
                book
        );

        card.setOnMouseEntered(e -> {
            ScaleTransition st =
                    new ScaleTransition(
                            Duration.millis(200),
                            card
                    );

            st.setToX(1.04);
            st.setToY(1.04);
            st.play();
        });

        card.setOnMouseExited(e -> {
            ScaleTransition st =
                    new ScaleTransition(
                            Duration.millis(200),
                            card
                    );

            st.setToX(1);
            st.setToY(1);
            st.play();
        });

        return card;
    }

    // =========================================================
    // BOOKING
    // =========================================================

    private void showBooking() {

        VBox page = new VBox(22);
        page.setAlignment(Pos.TOP_CENTER);
        page.setPadding(new Insets(35));

        Label title = new Label("Book Your Ticket");
        title.setTextFill(Color.WHITE);
        title.setFont(
                Font.font("Arial", FontWeight.BOLD, 34)
        );

        VBox form = new VBox(16);
        form.setPadding(new Insets(30));
        form.setMaxWidth(520);

        form.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3B2860;" +
                "-fx-border-radius: 20;"
        );

        TextField customer =
                new TextField();

        customer.setPromptText("Enter customer name");
        styleInput(customer);

        ComboBox<String> movie =
                new ComboBox<>();

        movie.getItems().addAll(MovieDAO.getMovieTitles());
                

        movie.setPromptText("Select movie");
        movie.setMaxWidth(Double.MAX_VALUE);
        styleCombo(movie);

        ComboBox<String> seat =
                new ComboBox<>();

        seat.getItems().addAll(
                "A1",
                "A2",
                "A3",
                "A4",
                "A5"
        );

        seat.setPromptText("Select seat");
        seat.setMaxWidth(Double.MAX_VALUE);
        styleCombo(seat);

        ComboBox<String> payment =
                new ComboBox<>();

        payment.getItems().addAll(
                "CARD",
                "CASH",
                "ONLINE"
        );

        payment.setPromptText("Payment Method");
        payment.setMaxWidth(Double.MAX_VALUE);
        styleCombo(payment);

        Button confirm =
                new Button("✓  CONFIRM BOOKING");

        styleMainButton(confirm);

        confirm.setMaxWidth(Double.MAX_VALUE);

        confirm.setOnAction(e -> {

            if (customer.getText().isEmpty()
                    || movie.getValue() == null
                    || seat.getValue() == null
                    || payment.getValue() == null) {

                showError(
                        "Please complete all booking fields."
                );

                return;
            }

            showTicket(
                    customer.getText(),
                    movie.getValue(),
                    seat.getValue(),
                    payment.getValue()
            );
        });

        form.getChildren().addAll(
                createLabel("Customer Name"),
                customer,
                createLabel("Movie"),
                movie,
                createLabel("Seat"),
                seat,
                createLabel("Payment Method"),
                payment,
                confirm
        );

        page.getChildren().addAll(
                title,
                form
        );

        root.setTop(createHeader());
        root.setCenter(page);

        playDashboardAnimation(page);
    }

    private Label createLabel(String text) {

        Label label = new Label(text);

        label.setTextFill(Color.web(GRAY));
        label.setFont(
                Font.font("Arial", FontWeight.BOLD, 13)
        );

        return label;
    }

    private void styleInput(TextField field) {

        field.setStyle(
                "-fx-background-color: #120B24;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #777080;" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #3B2860;" +
                "-fx-border-radius: 8;" +
                "-fx-padding: 12;"
        );
    }

    private void styleCombo(ComboBox<String> combo) {

        combo.setStyle(
                "-fx-background-color: #120B24;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #3B2860;" +
                "-fx-border-radius: 8;"
        );
    }

    // =========================================================
    // TICKET CONFIRMATION
    // =========================================================

    private void showTicket(
            String customer,
            String movie,
            String seat,
            String payment
    ) {

        StackPane page = new StackPane();
        page.setPadding(new Insets(30));

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);

        Label confirmed = new Label(
                "✓  BOOKING CONFIRMED"
        );

        confirmed.setTextFill(Color.web(GREEN));
        confirmed.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        22
                )
        );

        VBox ticket = createAnimatedTicket(
                customer,
                movie,
                seat,
                payment
        );

        Button newBooking =
                new Button("Book Another Ticket");

        styleSecondaryButton(newBooking);

        newBooking.setOnAction(
                e -> showBooking()
        );

        container.getChildren().addAll(
                confirmed,
                ticket,
                newBooking
        );

        page.getChildren().add(container);

        root.setTop(createHeader());
        root.setCenter(page);

        playTicketAnimation(
                container,
                ticket,
                confirmed
        );
    }

    // =========================================================
    // ANIMATED MOVIE TICKET
    // =========================================================

    private VBox createAnimatedTicket(
            String customer,
            String movie,
            String seat,
            String payment
    ) {

        VBox ticket = new VBox();

        ticket.setPrefWidth(760);
        ticket.setMaxWidth(760);

        ticket.setStyle(
                "-fx-background-color: #09070F;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #8B5CF6;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 22;"
        );

        DropShadow shadow = new DropShadow();
        shadow.setRadius(25);
        shadow.setColor(
                Color.rgb(139, 92, 246, 0.35)
        );

        ticket.setEffect(shadow);

        HBox main = new HBox();

        // ---------------- LEFT MOVIE AREA ----------------

        StackPane poster = new StackPane();

        Rectangle posterBox =
                new Rectangle(250, 230);

        posterBox.setFill(
                Color.web("#321957")
        );

        posterBox.setArcWidth(22);
        posterBox.setArcHeight(22);

        Label movieIcon =
                new Label("🎬");

        movieIcon.setFont(
                Font.font(65)
        );

        poster.getChildren().addAll(
                posterBox,
                movieIcon
        );

        // ---------------- RIGHT INFO ----------------

        VBox details = new VBox(12);

        details.setPadding(
                new Insets(22, 25, 22, 25)
        );

        HBox.setHgrow(details, Priority.ALWAYS);

        Label cinema =
                new Label("CINEBOOK");

        cinema.setTextFill(
                Color.web(LIGHT_PURPLE)
        );

        cinema.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        Label movieName =
                new Label(movie.toUpperCase());

        movieName.setTextFill(Color.WHITE);

        movieName.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        30
                )
        );

        Label premium =
                new Label(
                        "PREMIUM CINEMATIC EXPERIENCE"
                );

        premium.setTextFill(
                Color.web(GRAY)
        );

        premium.setFont(
                Font.font(11)
        );

        HBox infoRow1 = new HBox(35);

        infoRow1.getChildren().addAll(
                ticketInfo("DATE", "08 SEP 2026"),
                ticketInfo("TIME", "20:30"),
                ticketInfo("SEAT", seat)
        );

        HBox infoRow2 = new HBox(35);

        infoRow2.getChildren().addAll(
                ticketInfo("CUSTOMER", customer),
                ticketInfo("PAYMENT", payment)
        );

        Label amount =
                new Label("TOTAL  Rs. 1,200");

        amount.setTextFill(
                Color.web(LIGHT_PURPLE)
        );

        amount.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        18
                )
        );

        HBox barcode = createBarcode();

        details.getChildren().addAll(
                cinema,
                movieName,
                premium,
                infoRow1,
                infoRow2,
                amount,
                barcode
        );

        main.getChildren().addAll(
                poster,
                details
        );

        // Ticket cut-out circles
        Circle leftCut =
                new Circle(13, Color.web(BG));

        Circle rightCut =
                new Circle(13, Color.web(BG));

        StackPane ticketWrapper =
                new StackPane(main);

        StackPane.setAlignment(
                leftCut,
                Pos.CENTER_LEFT
        );

        StackPane.setAlignment(
                rightCut,
                Pos.CENTER_RIGHT
        );

        ticketWrapper.getChildren().addAll(
                leftCut,
                rightCut
        );

        ticket.getChildren().add(ticketWrapper);

        return ticket;
    }

    private VBox ticketInfo(
            String title,
            String value
    ) {

        VBox box = new VBox(3);

        Label t = new Label(title);
        t.setTextFill(
                Color.web("#777080")
        );

        t.setFont(Font.font(10));

        Label v = new Label(value);

        v.setTextFill(Color.WHITE);

        v.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        14
                )
        );

        box.getChildren().addAll(t, v);

        return box;
    }

    private HBox createBarcode() {

        HBox barcode = new HBox(3);

        barcode.setAlignment(
                Pos.CENTER_LEFT
        );

        int[] bars = {
                3, 1, 2, 4, 1, 3, 2, 1,
                4, 2, 1, 3, 1, 2, 4, 1,
                3, 2, 1, 4, 2, 3
        };

        for (int width : bars) {

            Rectangle bar =
                    new Rectangle(
                            width * 2,
                            32
                    );

            bar.setFill(Color.WHITE);

            barcode.getChildren().add(bar);
        }

        return barcode;
    }

    // =========================================================
    // TICKET ANIMATION
    // =========================================================

    private void playTicketAnimation(
            VBox container,
            VBox ticket,
            Label confirmed
    ) {

        container.setOpacity(0);

        ticket.setOpacity(0);
        ticket.setRotate(70);

        RotateTransition rotate =
                new RotateTransition(
                        Duration.millis(1400),
                        ticket
                );

        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setFromAngle(70);
        rotate.setToAngle(0);

        rotate.setInterpolator(
                Interpolator.EASE_BOTH
        );

        FadeTransition fadeTicket =
                new FadeTransition(
                        Duration.millis(700),
                        ticket
                );

        fadeTicket.setFromValue(0);
        fadeTicket.setToValue(1);

        FadeTransition fadeContainer =
                new FadeTransition(
                        Duration.millis(500),
                        container
                );

        fadeContainer.setFromValue(0);
        fadeContainer.setToValue(1);

        ParallelTransition ticketAnimation =
                new ParallelTransition(
                        fadeContainer,
                        fadeTicket,
                        rotate
                );

        ticketAnimation.setOnFinished(e -> {

            ScaleTransition pulse =
                    new ScaleTransition(
                            Duration.millis(500),
                            confirmed
                    );

            pulse.setFromX(0.8);
            pulse.setFromY(0.8);
            pulse.setToX(1.0);
            pulse.setToY(1.0);

            pulse.play();
        });

        ticketAnimation.play();
    }

    // =========================================================
    // MY TICKETS
    // =========================================================

    private void showMyTickets() {

        VBox page = new VBox(25);

        page.setPadding(
                new Insets(45)
        );

        Label title =
                new Label("My Tickets");

        title.setTextFill(Color.WHITE);

        title.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        34
                )
        );

        Label message =
                new Label(
                        "Your confirmed movie tickets will appear here."
                );

        message.setTextFill(
                Color.web(GRAY)
        );

        VBox empty =
                new VBox(15);

        empty.setAlignment(
                Pos.CENTER
        );

        empty.setPadding(
                new Insets(70)
        );

        Label icon =
                new Label("🎟");

        icon.setFont(
                Font.font(55)
        );

        Label text =
                new Label(
                        "No saved tickets yet"
                );

        text.setTextFill(Color.WHITE);

        text.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        20
                )
        );

        Button book =
                new Button("Book a Ticket");

        styleMainButton(book);

        book.setOnAction(
                e -> showBooking()
        );

        empty.getChildren().addAll(
                icon,
                text,
                book
        );

        page.getChildren().addAll(
                title,
                message,
                empty
        );

        root.setTop(createHeader());
        root.setCenter(page);

        playDashboardAnimation(page);
    }

    // =========================================================
    // BUTTON STYLES
    // =========================================================

    private void styleMainButton(Button button) {

        button.setStyle(
                "-fx-background-color: " + PURPLE + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 12 20;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(150),
                            button
                    );

            scale.setToX(1.05);
            scale.setToY(1.05);

            scale.play();
        });

        button.setOnMouseExited(e -> {

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(150),
                            button
                    );

            scale.setToX(1);
            scale.setToY(1);

            scale.play();
        });
    }

    private void styleSecondaryButton(Button button) {

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-border-color: " + PURPLE + ";" +
                "-fx-border-width: 1.5;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 11 20;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // ERROR
    // =========================================================

    private void showError(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.WARNING
                );

        alert.setTitle("CineBook");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    // =========================================================
    // MAIN
    // =========================================================
    
    public static void main(String[] args) {   
        launch(args);
    }
}