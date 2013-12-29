package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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

    private Window stage;

    FileChooser.ExtensionFilter pdfExt = new FileChooser.ExtensionFilter("Acrobat PDF documents", "*.pdf");
    FileChooser.ExtensionFilter xpsExt = new FileChooser.ExtensionFilter("XPS documents", "*.xps");
    FileChooser.ExtensionFilter cbzExt = new FileChooser.ExtensionFilter("Comic book documents", "*.cbz");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Close button
        exit.setOnAction(ae -> {
            System.exit(0);
        });

        open.setOnAction(ae ->{
            fileChooser.getExtensionFilters().addAll(pdfExt,xpsExt,cbzExt);
            File file = fileChooser.showOpenDialog(stage);
            if(stage == null)
                stage = menuBar.getScene().getWindow();
            if (file != null) {
                //TODO:Open file
            }
        });

    }
}
