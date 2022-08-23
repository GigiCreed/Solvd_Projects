package solvd.projects.abstractclass.vechile;

import java.util.Objects;

public class Car extends Vechile {
    private double engineCapacity;
    private String fuelType;
    private String engineTransmission;
    private int wheels;

    public Car() {
        super.setType("Car");
        super.setYear(2005);
        engineTransmission = "Automatic";
        engineCapacity = 2.5;
        fuelType = "diesel";
        wheels = 4;
    }

    public Car(String type, int year, String fuelType, double engineCapacity, String engineTransmission, int wheels) {
        super(type, year);
        this.engineCapacity = engineCapacity;
        this.engineTransmission = engineTransmission;
        this.fuelType = fuelType;
        this.wheels = wheels;
    }

    public Car(String fuelType, double engineCapacity, String engineTransmission, int wheels) {
        this.engineCapacity = engineCapacity;
        this.engineTransmission = engineTransmission;
        this.fuelType = fuelType;
        this.wheels = wheels;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setEngineTransmission(String engineTransmission) {
        this.engineTransmission = engineTransmission;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public String getEngineTransmission() {
        return engineTransmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void isGoing(String firstStation, String secondStation) {
        LOGGER.info(super.getType() + " is moving From " + firstStation + ", to " + secondStation);
    }

    @Override
    public String toString() {
        return super.toString() + "\tEngineCapacity_" + getEngineCapacity() + "\tEngineTransmission_" + getEngineTransmission() + "\tFuelType_" + getFuelType() + "\tWheels_" + getWheels();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return wheels == car.wheels && Objects.equals(engineCapacity, car.engineCapacity) && Objects.equals(fuelType, car.fuelType) && Objects.equals(engineTransmission, car.engineTransmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineCapacity, fuelType, engineTransmission, wheels);
    }
}
