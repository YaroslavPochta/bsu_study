package com.company;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class ReaderUtils {
    public static void parser( List<Beast> arrayList, String fileName ) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Beast");
            if(nodeList.getLength() != 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String[] productionArr = new String[element.getElementsByTagName("production").getLength()];
                        productionArr = element.getElementsByTagName("production").item(0).getTextContent().split(",");
                        arrayList.add(new Beast(
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("habitat").item(0).getTextContent(),
                                productionArr
                        ));
                    }
                }}
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect data");
        }
    }
}
