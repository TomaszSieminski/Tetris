package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoJ extends Tetromino {
    public TetrominoJ() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/J-Block.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {1, 1, 0}
                },
                {
                        {1, 0, 0},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {0, 1, 1},
                        {0, 1, 0},
                        {0, 1, 0}
                },
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {0, 0, 1}
                },

        };
    }
}