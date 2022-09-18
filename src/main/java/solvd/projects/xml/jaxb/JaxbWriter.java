package solvd.projects.xml.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.xml.jaxb.classes.Student;
import solvd.projects.xml.jaxb.classes.Students;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

import java.util.Date;

public class JaxbWriter {
    private final static Logger LOGGER = LogManager.getLogger(JaxbWriter.class);
    public static void main(String[] args) throws JAXBException, IOException {


            JAXBContext context = JAXBContext.newInstance(Students.class);

            Marshaller m =context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Students students = new Students(){
                {

                    Student student = new Student(5L,"Tinatin","rodinadze",new Date(10140768000000L),55, (short) 3,"tinati@gmail.com");
                    this.addStudent(student);

                    Student student2 = new Student(6L,"Gigi","Mamaladze",new Date(10140768000000L),55, (short) 3,"Gigi@gmail.com");
                    this.addStudent(student2);

                }
            };
            m.marshal(students,new File("src\\main\\resources\\xmlfiles\\studentsJaxb.xml"));
            LOGGER.info("Object is written on Xml");

    }
}
