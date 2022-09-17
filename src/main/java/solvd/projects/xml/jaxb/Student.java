package solvd.projects.xml.jaxb;


import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student",propOrder = {
        "name",
        "surname",
        "birthDate",
        "phone_number",
        "course",
        "email"
})
public class Student {
    @XmlAttribute(required = true)
    private long id;

    @XmlElement(required = true)
    private String name;

    @XmlElement(required = true)
    private String surname;

    @XmlElement(required = true)
    private Date birthDate;

    @XmlElement(required = true)
    private short course;

    @XmlElement(required = true)
    private String email;

    public Student(){

    }

    public Student(long id, String name, String surname, Date birthDate, short course, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.course = course;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public short getCourse() {
        return course;
    }

    public void setCourse(short course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", course=" + course +
                ", email='" + email + '\'' +
                '}';
    }
}
