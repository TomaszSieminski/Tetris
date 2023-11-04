package com.example.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class TetrisGame extends Application {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris Game");
        Pane root = new Pane();
        Scene scene = new Scene(root, BOARD_WIDTH * 40, BOARD_HEIGHT * 40);
        scene.setFill(Color.DARKGRAY); // Set the background color

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
