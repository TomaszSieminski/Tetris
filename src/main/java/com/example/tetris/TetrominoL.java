package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoL extends Tetromino {
    int size = 50; //size of single square, defines the size of the tetromino
    int[][][] shapes; // Array storing the different states of the tetromino shape
    int currentShape; // Current shape index

    public TetrominoL() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/L-Block.png")).toExternalForm());
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

}

