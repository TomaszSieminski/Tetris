package com.example.tetris;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class TetrominoL {
    int size = 50; //size of single square, defines the size of the tetromino
    int[][][] shapes; // Array storing the different states of the tetromino shape
    int currentShape; // Current shape index
    Image blockImage = new Image(Objects.requireNonNull(getClass().getResource("/L-Block.png")).toExternalForm());
    public TetrominoL(String imagePath) {
        this.blockImage = new Image(imagePath);
        // Initialisation of tetromino shapes
        shapes = new int[][][]{
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {1, 0, 0}
                },
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}
                },
                {
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}
                },

        };
        currentShape = 0; // Initially select the first state
    }
    public Pane createTetromino() {
        Pane tetromino = new Pane();

        ImageView[] blocks = new ImageView[4];
        for (int i = 0; i < 4; i++) {
            blocks[i] = new ImageView(blockImage);
            blocks[i].setFitWidth(size);
            blocks[i].setFitHeight(size);
        }
        int[][] shape = shapes[currentShape];
        int blockCount = 0; // Counter for added blocks
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] == 1) {
                    if (blockCount < 4) { // Ensure that you do not add more than 4 blocks
                        blocks[blockCount].relocate(x * size, y * size);
                        tetromino.getChildren().add(blocks[blockCount]);
                        blockCount++;
                    }
                }
            }
        }
        return tetromino;
    }

}

