package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoZ extends Tetromino {
    public TetrominoZ() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/Z-Block.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 1, 0},
                },
                {
                        {0, 1, 1},
                        {1, 1, 0},
                        {0, 0, 0}
                },
        };
    }
}