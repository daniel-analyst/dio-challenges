package edu.daniel.java.sudoku.util;

import javafx.scene.control.Alert;

public class BasicFxUtil {

    private static Alert alert;

    /**
     * Method showing a window containing the error message released.
     *
     * @param windowTitle
     *      Receives a string that will be the title of the window.
     *
     * @param message
     *      Receives a string that will be the message to be shown to the user.
     *
     * @author Daniel Silva Marcelino
     */
    public static void error(String windowTitle, String message) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(windowTitle);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Method that shows information to the user.
     *
     * @param windowTitle
     *      Receives a string that will be the title of the window.
     *
     * @param message
     *      Receives a string that will be the message to be shown to the user.
     *
     * @author Daniel Silva Marcelino
     */
    public static void success(String windowTitle, String message) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(windowTitle);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
