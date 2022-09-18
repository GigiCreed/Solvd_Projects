package solvd.projects.xml.jaxb.classes;



import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@XmlRootElement
@XmlType(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class Students {
    @XmlElement(name ="student")

    private ArrayList<Student> studentList = new ArrayList<Student>();

    public Students() {  }


    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    public boolean addStudent(Student student) {
        return studentList.add(student);
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentList=" + studentList +
                '}';
    }
}
