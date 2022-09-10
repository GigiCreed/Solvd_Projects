package solvd.projects.database.tableclasses;

public class TypeSpecialties {
    private Long id;
    private String TypeName;
    private Long specialtiesId;
    private Long studentsId;

    public TypeSpecialties(){

    }

    public TypeSpecialties(String typeName, Long specialtiesId, Long studentsId) {
        TypeName = typeName;
        this.specialtiesId = specialtiesId;
        this.studentsId = studentsId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
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
                ", TypeName='" + TypeName + '\'' +
                ", specialtiesId=" + specialtiesId +
                ", studentsId=" + studentsId +
                '}';
    }
}
