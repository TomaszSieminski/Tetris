package com.example.tetris;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Block extends Pane {
    public static final int SIZE = 50;
    static Image image;

    public Block(Image image) {
        Block.image = image;
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(SIZE);
        imageView.setFitHeight(SIZE);
        getChildren().add(imageView);
    }
}
