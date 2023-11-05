package com.example.tetris;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class TetrominoSquare extends TetrominoL {
    //Image blockImage = new Image(Objects.requireNonNull(getClass().getResource("/Square.png")).toExternalForm());
    public TetrominoSquare() {
        super("/Square.png");
        shapes = new int[][][]{
                {
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                },
        };
    }
}
