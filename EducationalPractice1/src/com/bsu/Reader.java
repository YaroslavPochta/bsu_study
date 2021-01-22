package com.bsu;

import com.bsu.model.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

//TODO: add readers for other candies

public class Reader {
    public static List<Candy> parse(String fileName ) {
        List<Candy> arrayList = new ArrayList<Candy>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("CandyWithNuts");
      /*      if (nodeList.getLength() != 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        arrayList.add(new CandyWithNuts(
                                Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("percentOfSugar").item(0).getTextContent()),
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                Integer.parseInt(element.getElementsByTagName("numberOfNuts").item(0).getTextContent())
                        ));
                    }
                }
            }*/
            nodeList = doc.getElementsByTagName("ChocolateCandy");
            if (nodeList.getLength() != 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        arrayList.add(new ChocolateCandy(
                                Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("percentOfSugar").item(0).getTextContent()),
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("chocolateType").item(0).getTextContent()
                        ));
                    }
                }
            }

            nodeList = doc.getElementsByTagName("Lollipop");
            if (nodeList.getLength() != 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        arrayList.add(new Lollipop(
                                Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("percentOfSugar").item(0).getTextContent()),
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("colour").item(0).getTextContent()
                        ));
                    }
                }
            }
            nodeList = doc.getElementsByTagName("Marmalade");
            if (nodeList.getLength() != 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        arrayList.add(new Marmalade(
                                Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("percentOfSugar").item(0).getTextContent()),
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("fruit").item(0).getTextContent()
                        ));
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getStackTrace().toString() + e.getMessage() + e.getCause());
        } catch (Exception e) {
            System.out.println("Incorrect data, please try with another input file" + e.getMessage() + e.getCause());
        }
        return arrayList;
    }
   /* private void add(Class ClassName, String tagName, List<Candy> arrayList, org.w3c.dom.Document doc)
    {
        NodeList nodeList = doc.getElementsByTagName(ClassName.getName());
        if (nodeList.getLength() != 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    arrayList.add(new ClassName (
                            Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent()),
                            Double.parseDouble(element.getElementsByTagName("percentOfSugar").item(0).getTextContent()),
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("fruit").item(0).getTextContent()
                    ));
                }
            }
        }
    }*/
}


