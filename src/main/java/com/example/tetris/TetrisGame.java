package com.example.tetris;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Random;


public class TetrisGame extends Application {
    Pane root = new Pane();
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    enum ShapeType {
        L, Square, J, T, I, S, Z
    }
    private Tetromino currentTetromino;
    private Pane currentTetrominoPane;
    private int currentTetrominoX;
    private int currentTetrominoY;
    private final int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris");

        Scene scene = new Scene(root, BOARD_WIDTH * Tetromino.SIZE, BOARD_HEIGHT * Tetromino.SIZE);
        scene.setFill(Color.DARKGRAY); // Set the background color

        spawnTetromino();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT -> moveTetrominoLeft();
                case RIGHT -> moveTetrominoRight();
                case SPACE -> rotateTetromino();
            }

        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void spawnTetromino() {
        Tetromino randomTetromino = createRandomTetromino(); // Create a new random tetromino
        currentTetromino = randomTetromino; // Assign them as current tetromino
        currentTetrominoX = 0; // Set starting position X
        currentTetrominoY = 0; // Set starting position Y
        currentTetrominoPane = randomTetromino.createTetromino(); // Create a Pane for the new tetromino
        currentTetrominoPane.relocate(currentTetrominoX,currentTetrominoY); // Place on the board
        root.getChildren().add(currentTetrominoPane); // Add to the scene
    }
    private Tetromino createRandomTetromino() {
        Random random = new Random();
        ShapeType randomType = ShapeType.values()[random.nextInt(7)];
        //ShapeType randomType = ShapeType.Square;

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

    private void moveTetrominoLeft() {
        if (currentTetromino != null) {
            int newX = currentTetrominoX - Tetromino.SIZE;
            currentTetrominoPane.relocate(newX, currentTetrominoY);
            currentTetrominoX = newX;

        }
    }

    private void moveTetrominoRight() {
        if (currentTetromino != null) {
            int newX = currentTetrominoX + Tetromino.SIZE;
            currentTetrominoPane.relocate(newX, currentTetrominoY);
            currentTetrominoX = newX;

        }
    }

    private void rotateTetromino() {
        currentTetromino.rotate();
        refreshTetrominoView();
    }
    private void refreshTetrominoView() {
        root.getChildren().remove(currentTetrominoPane); // Remove current tetromino
        currentTetrominoPane = currentTetromino.createTetromino(); // Create a new tetromino
        currentTetrominoPane.relocate(currentTetrominoX,currentTetrominoY);
        root.getChildren().add(currentTetrominoPane); // Add to the scene
    }
    public static void main(String[] args) {
        launch(args);
    }
}