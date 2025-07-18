module edu.daniel.java.sudoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens edu.daniel.java.sudoku.controller to javafx.fxml;
    exports edu.daniel.java.sudoku.controller;
    opens edu.daniel.java.sudoku.view to javafx.fxml;
    exports edu.daniel.java.sudoku.view;
}