package com.example.tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Pane {
    public static final int SIZE = 50;

    public Block() {
        Rectangle rectangle = new Rectangle(SIZE, SIZE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);
        getChildren().add(rectangle);
    }
}
