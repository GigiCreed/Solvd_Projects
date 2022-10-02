package solvd.projects.patterns.builder;

public class Teacher {
    String name;
    String secondName;
    short age;
    int phoneNumber;


    public static Builder builder(){
        return new Teacher().new Builder();
    }
    public class Builder{
       private Builder(){

        }
       public Builder withName(String name){
           Teacher.this.name =name;
           return this;
       }

        public Builder withSecondName(String secondName){
            Teacher.this.secondName =secondName;
            return this;
        }
        public Builder withAge(short age){
            Teacher.this.age =age;
            return this;
        }
        public Builder withPhoneNumber(int phoneNumber){
            Teacher.this.phoneNumber =phoneNumber;
            return this;
        }
        public Teacher build(){
           return Teacher.this;
        }


    }
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

}
