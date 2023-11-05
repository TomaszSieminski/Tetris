package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoJ extends TetrominoL {
    public TetrominoJ() {
        super("/J-Block.png");
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