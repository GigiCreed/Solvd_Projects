package solvd.projects.enums.myenums;

public enum MaxSpeed {
     NORMAL(180.0), HIGH(289.8), SUPERHIGH(350);
    private double speed;
    MaxSpeed(double speed){
        this.speed=speed;
    }

    public double getSpeed() {
        return speed;
    }
}
