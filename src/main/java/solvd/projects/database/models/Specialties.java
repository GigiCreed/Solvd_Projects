package solvd.projects.database.models;

public class Specialties {

    private Long id;
    private String name;
    private Long facultiesId;

    public Specialties(){

    }

    public Specialties(Long id, String name, Long facultiesId) {
        this.id = id;
        this.name = name;
        this.facultiesId = facultiesId;
    }

    public Specialties(String name, Long facultiesId) {
        this.name = name;
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

    public Long getFacultiesId() {
        return facultiesId;
    }

    public void setFacultiesId(Long facultiesId) {
        this.facultiesId = facultiesId;
    }

    @Override
    public String toString() {
        return "Specialities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultiesId=" + facultiesId +
                '}';
    }
}
