package com.example.tetris;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class Score {
    private int score;
    private final Label scoreLabel;

    public Score() {
        this.score = 0;
        this.scoreLabel = createScoreLabel();
    }

    private Label createScoreLabel() {
        Label label = new Label("Score: " + score);
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        label.setAlignment(Pos.TOP_RIGHT);
        label.setPrefWidth(Board.BOARD_WIDTH * Tetromino.SIZE);
        label.setTextAlignment(TextAlignment.RIGHT);
        return label;
    }

    public void increaseScore(int points) {
        score += points;
        scoreLabel.setText("Score: " + score);
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }
}
