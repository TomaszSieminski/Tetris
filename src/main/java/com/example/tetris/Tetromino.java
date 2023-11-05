package com.example.tetris;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Tetromino {
    public static final int SIZE = 50; //size of single square, defines the size of the tetromino
    int[][][] shapes; // Array storing the different states of the tetromino shape
    int currentShape; // Current shape index
    Image blockImage;
    public Tetromino() {
        // Initialisation of tetromino shapes
        shapes = new int[][][]{
        };
        currentShape = 0; // Initially select the first state
    }
    public Pane createTetromino() {
        Pane tetromino = new Pane();

        ImageView[] blocks = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            blocks[i] = new ImageView(blockImage);
            blocks[i].setFitWidth(SIZE);
            blocks[i].setFitHeight(SIZE);
        }
        int[][] shape = shapes[currentShape];
        int blockCount = 0; // Counter for added blocks
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] == 1) {
                    if (blockCount < 4) { // Ensure that you do not add more than 4 blocks
                        blocks[blockCount].relocate(x * SIZE, y * SIZE);
                        tetromino.getChildren().add(blocks[blockCount]);
                        blockCount++;
                    }
                }
            }
        }
        return tetromino;
    }
    public int[][] getShape() {
        return shapes[currentShape];
    }
    public void rotate() {
        int[][] currentShape = shapes[this.currentShape]; // Bieżący kształt
        currentShape = rotateMatrix(currentShape); // Obróć kształt

        // Przejdź do następnego kształtu lub wróć do pierwszego
        this.currentShape = (this.currentShape + 1) % shapes.length;
    }
    private int[][] rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] rotatedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedMatrix[i][j] = matrix[size - j - 1][i];
            }
        }

        return rotatedMatrix;
    }
}

