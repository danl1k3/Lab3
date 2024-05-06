package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawRectangle extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 800);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        Button redButton = createColorButton("Red", Color.RED, rectangle);
        Button greenButton = createColorButton("Green", Color.GREEN, rectangle);
        Button blueButton = createColorButton("Blue", Color.BLUE, rectangle);
        Button yellowButton = createColorButton("Yellow", Color.YELLOW, rectangle);
        Button orangeButton = createColorButton("Orange", Color.ORANGE, rectangle);
        Button purpleButton = createColorButton("Purple", Color.PURPLE, rectangle);

        HBox buttonBox = new HBox(redButton, greenButton, blueButton, yellowButton, orangeButton, purpleButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(10));

        HBox.setHgrow(redButton, Priority.ALWAYS);
        HBox.setHgrow(greenButton, Priority.ALWAYS);
        HBox.setHgrow(blueButton, Priority.ALWAYS);
        HBox.setHgrow(yellowButton, Priority.ALWAYS);
        HBox.setHgrow(orangeButton, Priority.ALWAYS);
        HBox.setHgrow(purpleButton, Priority.ALWAYS);

        redButton.setMaxWidth(Double.MAX_VALUE);
        greenButton.setMaxWidth(Double.MAX_VALUE);
        blueButton.setMaxWidth(Double.MAX_VALUE);
        yellowButton.setMaxWidth(Double.MAX_VALUE);
        orangeButton.setMaxWidth(Double.MAX_VALUE);
        purpleButton.setMaxWidth(Double.MAX_VALUE);

        borderPane.setBottom(buttonBox);
        borderPane.getChildren().add(rectangle);

        scene.setOnMousePressed(event -> {
            rectangle.setX(event.getX());
            rectangle.setY(event.getY());
        });

        scene.setOnMouseDragged(event -> {
            rectangle.setWidth(event.getX() - rectangle.getX());
            rectangle.setHeight(event.getY() - rectangle.getY());
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw Rectangle");
        primaryStage.show();
    }

    private Button createColorButton(String text, Color color, Rectangle rectangle) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: " + toHexString(color) + ";");
        button.setOnAction(event -> rectangle.setFill(color));
        return button;
    }

    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
