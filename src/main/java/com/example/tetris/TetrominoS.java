package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoS extends Tetromino {
    public TetrominoS() {
        blockImage = new Image(Objects.requireNonNull(getClass().getResource("/S-Block.png")).toExternalForm());
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
