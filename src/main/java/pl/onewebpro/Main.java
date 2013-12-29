package pl.onewebpro;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.onewebpro.config.Config;

public class Main extends Application {


    private Config config = Config.app();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../views/main.fxml"));
        setUserAgentStylesheet(STYLESHEET_MODENA);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("OneWebPro Reader");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
