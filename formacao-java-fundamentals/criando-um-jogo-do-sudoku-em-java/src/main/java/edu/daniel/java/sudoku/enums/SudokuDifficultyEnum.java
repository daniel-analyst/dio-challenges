package edu.daniel.java.sudoku.enums;

public enum SudokuDifficultyEnum {
    FACIL(30),
    MEDIO(40),
    DIFICIL(60),
    MUITO_DIFICIL(70);

    private final int cellsRemoved;

    SudokuDifficultyEnum(int cellsRemoved) {
        this.cellsRemoved = cellsRemoved;
    }

    public int getCellsRemoved() {
        return cellsRemoved;
    }
}
