package solvd.projects.json.classes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Students {

   private String name;

   @JsonProperty("second_name")
   private String secondName;

   @JsonProperty("birth_date")
   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
   private Date birthDate;

   @JsonProperty("phone_number")
   private int phoneNumber;


   private int course;

   Students(){

   }

   public Students(String name, String secondName, Date birthDate, int phoneNumber, int course) {
      this.name = name;
      this.secondName = secondName;
      this.birthDate = birthDate;
      this.phoneNumber = phoneNumber;
      this.course = course;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSecondName() {
      return secondName;
   }

   public void setSecondName(String secondName) {
      this.secondName = secondName;
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

   public int getCourse() {
      return course;
   }

   public void setCourse(int course) {
      this.course = course;
   }

   @Override
   public String toString() {
      return "Students{" +
              "name='" + name + '\'' +
              ", secondName='" + secondName + '\'' +
              ", birthDate=" + birthDate +
              ", phoneNumber=" + phoneNumber +
              ", course=" + course +
              '}';
   }
}
