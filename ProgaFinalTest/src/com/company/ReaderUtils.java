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
    public static void parser( List<Employee> arrayList, String fileName ) throws ParserConfigurationException, IOException, SAXException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Cleaner");
            if(nodeList.getLength() != 0){
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    arrayList.add(new SecurityGuard(
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            Positions.valueOf(element.getElementsByTagName("position").item(0).getTextContent()),
                            Integer.valueOf(element.getElementsByTagName("salary").item(0).getTextContent()),
                            element.getElementsByTagName("pathToIcon").item(0).getTextContent(),
                            element.getElementsByTagName("guardedObject").item(0).getTextContent()
                    ));
                }
            }}
            else {
                nodeList = doc.getElementsByTagName("Cleaner");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        arrayList.add(new Cleaner(
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                Positions.valueOf(element.getElementsByTagName("position").item(0).getTextContent()),
                                Integer.valueOf(element.getElementsByTagName("salary").item(0).getTextContent()),
                                element.getElementsByTagName("pathToIcon").item(0).getTextContent(),
                                Integer.valueOf(element.getElementsByTagName("numberOfRoooms").item(0).getTextContent())
                        ));
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect data");
        }
    }

    public List<Employee> securityGuardReader(List<Employee> arrayList){
        return null;
    }
}

