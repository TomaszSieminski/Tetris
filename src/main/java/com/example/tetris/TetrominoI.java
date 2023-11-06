package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoI extends Tetromino {
    public TetrominoI() {
        shapeSize = 4;
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/I-Block.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {0, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0},
                },
                {
                        {0, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                },

        };
    }
}
