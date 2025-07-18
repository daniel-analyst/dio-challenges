package edu.daniel.java.sudoku.controller;

import edu.daniel.java.sudoku.core.SudokuGame;
import edu.daniel.java.sudoku.enums.SudokuDifficultyEnum;
import edu.daniel.java.sudoku.util.BasicFxUtil;
import edu.daniel.java.sudoku.util.StringsUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.function.UnaryOperator;

public class SudokuController {

    @FXML
    private VBox mainVBox;

    private final int GRID_SIZE = 9;
    private final TextField[][] textFields = new TextField[this.GRID_SIZE][this.GRID_SIZE];
    private final SudokuGame sudokuGame = new SudokuGame();

    @FXML
    public void initialize() {
        this.recoverCells();
        populateTextFields(this.sudokuGame.generateGame(SudokuDifficultyEnum.MEDIO));
    }

    /**
     * Maps all textfields on the game grid.
     *
     * @author Daniel Silva Marcelino.
     */
    private void recoverCells() {
        for (int line = 0; line < 3; line++) {
            HBox hBox = (HBox) mainVBox.getChildren().get(line);

            for (int column = 0; column < 3; column++) {
                GridPane gridPane = (GridPane) hBox.getChildren().get(column);

                for (int cellLines = 0; cellLines < 3; cellLines++) {
                    for (int cellColumns = 0; cellColumns < 3; cellColumns++) {
                        int sudokuLine = line * 3 + cellLines;
                        int sudokuColumn = column * 3 + cellColumns;
                        TextField textField = (TextField) gridPane.getChildren().get(cellColumns * 3 + cellLines);
                        textField.setFocusTraversable(false);
                        this.allowNumbersOnly(textField);
                        this.textFields[sudokuLine][sudokuColumn] = textField;

                        textField.textProperty().addListener((observable, oldValue, newValue) -> {
                            validateFullGame();
                        });
                    }
                }
            }
        }
    }

    /**
     * Fill the cells with the created game.
     *
     * @param game
     *      Game object created.
     *
     * @author Daniel Silva Marcelino.
     */
    private void populateTextFields(int[][] game) {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int column = 0; column < this.GRID_SIZE; column++) {
                if (game[row][column] == 0) {
                    textFields[row][column].setText("");
                } else {
                    textFields[row][column].setText(String.valueOf(game[row][column]));
                    textFields[row][column].setDisable(true);
                }
            }
        }
    }

    /**
     * Check if all cells are filled and validate the game if it is complete.
     *
     * @author Daniel Silva Marcelino.
     */
    private void validateFullGame() {
        boolean allFilled = true;
        int[][] filledGame = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int col = 0; col < this.GRID_SIZE; col++) {
                String text = textFields[row][col].getText();

                if (text == null || text.trim().isEmpty()) {
                    allFilled = false;
                    break;
                }
                filledGame[row][col] = Integer.parseInt(text);
            }
            if (!allFilled) {
                break;
            }
        }

        if (allFilled) {
            if (this.sudokuGame.isGameValid(filledGame)) {
                BasicFxUtil.success(StringsUtil.PARABENS, StringsUtil.JOGO_CERTO);
            } else {
                BasicFxUtil.error(StringsUtil.FICA_PARA_PROXIMA, StringsUtil.JOGO_ERRADO);
            }
        }
    }

    /**
     * Set to numbers only and only one number.
     *
     * @param textField
     *      Game cells.
     *
     * @author Daniel Silva Marcelino.
     */
    private void allowNumbersOnly(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[0-this.GRID_SIZE]?")) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }
}