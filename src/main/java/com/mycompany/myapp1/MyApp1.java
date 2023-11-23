/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp1;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MyApp1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MySecApp");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("GO");

        button.addActionListener((ActionEvent e) -> {
            String text = textField.getText();
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("root");
                doc.appendChild(rootElement);
                Element userText = doc.createElement("userText");
                userText.appendChild(doc.createTextNode(text));
                rootElement.appendChild(userText);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("file.xml"));
                transformer.transform(source, result);
            } catch (ParserConfigurationException | TransformerException | DOMException ex) {
            }
        });
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(button, "South");
        frame.pack();
        frame.setVisible(true);
        }
    }




/**
 *
 * @author amanaarmantrading
 */


