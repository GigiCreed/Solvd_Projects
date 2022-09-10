package solvd.projects.database.tableclasses;

import java.sql.Date;

public class ViceRectors {
    private Long id;
    private String name;
    private String surname;
    private Date age;
    private int phone_number;
    private String address;
    private String email;

    public ViceRectors(){

    }

    public ViceRectors(String name, String surname, Date age, int phone_number, String address, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
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

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
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

    @Override
    public String toString() {
        return "Rectors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number=" + phone_number +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

