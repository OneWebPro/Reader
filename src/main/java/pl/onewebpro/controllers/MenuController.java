package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.onewebpro.data.ReaderFile;
import pl.onewebpro.data.ReaderFolder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;


public class MenuController extends Observable implements Initializable {
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

    final Stage aboutStage = new Stage();

    private Scene aboutWindow;

    private Window stage;

    private Logger log = LoggerFactory.getLogger(MenuController.class);

    private FileChooser.ExtensionFilter pdfExt = new FileChooser.ExtensionFilter("Acrobat PDF documents", "*.pdf");
    private FileChooser.ExtensionFilter xpsExt = new FileChooser.ExtensionFilter("XPS documents", "*.xps");
    private FileChooser.ExtensionFilter cbzExt = new FileChooser.ExtensionFilter("Comic book documents", "*.cbz");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.getExtensionFilters().addAll(pdfExt,xpsExt,cbzExt);
        try {
            aboutWindow = new Scene(FXMLLoader.load(getClass().getResource("../../../views/about.fxml")));
        } catch (IOException e) {
            log.error("Not found about.fxml",e);
        }

        //Close button
        exit.setOnAction(ae -> {
            System.exit(0);
        });

        open.setOnAction(ae -> {
            getStage();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null && file.isFile()) {
                notifyObservers(new ReaderFile(file));
            }
        });

        importFolder.setOnAction(ae -> {
            getStage();
            File file = directoryChooser.showDialog(stage);
            if (file != null && file.isDirectory()) {
                notifyObservers(new ReaderFolder(file));
            }
        });

        about.setOnAction(ae -> {
            if (aboutStage.getScene() == null) {
                aboutStage.setScene(aboutWindow);
                aboutStage.setTitle("About");
                aboutStage.initModality(Modality.WINDOW_MODAL);
            }
            aboutStage.show();
        });

    }

    private void getStage() {
        if (stage == null) {
            stage = menuBar.getScene().getWindow();
        }
    }
}
