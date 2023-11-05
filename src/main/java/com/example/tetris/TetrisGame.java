package com.example.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.Scanner;

public class TetrisGame extends Application {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris Game");
        Pane root = new Pane();
        Scene scene = new Scene(root, BOARD_WIDTH * 40, BOARD_HEIGHT * 40);
        scene.setFill(Color.DARKGRAY); // Set the background color

        Pane lShapePane = getPane();

        // Ustaw pozycję kształtu "L" na planszy (dostosuj do swoich potrzeb)
        lShapePane.relocate(100, 120);

        // Dodaj kształt "L" do sceny
        root.getChildren().add(lShapePane);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane getPane() {
        Random random = new Random();
        int randomType = random.nextInt(7) + 1; // Losuj od 1 do 7
        Pane ShapePane = null;
        switch (randomType) {
            case 1 -> {
                TetrominoL Shape = new TetrominoL("/L-Block.png");
                ShapePane = Shape.createTetromino();
            }
            case 2 -> {
                TetrominoSquare Shape = new TetrominoSquare();
                ShapePane = Shape.createTetromino();
            }
            case 3 -> {
                TetrominoJ Shape = new TetrominoJ();
                ShapePane = Shape.createTetromino();
            }
            case 4 -> {
                TetrominoT Shape = new TetrominoT();
                ShapePane = Shape.createTetromino();
            }
            case 5 -> {
                TetrominoI Shape = new TetrominoI();
                ShapePane = Shape.createTetromino();
            }
            case 6 -> {
                TetrominoS Shape = new TetrominoS();
                ShapePane = Shape.createTetromino();
            }
            case 7 -> {
                TetrominoZ Shape = new TetrominoZ();
                ShapePane = Shape.createTetromino();
            }
        }
        return ShapePane;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
