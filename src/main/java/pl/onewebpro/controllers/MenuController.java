package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {
    @FXML
    public MenuItem open;

    @FXML
    public MenuItem importFolder;

    @FXML
    public MenuItem exit;

    @FXML
    public MenuItem about;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Close button
        exit.setOnAction(ae -> {
            System.exit(0);
        });
    }
}
