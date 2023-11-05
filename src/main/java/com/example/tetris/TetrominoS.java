package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoS extends TetrominoL {
    public TetrominoS() {
        super("/S-Block.png");
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
