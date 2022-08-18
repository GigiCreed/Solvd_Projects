package solvd.projects.enums.myenums;

public enum Manufacturers {
    LAMBORGHINI("Lamborghini"),MERCEDES("Mercedes"),TOYOTA("Toyota");
    private String manufacturers;
    Manufacturers(String manufacturers){
        this.manufacturers=manufacturers;
    }

    public String getManufacturers() {
        return String.valueOf(manufacturers);
    }
}
