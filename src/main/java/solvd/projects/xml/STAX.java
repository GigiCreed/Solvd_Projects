package solvd.projects.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class STAX {
    private static final Logger LOGGER = LogManager.getLogger(STAX.class);
    public static void main(String[] args){

        try {
          XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("src\\main\\resources\\xmlfiles\\students.xml"));
          while (xmlStreamReader.hasNext()){
              xmlStreamReader.next();
              if (xmlStreamReader.isStartElement()){
                  LOGGER.info("Start Element: "+xmlStreamReader.getLocalName());
              }else if (xmlStreamReader.isEndElement()){
                  LOGGER.info("End Element: " + xmlStreamReader.getLocalName());
              } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length()>0) {
                LOGGER.info(xmlStreamReader.getText());
              }
          }
      }catch (FileNotFoundException | XMLStreamException ex){
          LOGGER.error(ex);
      }


    }
}
