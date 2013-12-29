package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
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

    @FXML
    public Menu menu;

    @FXML
    public MenuBar menuBar;

    final FileChooser fileChooser = new FileChooser();

    final DirectoryChooser directoryChooser = new DirectoryChooser();

    private Window stage;

    FileChooser.ExtensionFilter pdfExt = new FileChooser.ExtensionFilter("Acrobat PDF documents", "*.pdf");
    FileChooser.ExtensionFilter xpsExt = new FileChooser.ExtensionFilter("XPS documents", "*.xps");
    FileChooser.ExtensionFilter cbzExt = new FileChooser.ExtensionFilter("Comic book documents", "*.cbz");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.getExtensionFilters().addAll(pdfExt, xpsExt, cbzExt);
        //Close button
        exit.setOnAction(ae -> {
            System.exit(0);
        });

        open.setOnAction(ae -> {
            if (stage == null) {
                stage = menuBar.getScene().getWindow();
            }
            File file = fileChooser.showOpenDialog(stage);
            if (file != null && file.isFile()) {
                //TODO:Open file
            }
        });

        importFolder.setOnAction(ae -> {
            if (stage == null) {
                stage = menuBar.getScene().getWindow();
            }
            File file = directoryChooser.showDialog(stage);
            if (file != null && file.isDirectory()) {
                //TODO:import folder
            }
        });

    }
}
