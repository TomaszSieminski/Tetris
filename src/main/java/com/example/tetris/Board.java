package com.example.tetris;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Board {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 20;
    private static Tetromino currentTetromino;
    private static Pane currentTetrominoPane;
    private static int currentTetrominoX;
    private static int currentTetrominoY;
    private static final int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];
    static Pane root = new Pane();

    // Enum to define the types of tetromino shapes
    enum ShapeType {
        L, Square, J, T, I, S, Z
    }
    public static void spawnTetromino() {
        Tetromino randomTetromino = createRandomTetromino(); // Create a new random tetromino
        currentTetromino = randomTetromino; // Assign them as current tetromino
        currentTetrominoX = 200; // Set starting position X
        currentTetrominoY = 0; // Set starting position Y
        currentTetrominoPane = randomTetromino.createTetromino(); // Create a Pane for the new tetromino
        currentTetrominoPane.relocate(currentTetrominoX,currentTetrominoY); // Place on the board
        root.getChildren().add(currentTetrominoPane); // Add to the scene
    }
    public static Tetromino createRandomTetromino() {
        Random random = new Random();
        ShapeType randomType = ShapeType.values()[random.nextInt(7)];
        //ShapeType randomType = ShapeType.I;

        Tetromino shape = null;
        // Initialize the tetromino based on its type
        switch (randomType) {
            case L -> shape = new TetrominoL();
            case Square -> shape = new TetrominoSquare();
            case J -> shape = new TetrominoJ();
            case T -> shape = new TetrominoT();
            case I -> shape = new TetrominoI();
            case S -> shape = new TetrominoS();
            case Z -> shape = new TetrominoZ();
        }
        return shape;
    }
    static void moveTetrominoLeft() {
        if (currentTetromino != null) {
            int newX = currentTetrominoX - Tetromino.SIZE;

            if (canMoveTetrominoToPosition(currentTetromino, newX, currentTetrominoY)) {
                currentTetrominoPane.relocate(newX, currentTetrominoY);
                currentTetrominoX = newX;
            }
        }
    }
    static void moveTetrominoRight() {
        if (currentTetromino != null) {
            int newX = currentTetrominoX + Tetromino.SIZE;

            if (canMoveTetrominoToPosition(currentTetromino, newX, currentTetrominoY)) {
                currentTetrominoPane.relocate(newX, currentTetrominoY);
                currentTetrominoX = newX;
            }
        }
    }
    private static boolean canMoveTetrominoToPosition(Tetromino tetromino, int newX, int newY) {
        int[][] shape = tetromino.getShape();
        for (int y = 0; y < Tetromino.shapeSize; y++) {
            for (int x = 0; x < Tetromino.shapeSize; x++) {
                if (shape[y][x] == 1) {
                    int boardX = newX / Tetromino.SIZE + x;
                    int boardY = newY / Tetromino.SIZE + y;

                    if (boardX < 0 || boardX >= BOARD_WIDTH || boardY >= BOARD_HEIGHT || board[boardX][boardY] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static void rotateTetromino() {
        currentTetromino.rotate();
        refreshTetrominoView();
    }
    private static void refreshTetrominoView() {
        root.getChildren().remove(currentTetrominoPane); // Remove the current tetromino
        currentTetrominoPane = currentTetromino.createTetromino(); // Create a new tetromino
        currentTetrominoPane.relocate(currentTetrominoX, currentTetrominoY);
        root.getChildren().add(currentTetrominoPane); // Add it to the scene
    }
    static void moveTetrominoDown() {
        if (currentTetromino != null && canMoveTetrominoDown()) {
            int newY = currentTetrominoY + Tetromino.SIZE;
            currentTetrominoPane.relocate(currentTetrominoX, newY);
            currentTetrominoY = newY;
        } else {
            placeTetrominoOnBoard();
            removeFullLines();
            spawnTetromino();
        }
    }
    private static boolean canMoveTetrominoDown() {
        int newY = currentTetrominoY + Tetromino.SIZE;

        if (newY >= BOARD_HEIGHT * Tetromino.SIZE) {
            return false;
        }

        return canPlaceTetrominoOnBoard(currentTetromino, currentTetrominoX, newY);
    }
    private static boolean canPlaceTetrominoOnBoard(Tetromino currentTetromino, int newX, int newY) {
        int[][] shape = currentTetromino.getShape();
        for (int y = 0; y < Tetromino.shapeSize; y++) {
            for (int x = 0; x < Tetromino.shapeSize; x++) {
                if (shape[y][x] == 1) {
                    int boardX = newX / Tetromino.SIZE + x;
                    int boardY = newY / Tetromino.SIZE + y;

                    if (boardX < 0 || boardX >= BOARD_WIDTH || boardY >= BOARD_HEIGHT || board[boardX][boardY] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static void placeTetrominoOnBoard() {
        int[][] shape = currentTetromino.getShape();
        for (int y = 0; y < Tetromino.shapeSize; y++) {
            for (int x = 0; x < Tetromino.shapeSize; x++) {
                if (shape[y][x] == 1) {
                    int boardX = currentTetrominoX / Tetromino.SIZE + x;
                    int boardY = currentTetrominoY / Tetromino.SIZE + y;
                    board[boardX][boardY] = 1;

                    // Create a new Pane representing a single block
                    Pane blockPane = new Pane();
                    blockPane.relocate(boardX * Tetromino.SIZE, boardY * Tetromino.SIZE);
                    Block block = new Block(Block.image);
                    blockPane.getChildren().add(block);
                    root.getChildren().add(blockPane);
                }
            }
        }

        // Remove the current tetromino from the graphical interface
        root.getChildren().remove(currentTetrominoPane);
    }
    public static void removeFullLines() {
        List<Integer> fullLines = new ArrayList<>();
        for (int y = 0; y < BOARD_HEIGHT; y++) {
            boolean isFull = true;
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if (board[x][y] != 1) {
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                fullLines.add(y);
            }
        }

        if (!fullLines.isEmpty()) {
            for (Integer fullLine : fullLines) {
                removeLine(fullLine);
            }
            // Shift lines above the removed ones down
            shiftLinesAbove(fullLines);
        }
    }
    // Remove a specific line from the board
    private static void removeLine(int line) {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            board[x][line] = 0;
        }

        List<Node> nodesToRemove = new ArrayList<>();
        for (Node node : root.getChildren()) {
            if (node instanceof Pane) {
                Pane square = (Pane) node;
                int squareY = (int) (square.getLayoutY() / Tetromino.SIZE);
                if (squareY == line) {
                    nodesToRemove.add(square);
                }
            }
        }

        Platform.runLater(() -> {
            root.getChildren().removeAll(nodesToRemove);
        });
    }
    // Shift lines above the removed lines down
    private static void shiftLinesAbove(List<Integer> fullLines) {
        if (!fullLines.isEmpty()) {
            int lowestFullLine = fullLines.get(fullLines.size() - 1);

            for (int y = lowestFullLine - 1; y >= 0; y--) {
                for (int x = 0; x < BOARD_WIDTH; x++) {
                    int newValue = (y - fullLines.size() >= 0) ? board[x][y - fullLines.size()] : 0;
                    board[x][y] = newValue;
                }
            }

            for (Node node : root.getChildren()) {
                if (node instanceof Pane) {
                    Pane square = (Pane) node;
                    double squareY = square.getLayoutY();
                    int squareYIndex = (int) (squareY / Tetromino.SIZE);

                    if (squareYIndex < lowestFullLine) {
                        double newY = squareY + fullLines.size() * Tetromino.SIZE;
                        square.relocate(square.getLayoutX(), newY);
                    }
                }
            }
        }
    }
}