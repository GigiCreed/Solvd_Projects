package solvd.projects.database.models;

import java.sql.Date;

public class Lectors {
    private Long id;
    private String name;
    private String surname;
    private Date age;
    private int phoneNumber;
    private String address;
    private String email;
    private Long universitiesId;

    public Lectors(){

    }

    public Lectors(Long id, String name, String surname, Date age, int phoneNumber, String address, String email, Long universitiesId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.universitiesId = universitiesId;
    }

    public Lectors(String name, String surname, Date age, int phoneNumber, String address, String email, Long universitiesId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.universitiesId = universitiesId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Lectors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number=" + phoneNumber +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", universitiesId=" + universitiesId +
                '}';
    }
}
