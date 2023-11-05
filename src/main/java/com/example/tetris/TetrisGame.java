package com.example.tetris;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;


public class TetrisGame extends Application {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    public static final int SHAPE_SIZE = 50; //size of single square, defines the size of the tetromino
    enum ShapeType {
        L, Square, J, T, I, S, Z
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris");
        Pane root = new Pane();
        Scene scene = new Scene(root, BOARD_WIDTH * 40, BOARD_HEIGHT * 40);
        scene.setFill(Color.DARKGRAY); // Set the background color


        Pane ShapePane = createRandomTetromino();
        ShapePane.relocate(100, 120); //setting the position
        root.getChildren().add(ShapePane); // adding to the scene

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createRandomTetromino() {
        Random random = new Random();
        ShapeType randomType = ShapeType.values()[random.nextInt(7)];

        Tetromino shape = null;

        switch (randomType) {
            case L -> shape = new TetrominoL();
            case Square -> shape = new TetrominoSquare();
            case J -> shape = new TetrominoJ();
            case T -> shape = new TetrominoT();
            case I -> shape = new TetrominoI();
            case S -> shape = new TetrominoS();
            case Z -> shape = new TetrominoZ();
        }
        if (shape != null) {
            return shape.createTetromino();
        } else {
            return new Pane();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
