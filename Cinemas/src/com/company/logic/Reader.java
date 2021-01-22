package com.company.logic;

import com.company.model.Cinema;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static List<Cinema> parse(String fileName ) {
        List<Cinema> arrayList = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(fileName);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Cinema");
            if(nodeList.getLength() != 0){
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        List<String> productionArr;
                        productionArr = Arrays.asList(element.getAttribute("movies").split(", "));
                        arrayList.add(new Cinema(
                                element.getAttribute("name"),
                                Integer.parseInt(element.getAttribute("seats")),
                                productionArr
                        ));
                    }
                }}
            return arrayList;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect data");
        } catch (Exception e){
            System.out.println(e.getMessage() + e.getCause());
        }
        return arrayList;
    }
}
