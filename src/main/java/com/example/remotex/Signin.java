package com.example.remotex;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javafx.stage.Stage;




public class Signin implements Initializable {



    @FXML
    TextField uname;
    @FXML
    PasswordField passwd;

    private Stage stage;
    private Scene scene;
    private Parent root;
public String username,Fpass;

    @FXML
    MediaView mediaView;
    private File file1;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            file1 = new File("src/main/resources/com/example/remotex/bidio.mp4");
            media = new Media(file1.toURI().toString());
        } catch (MediaException e) {
            e.printStackTrace();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }




    public void Login(ActionEvent event) throws IOException {
        String username = uname.getText();
        String Fpass = passwd.getText();

 FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        root =loader.load();

        Home home =loader.getController();
        home.displayname(username);

//        Parent root = FXMLLoader.load(getClass().getResource("SERVER.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}
