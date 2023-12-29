package com.example.certificatefabric.service;

import com.aspose.pdf.*;

import java.io.*;
import java.util.List;

public class PdfService {
    public String readPdf(String url, List<String> nameList, String uploadPackagePath, String changedFieldName) throws IOException {
        System.out.println("Document is loading...");
        Document orgDoc = new Document(url);
        System.out.println("Document is loaded");



        String path = "C:\\Users\\husey\\OneDrive\\Desktop\\Certificates\\";



        for (String name : nameList) {

            System.out.println("Document is loading...");
            Document editDoc = new Document();
            editDoc.getPages().add(orgDoc.getPages().get_Item(1));
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(changedFieldName);
            TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
            editDoc.getPages().accept(textFragmentAbsorber);


            for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
                int positoionXAdd = ((int)textFragment.getTextState().getFontSize() - name.length()) * 2;
                System.out.println(name + ": " +"Horizontal Aligment: "+ textFragment.getTextState().getHorizontalAlignment());
                System.out.println(name + ": " +"Font: "+ textFragment.getTextState().getFont());
                System.out.println(name + ": " +"Font Style: "+ textFragment.getTextState().getFontStyle());
                System.out.println(name + ": " +"Font Size: "+ textFragment.getTextState().getFontSize());
                System.out.println(name + ": " +"LLX: "+ textFragment.getRectangle().getLLX());
                System.out.println(name + ": " +"LLY: "+ textFragment.getRectangle().getLLY());
                System.out.println(name + ": " +"URX: "+ textFragment.getRectangle().getURX());
                System.out.println(name + ": " +"URY: "+ textFragment.getRectangle().getURY());
                System.out.println(name + ": " +"Rotation: "+ textFragment.getTextState().getRotation());
                System.out.println(name + ": " +"Line Spacing: "+ textFragment.getTextState().getLineSpacing());
                System.out.println(name + ": " +"Word Spacing: "+ textFragment.getTextState().getWordSpacing());
                System.out.println(name + ": " +"Foreground Color: "+ textFragment.getTextState().getForegroundColor());
                System.out.println(name + ": " +"Background Color: "+ textFragment.getTextState().getBackgroundColor());
                System.out.println(name + ": " +"Text: "+ textFragment.getText());
                System.out.println(name + ": " +"Text Position: "+ textFragment.getPosition());
                System.out.println(name + ": " +"Text Position: "+ textFragment.getSegments());

                // Update text and other properties
                textFragment.setText(name);
                textFragment.getTextState().setFont(textFragment.getTextState().getFont());
                textFragment.getTextState().setFontSize(textFragment.getTextState().getFontSize());
                textFragment.getTextState().setFontStyle(textFragment.getTextState().getFontStyle());


                textFragment.getTextState().setForegroundColor(textFragment.getTextState().getForegroundColor());
                textFragment.getTextState().setRotation(textFragment.getTextState().getRotation());
                textFragment.setPosition(new Position(textFragment.getPosition().getXIndent() + positoionXAdd , textFragment.getPosition().getYIndent()));
                textFragment.getTextState().setHorizontalAlignment(textFragment.getTextState().getHorizontalAlignment());
                textFragment.getTextState().setDrawTextRectangleBorder(textFragment.getTextState().getDrawTextRectangleBorder());
                textFragment.getTextState().setLineSpacing(textFragment.getTextState().getLineSpacing());
                textFragment.getTextState().setWordSpacing(textFragment.getTextState().getWordSpacing());


                textFragment.setSegments(textFragment.getSegments());
                System.out.println("----------------------------------------");
                System.out.println(name + ": " +"Horizontal Aligment: "+ textFragment.getTextState().getHorizontalAlignment());
                System.out.println(name + ": " +"Font: "+ textFragment.getTextState().getFont());
                System.out.println(name + ": " +"Font Style: "+ textFragment.getTextState().getFontStyle());
                System.out.println(name + ": " +"Font Size: "+ textFragment.getTextState().getFontSize());
                System.out.println(name + ": " +"LLX: "+ textFragment.getRectangle().getLLX());
                System.out.println(name + ": " +"LLY: "+ textFragment.getRectangle().getLLY());
                System.out.println(name + ": " +"URX: "+ textFragment.getRectangle().getURX());
                System.out.println(name + ": " +"URY: "+ textFragment.getRectangle().getURY());
                System.out.println(name + ": " +"Rotation: "+ textFragment.getTextState().getRotation());
                System.out.println(name + ": " +"Line Spacing: "+ textFragment.getTextState().getLineSpacing());
                System.out.println(name + ": " +"Word Spacing: "+ textFragment.getTextState().getWordSpacing());
                System.out.println(name + ": " +"Foreground Color: "+ textFragment.getTextState().getForegroundColor());
                System.out.println(name + ": " +"Background Color: "+ textFragment.getTextState().getBackgroundColor());
                System.out.println(name + ": " +"Text: "+ textFragment.getText());
                System.out.println(name + ": " +"Text Position: "+ textFragment.getPosition());
                System.out.println(name + ": " +"Text Position: "+ textFragment.getSegments());
            }


            System.out.println("Now saving " + name + ".pdf");
            editDoc.save(uploadPackagePath+"\\" + name + ".pdf");
            System.out.println("Saved " + name + ".pdf");


        }

        return path;


    }

}
