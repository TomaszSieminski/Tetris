package com.example.tetris;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TetrisGame extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tetris");
        Scene scene = new Scene(Board.root, Board.BOARD_WIDTH * Tetromino.SIZE, Board.BOARD_HEIGHT * Tetromino.SIZE);
        scene.setFill(Color.DARKGRAY); // Set the background color

        Board.spawnTetromino();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT -> Board.moveTetrominoLeft();
                case RIGHT -> Board.moveTetrominoRight();
                case SPACE -> Board.rotateTetromino();
                case DOWN -> Board.moveTetrominoDown();
            }
        });
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(100000000), event -> {
                    Board.moveTetrominoDown();
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}