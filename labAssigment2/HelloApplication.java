package com.example.dataentryform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Image banner = new Image(getClass().getResource("/banner.png").toExternalForm());
        ImageView imageView = new ImageView(banner);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10); 
        gridPane.setHgap(10);


        Label namelabel = new Label("Name");
        namelabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: black;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        Label fathernamelabel = new Label("Father's Name");
        fathernamelabel.setStyle("-fx-font-size: 14px;-fx-text-fill: black;-fx-font-weight: bold;");
        TextField fathernameField = new TextField();
        fathernameField.setPromptText("Enter Father's Name");

        Label cnicLabel = new Label("CNIC Number");
        cnicLabel.setStyle("-fx-font-size: 14px;-fx-text-fill: black;-fx-font-weight: bold;");
        TextField cnicField = new TextField();
        cnicField.setPromptText("Enter CNIC Number");

        Label datepickerlabel = new Label("Date of Birth");
        datepickerlabel.setStyle("-fx-font-size: 14px;-fx-text-fill: black;-fx-font-weight: bold;");
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Enter Date of Birth");

        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        ToggleGroup group = new ToggleGroup();
        maleRadioButton.setToggleGroup(group);
        femaleRadioButton.setToggleGroup(group);
        HBox hBox =new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(maleRadioButton,femaleRadioButton);

        Label genderlabel = new Label("Gender");
        genderlabel.setStyle("-fx-font-size: 14px;-fx-text-fill: black;-fx-font-weight: bold;");


        Label citylabel = new Label("City");
        citylabel.setStyle("-fx-font-size: 14px;-fx-text-fill: black;-fx-font-weight: bold;");
        ComboBox <String>cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore" ,"Islamabad","Wah");
        cityComboBox.setPromptText("Select City");



        ImageView selectedImageView = new ImageView();
        selectedImageView.setFitWidth(80);
        selectedImageView.setFitHeight(80);


        Button filechooserbutton = new Button("Choose File");
        filechooserbutton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                Image selectedImage = new Image("file:" + file.getAbsolutePath());
                selectedImageView.setImage(selectedImage);
            }
        });

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {

            String name = nameField.getText();
            String fatherName = fathernameField.getText();
            String cnic = cnicField.getText();
            String dateOfBirth = datePicker.getValue() != null ? datePicker.getValue().toString() : "Not Selected";
            String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "Not Selected";
            String city = cityComboBox.getValue() != null ? cityComboBox.getValue() : "Not Selected";
            System.out.println("Name: " + name);
            System.out.println("Father's Name: " + fatherName);
            System.out.println("CNIC: " + cnic);
            System.out.println("Date of Birth: " + dateOfBirth);
            System.out.println("Gender: " + gender);
            System.out.println("City: " + city);
            if (selectedImageView.getImage() != null) {
                System.out.println("Selected Image Path: " + selectedImageView.getImage().getUrl());
                System.out.println("");
            } else {
                System.out.println("No image selected.");
                System.out.println("");
            }
        });




        gridPane.add(imageView, 0, 0, 2, 1);
        gridPane.add(namelabel, 0, 1);
        gridPane.add(nameField, 1, 1);
        gridPane.add(fathernamelabel, 0, 2);
        gridPane.add(fathernameField, 1, 2);
        gridPane.add(cnicLabel, 0, 3);
        gridPane.add(cnicField, 1, 3);
        gridPane.add(datepickerlabel, 0, 4);
        gridPane.add(datePicker, 1, 4);
        gridPane.add(genderlabel, 0, 5);
        gridPane.add(hBox, 1, 5);
        gridPane.add(citylabel, 0, 6);
        gridPane.add(cityComboBox, 1, 6);
        gridPane.add(filechooserbutton, 0, 8);
        gridPane.add(selectedImageView, 1, 8);
        gridPane.add(saveButton, 0, 9);


        // Create scene and stage
        Scene scene = new Scene(gridPane, 565, 600);
        stage.setScene(scene);

        // Add icon to the stage
        Image icon = new Image(getClass().getResource("/comsats.png").toExternalForm());
        stage.getIcons().add(icon);

        // Set window properties
        stage.setTitle("Comsats Data Entry Form");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
