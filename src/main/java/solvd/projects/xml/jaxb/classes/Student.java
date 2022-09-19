package solvd.projects.xml.jaxb.classes;


import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement
@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute(name = "Id",required = true)
    private long id;

    @XmlElement(name = "Name",required = true)
    private String name;

    @XmlElement(name = "Surname",required = true)
    private String surname;

    @XmlElement(name = "Birth_date",required = true)
    private Date birthDate;

    @XmlElement(name = "Phone_number", required = true)
    private int phoneNumber;

    @XmlElement(name = "Course", required = true)
    private short course;

    @XmlElement(name = "Email",required = true)
    private String email;


    public Student(){

    }

    public Student(long id, String name, String surname, Date birthDate, int phoneNumber, short course, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "Student{" +"\n" +
                "id=" + id + "\n" +
                "name='" + name + "\n" +
                "surname='" + surname + "\n" +
                "birthDate=" + birthDate + "\n" +
                "phone_number=" + phoneNumber + "\n" +
                "course=" + course + "\n" +
                "email='" + email + "\n" +
                '}'+"\n" ;
    }
}
