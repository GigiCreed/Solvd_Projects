package solvd.projects.database.models;


public class Universities {
    private Long id;
    private String name;
    private String address;
    private String siteAddress;
    private String email;


    public Universities(){

    }

    public Universities(Long id, String name, String address, String siteAddress, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.siteAddress = siteAddress;
        this.email = email;
    }

    public Universities(String name, String address, String siteAddress, String email) {
        this.name = name;
        this.address = address;
        this.siteAddress = siteAddress;
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

    @Override
    public String toString() {
        return "Universities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
