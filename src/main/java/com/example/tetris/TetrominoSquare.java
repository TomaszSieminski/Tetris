package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoSquare extends Tetromino {
    public TetrominoSquare() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/Square.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                },
        };
    }
}
