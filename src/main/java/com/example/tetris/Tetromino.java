package com.example.tetris;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Tetromino {
    public static final int SIZE = 50;
    public static int shapeSize = 0;
    int[][][] shapes;
    int currentShape;
    Block[][] blocks; // Tablica bloków reprezentujących tetromino
    Image blockImage;

    public Tetromino() {
        shapes = new int[][][] { };
        currentShape = 0;
        blocks = new Block[4][4]; // Maksymalnie 4 bloki w tetromino
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                blocks[i][j] = new Block(blockImage);
            }
        }
    }

    public Pane createTetromino() {
        Pane tetromino = new Pane();

        int[][] shape = shapes[currentShape];
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] == 1) {
                    Block block = new Block(blockImage);
                    block.relocate(x * SIZE, y * SIZE);
                    tetromino.getChildren().add(block);
                }
            }
        }
        return tetromino;
    }

    public int[][] getShape() {
        return shapes[currentShape];
    }

    public void rotate() {
        currentShape = (currentShape + 1) % shapes.length;
    }
}
