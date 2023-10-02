package com.example.certificatefabric.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloController {

    @FXML
    private Button fileChooserButton;

    //action event handler for the file chooser button
    public void fileChooserButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Dosyaları", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            String pdfFilePath = selectedFile.getAbsolutePath();
            System.out.println(pdfFilePath);

            // Seçilen PDF dosyasının yolu burada pdfFilePath değişkeninde bulunur.
            // Bu yolu kullanarak PDF dosyasını işleyebilirsiniz.
        }

    }


}