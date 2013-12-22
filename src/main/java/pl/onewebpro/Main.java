package pl.onewebpro;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.onewebpro.config.Config;

public class Main extends Application {


    private Config config = Config.app();

    private double initialX = 0;
    private double initialY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../views/sample.fxml"));
        addDragListeners(root);
        setUserAgentStylesheet(STYLESHEET_MODENA);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("OneWebPro Reader");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void addDragListeners(final Node n){
        n.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if(me.getButton()!=MouseButton.MIDDLE)
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

            }
        });

        n.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if(me.getButton()!=MouseButton.MIDDLE)
                {
                    n.getScene().getWindow().setX( me.getScreenX() - initialX );
                    n.getScene().getWindow().setY( me.getScreenY() - initialY);
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
