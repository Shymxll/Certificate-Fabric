package com.example.certificatefabric;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Certificate Fabric");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        String encodingText = "Identity-H";


        Locale.setDefault(Locale.ENGLISH);
        System.out.println("encodingText = " + encodingText);

        launch();


    }
}