package solvd.projects.database.tableclasses;

public class Faculties {
    private Long id;
    private String name;
    private Long universitiesId;

    private Long deccansId;

    public Faculties(){

    }

    public Faculties(String name, Long universitiesId, Long deccansId) {
        this.name = name;
        this.universitiesId = universitiesId;
        this.deccansId = deccansId;
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

    public Long getUniversitiesId() {
        return universitiesId;
    }

    public void setUniversitiesId(Long universitiesId) {
        this.universitiesId = universitiesId;
    }

    public Long getDeccansId() {
        return deccansId;
    }

    public void setDeccansId(Long deccansId) {
        this.deccansId = deccansId;
    }

    @Override
    public String toString() {
        return "Faculties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universitiesId=" + universitiesId +
                ", deccansId=" + deccansId +
                '}';
    }
}
