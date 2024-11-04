package com.example.remotex;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class NewClient extends StartClient {
    @FXML
    TextField IParea;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void BackToHomw(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
//        System.out.println("123");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void GetAccess(ActionEvent event) throws IOException{
        boolean access = false;
        String ip = IParea.getText();
        new StartClient().initialize(ip, Integer.parseInt(port));

    }

    public void Iparea(ActionEvent event) throws IOException{
        boolean access = false;
        String ip = IParea.getText();
        new StartClient().initialize(ip, Integer.parseInt(port));

    }
}
