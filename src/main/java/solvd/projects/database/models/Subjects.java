package solvd.projects.database.models;

public class Subjects {
    private Long id;
    private String name;
    private int course;
    private Long specialtiesId;

    public Subjects(){

    }

    public Subjects(Long id, String name, int course, Long specialtiesId) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.specialtiesId = specialtiesId;
    }

    public Subjects(String name, int course, Long specialtiesId) {
        this.name = name;
        this.course = course;
        this.specialtiesId = specialtiesId;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Long getSpecialtiesId() {
        return specialtiesId;
    }

    public void setSpecialtiesId(Long specialtiesId) {
        this.specialtiesId = specialtiesId;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", specialtiesId=" + specialtiesId +
                '}';
    }
}
