package pl.onewebpro.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MainController {

    private double initialX = 0;
    private double initialY = 0;

    @FXML
    private ToolBar menu;

    public void initialize() {
        addDragListeners(menu);
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
