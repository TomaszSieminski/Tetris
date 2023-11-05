package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoI extends TetrominoL {
    public TetrominoI() {
        super("/I-Block.png");
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
