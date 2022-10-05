package solvd.projects.database.models;

public class TypeSpecialties {
    private Long id;
    private String Type;
    private Long specialtiesId;
    private Long studentsId;

    public TypeSpecialties(){

    }

    public TypeSpecialties(Long id, String type, Long specialtiesId, Long studentsId) {
        this.id = id;
        Type = type;
        this.specialtiesId = specialtiesId;
        this.studentsId = studentsId;
    }

    public TypeSpecialties(String type, Long specialtiesId, Long studentsId) {
        Type = type;
        this.specialtiesId = specialtiesId;
        this.studentsId = studentsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Long getSpecialtiesId() {
        return specialtiesId;
    }

    public void setSpecialtiesId(Long specialtiesId) {
        this.specialtiesId = specialtiesId;
    }

    public Long getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Long studentsId) {
        this.studentsId = studentsId;
    }

    @Override
    public String toString() {
        return "TypeSpecialties{" +
                "id=" + id +
                ", TypeName='" + Type + '\'' +
                ", specialtiesId=" + specialtiesId +
                ", studentsId=" + studentsId +
                '}';
    }
}
