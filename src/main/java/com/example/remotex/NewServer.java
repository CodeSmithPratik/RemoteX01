package com.example.remotex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.web.WebEngine;import javafx.scene.web.WebView;
import javafx.scene.media.*;
import javafx.fxml.FXML;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.io.IOException;


public class NewServer  {
@FXML
Label Local;


    private Parent root;
    private Stage stage;
    private Scene scene;

    
public void refres(ActionEvent evet){


    try {
        InetAddress  myIp = InetAddress.getLocalHost();
        String orinip = myIp.getHostAddress();
        Local.setText(orinip);
    }catch (Exception ex){




        System.out.println(ex.getMessage());
    }

}


    public void BackToHomw(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
//        System.out.println("123");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void giveAcces(ActionEvent event) throws IOException {
      startServer st = new startServer();
      st.start();

    }

//    public void setTime (ActionListener event) throws IOException {
//
//    }

}
