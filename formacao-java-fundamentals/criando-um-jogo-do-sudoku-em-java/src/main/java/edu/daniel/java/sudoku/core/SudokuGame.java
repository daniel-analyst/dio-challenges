package edu.daniel.java.sudoku.core;

import edu.daniel.java.sudoku.enums.SudokuDifficultyEnum;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuGame {

    private final int GRID_SIZE = 9;
    private final int[][] game = new int[this.GRID_SIZE][this.GRID_SIZE];
    private final Random random = new Random();

    /**
     * Generates a new game.
     *
     * @param sudokuDifficultyEnum
     *      Game difficulty.
     *
     * @return int[][]
     *      Ready matrix to assemble the game.
     *
     * @author Daniel Silva Marcelino.
     */
    public int[][] generateGame(SudokuDifficultyEnum sudokuDifficultyEnum) {
        this.fillGrid();
        this.removeNumbers(sudokuDifficultyEnum.getCellsRemoved());
        return this.game;
    }

    /**
     * Validates the game after it has been completed by the player.
     *
     * @param filledGame
     *      Matrix with the complete game filled in by the user.
     *
     * @return boolean
     *      True if the game is correct.
     *
     * @author Daniel Silva Marcelino.
     */
    public boolean isGameValid(int[][] filledGame) {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            if (!isRowValid(row, filledGame)) {
                return false;
            }
        }

        for (int column = 0; column < GRID_SIZE; column++) {
            if (!isColumnValid(column, filledGame)) {
                return false;
            }
        }

        for (int startRow = 0; startRow < GRID_SIZE; startRow += 3) {
            for (int startColumn = 0; startColumn < GRID_SIZE; startColumn += 3) {
                if (!isBlockValid(startRow, startColumn, filledGame)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Generates the numbers for a complete and valid game.
     *
     * @return boolean
     *      True if a valid complete game is generated. Used for internal recursion control.
     *
     * @author Daniel Silva Marcelino.
     */
    private boolean fillGrid() {
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int column = 0; column < this.GRID_SIZE; column++) {
                if (this.game[row][column] == 0) {
                    List<Integer> numbers = IntStream.rangeClosed(1, this.GRID_SIZE)
                            .boxed()
                            .collect(Collectors.toList());
                    Collections.shuffle(numbers);
                    for (int number : numbers) {
                        if (this.isValid(row, column, number)) {
                            this.game[row][column] = number;
                            if (this.fillGrid()) {
                                return true;
                            }
                            this.game[row][column] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates whether the number to be entered is valid following the sudoku rule.
     *
     * @param row
     *      Line number where the number will be inserted.
     *
     * @param column
     *      Column number where the number will be inserted.
     *
     * @param number
     *      Number must be entered in the game.
     *
     * @return boolean
     *      True if the number can be entered into the game and false if not.
     *
     * @author Daniel Silva Marcelino.
     */
    private boolean isValid(int row, int column, int number) {

        for (int i = 0; i < this.GRID_SIZE; i++) {
            if (this.game[row][i] == number) {
                return false;
            }
        }

        for (int x = 0; x < this.GRID_SIZE; x++) {
            if (this.game[x][column] == number) {
                return false;
            }
        }

        int startRow = row - (row % 3);
        int startColumn = column - (column % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.game[i + startRow][j + startColumn] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Removes cells from a generated game to create a match according to difficulty.
     *
     * @param cellsRemoved
     *      Amount of cells to be removed.
     *
     * @author Daniel Silva Marcelino.
     */
    private void removeNumbers(int cellsRemoved) {
        while (cellsRemoved > 0) {
            int row = this.random.nextInt(this.GRID_SIZE);
            int column = this.random.nextInt(this.GRID_SIZE);
            if (this.game[row][column] != 0) {
                this.game[row][column] = 0;
                cellsRemoved--;
            }
        }
    }

    /**
     * Validates the row of a complete game that was filled in by the user.
     *
     * @param row
     *      Game row filled in for validation.
     *
     * @param filledGame
     *      Matrix with the complete game filled in by the user.
     *
     * @return boolean
     *      True if the row is correct.
     *
     * @author Daniel Silva Marcelino.
     */
    private boolean isRowValid(int row, int[][] filledGame) {
        boolean[] numberSeen = new boolean[GRID_SIZE + 1];
        for (int column = 0; column < GRID_SIZE; column++) {
            int number = filledGame[row][column];
            if (number != 0) {
                if (numberSeen[number]) {
                    return false;
                }
                numberSeen[number] = true;
            }
        }
        return true;
    }

    /**
     * Validates the column of a complete game that was filled in by the user.
     *
     * @param column
     *      Game column filled in for validation.
     *
     * @param filledGame
     *      Matrix with the complete game filled in by the user.
     *
     * @return boolean
     *      True if the column is correct.
     *
     * @author Daniel Silva Marcelino.
     */
    private boolean isColumnValid(int column, int[][] filledGame) {
        boolean[] numberSeen = new boolean[GRID_SIZE + 1];
        for (int row = 0; row < GRID_SIZE; row++) {
            int number = filledGame[row][column];
            if (number != 0) {
                if (numberSeen[number]) {
                    return false;
                }
                numberSeen[number] = true;
            }
        }
        return true;
    }

    /**
     * Validates the 3x3 matrix of a complete game that was filled in by the user.
     *
     * @param startRow
     *      Starting position of the 3x3 matrix row to be validated.
     *
     * @param startColumn
     *      Starting position of the 3x3 matrix column to be validated.
     *
     * @param filledGame
     *      Matrix with the complete game filled in by the user.
     *
     * @return boolean
     *      True if the 3x3 matrix is correct.
     *
     * @author Daniel Silva Marcelino.
     */
    private boolean isBlockValid(int startRow, int startColumn, int[][] filledGame) {
        boolean[] numberSeen = new boolean[GRID_SIZE + 1];
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                int number = filledGame[startRow + row][startColumn + column];
                if (number != 0) {
                    if (numberSeen[number]) {
                        return false;
                    }
                    numberSeen[number] = true;
                }
            }
        }
        return true;
    }

}
