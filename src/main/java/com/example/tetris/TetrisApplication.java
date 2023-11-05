
package com.example.tetris;

import javafx.application.Application;
import javafx.stage.Stage;

public class TetrisApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TetrisGame tetrisGame = new TetrisGame();
        tetrisGame.start(primaryStage);
    }
}

