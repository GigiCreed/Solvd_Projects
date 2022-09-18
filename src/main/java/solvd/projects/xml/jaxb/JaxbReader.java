package solvd.projects.xml.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.xml.jaxb.classes.Students;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbReader {
    private static final Logger LOGGER = LogManager.getLogger(JaxbReader.class);
    public static void main(String[] args) {
         try {
             JAXBContext context = JAXBContext.newInstance(Students.class);
             Unmarshaller unmarshaller = context.createUnmarshaller();

             FileReader studentJaxb = new FileReader("D:\\Java Projects\\Solvd_Projects\\src\\main\\resources\\xmlfiles\\studentsJaxb.xml");
             Students students = (Students) unmarshaller.unmarshal(studentJaxb);
             LOGGER.info(students);
         }catch (JAXBException | FileNotFoundException ex){
             LOGGER.error(ex);
         }

        }
    }

