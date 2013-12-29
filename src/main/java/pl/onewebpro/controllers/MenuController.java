package pl.onewebpro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    private double initialX = 0;
    private double initialY = 0;

    @FXML
    private ToolBar menu;

    @FXML
    private Button exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addDragListeners(menu);
        exit.setOnAction(ev -> {
            System.exit(0);
        });
    }

    private void addDragListeners(final Node n){
        n.setOnMousePressed(me -> {
            if(me.getButton()!= MouseButton.MIDDLE)
            {
                initialX = me.getSceneX();
                initialY = me.getSceneY();
            }
            else
            {
                n.getScene().getWindow().centerOnScreen();
                initialX = n.getScene().getWindow().getX();
                initialY = n.getScene().getWindow().getY();
            }

        });

        n.setOnMouseDragged(me -> {
            if(me.getButton()!=MouseButton.MIDDLE)
            {
                n.getScene().getWindow().setX( me.getScreenX() - initialX );
                n.getScene().getWindow().setY( me.getScreenY() - initialY);
            }
        });
    }
}
