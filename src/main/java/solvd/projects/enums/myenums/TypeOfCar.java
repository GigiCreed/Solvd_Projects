package solvd.projects.enums.myenums;

public enum TypeOfCar {
    SEDAN("Sedan"), SPORT_CAR("Sport Car"), MINIVAN("Minivan");
    private String type;
    TypeOfCar(String type) {
        this.type=type;
    }

    public String getType() {
        return String.valueOf(type);
    }
}
