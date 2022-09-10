package solvd.projects.database.tableclasses;


public class Universities {
    private Long id;
    private String name;
    private String address;
    private String siteAddress;
    private String email;
    private Long rectorsId;
    private Long viceRectorsId;

    public Universities(){

    }

    public Universities(String name, String address, String siteAddress, String email, Long rectorsId, Long viceRectorsId) {
        this.name = name;
        this.address = address;
        this.siteAddress = siteAddress;
        this.email = email;
        this.rectorsId = rectorsId;
        this.viceRectorsId = viceRectorsId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRectorsId() {
        return rectorsId;
    }

    public void setRectorsId(Long rectorsId) {
        this.rectorsId = rectorsId;
    }

    public Long getViceRectorsId() {
        return viceRectorsId;
    }

    public void setViceRectorsId(Long viceRectorsId) {
        this.viceRectorsId = viceRectorsId;
    }

    @Override
    public String toString() {
        return "Universities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", email='" + email + '\'' +
                ", rectorsId=" + rectorsId +
                ", viceRectorsId=" + viceRectorsId +
                '}';
    }
}
