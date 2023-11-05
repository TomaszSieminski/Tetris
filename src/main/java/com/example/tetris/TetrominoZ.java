package com.example.tetris;

import javafx.scene.image.Image;

import java.util.Objects;

public class TetrominoZ extends TetrominoL {
    public TetrominoZ() {
        super("/Z-Block.png");
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