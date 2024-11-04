package com.example.remotex;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Application extends javafx.application.Application {



    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("GettingStarted.fxml"));
        //Stage stage = new Stage();
       // Group root = new Group();


        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//        String css = this.getClass().getResource("application.css").toExternalForm();
//        scene.getStylesheets().add(css)
       Scene scene = new Scene(root,Color.BLACK);
               //Image icon = new Image("icon.png");
        //stage.getIcons().add(icon);
        //stage.setTitle("Stage Demo Program w00t w00t");
        stage.setWidth(1200);
        stage.setHeight(700);
        stage.setResizable(false);
        //stage.setX(50);
        //stage.setY(50);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("YOU CAN'T ESCAPE unless you press q");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
}


    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
