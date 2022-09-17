package solvd.projects.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX {
    private final static Logger LOGGER = LogManager.getLogger(SAX.class);
    public static void main(String[] args) {
        DefaultHandler defaultHandler = new DefaultHandler(){
             boolean name =false;
             boolean surname =false;
             boolean birthDate= false;
             boolean phone_number =false;
             boolean course = false;
             boolean email = false;


            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                LOGGER.info("Start Element: "+qName);
                if (qName.equals("name")) name =true;
                if (qName.equals("surname")) surname=true;
                if (qName.equals("birthDate")) birthDate =true;
                if (qName.equals("phone_number"))phone_number=true;
                if (qName.equals("course")) course=true;
                if (qName.equals("email")) email = true;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                LOGGER.info("End Element: "+ qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                 if (name){
                     LOGGER.info("Name: "+new String(ch,start,length));
                     name=false;
                 }
                if (surname){
                    LOGGER.info("Surname: "+new String(ch,start,length));
                    surname=false;
                }
                if (birthDate){
                    LOGGER.info("Birth Date: "+new String(ch,start,length));
                    birthDate=false;
                }
                if (phone_number){
                    LOGGER.info("phone_number: "+new String(ch,start,length));
                    phone_number=false;
                }   if (email){
                    LOGGER.info("Email: "+new String(ch,start,length));
                    email=false;
                }
            }
        };


        SAXParserFactory saxParser = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParser.newSAXParser();
            parser.parse(new File("src\\main\\resources\\xmlfiles\\students.xml"),defaultHandler);


        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOGGER.error(ex);
        }
    }
}
