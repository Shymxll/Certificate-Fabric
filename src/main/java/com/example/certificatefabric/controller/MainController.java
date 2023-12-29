package com.example.certificatefabric.controller;

import com.example.certificatefabric.service.PdfService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainController {

    private PdfService pdfService = new PdfService();

    private String uploadPackagePath;

    @FXML
    private Button fileChooserButton;

    @FXML
    private TextArea nameListTextArea;

    @FXML
    private TextField changedFieldName;

    //action event handler for the file chooser button
    public void fileChooserButtonAction()  {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Dosyaları", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {

            String pdfFilePath = selectedFile.getAbsolutePath();
            System.out.println(pdfFilePath);
            List<String> nameList = getNameList();
            String changedField = changedFieldName.getText();
            System.out.println(changedField);
            try {

                pdfService.readPdf(pdfFilePath, nameList, uploadPackagePath, changedField);
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }


        }

    }

    //get name list from text area
    public List<String> getNameList(){
        String nameList = nameListTextArea.getText();
        String[] nameArray = nameList.split("\n");
        return List.of(nameArray);
    }

    //create new folder for certificates
    public void uploadPackageChosenButtonAction(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Klasör", "*.*"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());
        if(selectedFile != null) {
            uploadPackagePath = selectedFile.getAbsolutePath();
            System.out.println(uploadPackagePath);
            //create new folder
            File folder = new File(uploadPackagePath + "\\Certificates");
            if (!folder.exists()) {
                folder.mkdir();
            }
        }



    }

    public void testButtonAction(){
        System.out.println("test button clicked");
        try {
            pdfService.readPdf(
                    "C:\\Users\\husey\\OneDrive\\Desktop\\certificate.pdf",
                     List.of("Hüseyin Hüseyinov", "Ahmet Nebati", "Mehmet İlyasov","Ali Asim Bulut Elbosivan"),
                    "C:\\Users\\husey\\OneDrive\\Desktop\\Certificates\\testfold",
                    "firstName_lastName");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}