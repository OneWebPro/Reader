package pl.onewebpro.controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.onewebpro.actors.DataActor;
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

    private ActorSystem system = ActorSystem.create("MySystem");

    private ActorRef data = system.actorOf(Props.create(DataActor.class), "data");

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
