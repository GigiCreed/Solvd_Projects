package solvd.projects.database.tableclasses;

import java.sql.Date;

public class Students {
    private Long id;
    private String name;
    private String surname;
    private Date age;
    private int phoneNumber;
    private int course;
    private String email;
    private Long universitiesId;
    private Long facultiesId;

    public Students(){

    }



    public Students(String name, String surname, Date age, int phoneNumber, int course, String email, Long universitiesId, Long facultiesId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.email = email;
        this.universitiesId = universitiesId;
        this.facultiesId = facultiesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUniversitiesId() {
        return universitiesId;
    }

    public void setUniversitiesId(Long universitiesId) {
        this.universitiesId = universitiesId;
    }

    public Long getFacultiesId() {
        return facultiesId;
    }

    public void setFacultiesId(Long facultiesId) {
        this.facultiesId = facultiesId;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number=" + phoneNumber +
                ", course=" + course +
                ", email='" + email + '\'' +
                ", universitiesId=" + universitiesId +
                ", facultiesId=" + facultiesId +
                '}';
    }
}