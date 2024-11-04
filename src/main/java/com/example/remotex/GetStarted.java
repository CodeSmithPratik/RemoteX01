package com.example.remotex;

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

public class GetStarted  {
    private Stage stage;
    private Scene scene;
    private Parent root;

//    MediaView media;
//    private File file = new File("bidio.mp4");
//    private Media md = new Media(file.toURI().toString());
//    private MediaPlayer mdp = new MediaPlayer(md);
//
//public void GetStarted() {
//   mdp.setAutoPlay(true);
//}

        public void gtstrtToSignin (ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Signin.fxml"));
            System.out.println("123");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
//        while(true){
//            SwingUtilities.invokeLater(()->
//            {System.out.println("123");
//            try {Thread.sleep(3000);}catch(InterruptedException e){ e.printStackTrace ();} });
            //  }
        }
    }

