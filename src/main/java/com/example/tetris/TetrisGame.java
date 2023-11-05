package com.example.tetris;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;


public class TetrisGame extends Application {
    Pane root = new Pane();
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    public static final int SHAPE_SIZE = 50; //size of single square, defines the size of the tetromino
    enum ShapeType {
        L, Square, J, T, I, S, Z
    }
    private Tetromino currentTetromino; // Aktualne tetromino
    private Pane currentTetrominoPane; // Pane zawierające aktualne tetromino
    private int currentTetrominoX; // Aktualna pozycja X tetromino na planszy
    private int currentTetrominoY; // Aktualna pozycja Y tetromino na planszy



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris");

        Scene scene = new Scene(root, BOARD_WIDTH * 40, BOARD_HEIGHT * 40);
        scene.setFill(Color.DARKGRAY); // Set the background color

        spawnTetromino();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                // Obsługa naciśnięcia spacji - obróć tetromino
                if (currentTetromino != null) {
                    currentTetromino.rotate();
                    refreshTetrominoView();
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tetromino createRandomTetromino() {
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
        return shape;
    }

    public void spawnTetromino() {
        Tetromino randomTetromino = createRandomTetromino(); // Utwórz nowe losowe tetromino
        currentTetromino = randomTetromino; // Przypisz je jako aktualne tetromino
        currentTetrominoX = 200; // Ustaw pozycję początkową X
        currentTetrominoY = 0; // Ustaw pozycję początkową Y
        currentTetrominoPane = randomTetromino.createTetromino(); // Utwórz Pane dla nowego tetromino
        currentTetrominoPane.relocate(200,200); // Umieść na planszy
        root.getChildren().add(currentTetrominoPane); // Dodaj do sceny
    }


    private void refreshTetrominoView() {
        root.getChildren().remove(currentTetrominoPane); // Usuń aktualne tetromino
        currentTetrominoPane = currentTetromino.createTetromino(); // Utwórz nowe tetromino
        currentTetrominoPane.relocate(200,200);
        root.getChildren().add(currentTetrominoPane); // Dodaj nowe tetromino do sceny
    }
    public static void main(String[] args) {
        launch(args);
    }
}