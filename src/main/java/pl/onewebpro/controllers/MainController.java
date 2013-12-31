package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.onewebpro.data.ReaderFile;
import pl.onewebpro.data.ReaderFolder;

import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class MainController implements Initializable, Observer {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    @FXML
    private MenuBar menu;

    @FXML
    private MenuController menuController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuController.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
            if (arg instanceof ReaderFile && !((ReaderFile) arg).getFile().isDirectory()) {
                loadFile((ReaderFile) arg);
            }
            if (arg instanceof ReaderFolder) {
                loadFolder((ReaderFolder) arg);
            }
    }

    public void loadFile(ReaderFile file) {

    }

    public void loadFolder(ReaderFolder folder) {

    }
}
