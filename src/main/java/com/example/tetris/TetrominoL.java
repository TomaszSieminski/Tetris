package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoL extends Tetromino {
    public TetrominoL() {
        shapeSize = 3;
        //blockImage = new Image(Objects.requireNonNull(getClass().getResource("/L-Block.png")).toExternalForm());
        shapes = new int[][][]{
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {1, 0, 0}
                },
                {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0}
                },
                {
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}
                },

        };
    }

}

