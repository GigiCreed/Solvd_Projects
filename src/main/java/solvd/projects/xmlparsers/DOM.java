package solvd.projects.xmlparsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    private static final Logger LOGGER = LogManager.getLogger(DOM.class);
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src\\main\\resources\\xml\\students.xml"));

        Element element = document.getDocumentElement();
        LOGGER.info(element);
        NodeList nodeList =element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                System.out.println();
                LOGGER.info(nodeList.item(i).getNodeName()+" "+nodeList.item(i).getAttributes().getNamedItem("id"));
                NodeList studentList =nodeList.item(i).getChildNodes();
                for (int j = 0; j <studentList.getLength() ; j++) {
                    if (studentList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                       LOGGER.info(studentList.item(j).getNodeName() + ": " + studentList.item(j).getTextContent());
                    }
                }
            }
        }


    }
}
