package com.example.login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Credentials credentials;
    private GridPane gridPane;  // Declare GridPane as a member variable

    public HelloApplication() throws IOException {
        credentials = new Credentials();
    }

    @Override
    public void start(Stage stage) throws IOException {

        // Setup the GridPane and layout
        gridPane = new GridPane();  // Initialize the GridPane here

        Image bannerImage = new Image("login.png");
        ImageView imageView = new ImageView(bannerImage);

        Label usernameLabel = new Label("Username: ");
        usernameLabel.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 16px;");

        TextField usernameTextfield = new TextField();
        usernameTextfield.setPromptText("Username");

        HBox usernameHBox = new HBox();
        usernameHBox.getChildren().addAll(usernameLabel, usernameTextfield);
        usernameHBox.setPadding(new Insets(10));
        usernameHBox.setSpacing(10);

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setStyle("-fx-text-fill: black;-fx-font-size: 16px;-fx-font-weight: bold;");

        TextField passwordTextfield = new TextField();
        passwordTextfield.setPromptText("Password");

        HBox passwordHBox = new HBox();
        passwordHBox.getChildren().addAll(passwordLabel, passwordTextfield);
        passwordHBox.setPadding(new Insets(10));
        passwordHBox.setSpacing(10);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(usernameTextfield.getText(), passwordTextfield.getText(), stage));

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> System.exit(0));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(loginButton, exitButton);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);


        gridPane.add(imageView, 0, 0);
        gridPane.add(usernameHBox, 0, 1);
        gridPane.add(passwordHBox, 0, 2);
        gridPane.add(hBox, 0, 3);

        Scene scene = new Scene(gridPane, 360, 600);
        stage.setTitle("Login form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void handleLogin(String username, String password, Stage stage) {
        Label statusLabel = new Label();
        if (credentials.checkUserCredentials(username, password)) {
            Stage newStage = new Stage();
            newStage.setScene(new Scene(new Label("Welcome, " + username), 300, 150));
            newStage.setTitle("Welcome");
            newStage.show();
        } else {
            statusLabel.setText("Account not found. Please check your credentials.");
            gridPane.add(statusLabel, 0, 4);
        }
    }
}
