package com.example.remotex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    @FXML
    Label urname;
    private Stage stage;
    private Scene scene;
    private Parent root;
 String css;

    public void displayname(String urnm) {
        urname.setText (urnm);
    }

    public void switchToClientfromHOME(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartingClient.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
//        String css =this.getClass().getResource( "application.css " ) . toExternalForm() ;
//        scene. getStylesheets() . add(css) ;



        stage.setScene(scene);
        stage.show();
    }

    public void switchToServerFromHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartingServer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
