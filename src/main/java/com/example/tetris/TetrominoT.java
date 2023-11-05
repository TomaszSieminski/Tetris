package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoT extends Tetromino {
    public TetrominoT() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/T-Block.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {0, 1, 0},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {0, 1, 0},
                        {1, 1, 0},
                        {0, 1, 0}
                },
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {0, 1, 0}
                },
                {
                        {0, 1, 0},
                        {0, 1, 1},
                        {0, 1, 0}
                },

        };
    }
}