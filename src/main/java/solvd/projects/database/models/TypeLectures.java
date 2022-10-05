package solvd.projects.database.models;


public class TypeLectures {
    private Long id;
    private String type;
    private Long lectorsId;
    private Long subjectsId;

    public TypeLectures(){

    }

    public TypeLectures(Long id, String type, Long lectorsId, Long subjectsId) {
        this.id = id;
        this.type = type;
        this.lectorsId = lectorsId;
        this.subjectsId = subjectsId;
    }

    public TypeLectures(String type, Long lectorsId, Long subjectsId) {
        this.type = type;
        this.lectorsId = lectorsId;
        this.subjectsId = subjectsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLectorsId() {
        return lectorsId;
    }

    public void setLectorsId(Long lectorsId) {
        this.lectorsId = lectorsId;
    }

    public Long getSubjectsId() {
        return subjectsId;
    }

    public void setSubjectsId(Long subjectsId) {
        this.subjectsId = subjectsId;
    }

    @Override
    public String toString() {
        return "TypeLectures{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", lectorsId=" + lectorsId +
                ", subjectsId=" + subjectsId +
                '}';
    }
}
