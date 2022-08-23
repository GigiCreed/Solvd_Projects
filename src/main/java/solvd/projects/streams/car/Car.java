package solvd.projects.streams.car;

public class Car {
    private Type type;
    private String Manufacture;
    private String Model;
    private int year;
    private double engineCapacity;
    private Transmission transmission;
    private FuelType fuelTypel;

    public Car(Type type, String manufacture, String model, int year, double engineCapacity, Transmission transmission, FuelType fuelTypel) {
        this.type = type;
        Manufacture = manufacture;
        Model = model;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.transmission = transmission;
        this.fuelTypel = fuelTypel;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getManufacture() {
        return Manufacture;
    }

    public void setManufacture(String manufacture) {
        Manufacture = manufacture;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelTypel() {
        return fuelTypel;
    }

    public void setFuelTypel(FuelType fuelTypel) {
        this.fuelTypel = fuelTypel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type=" + type +
                ", Manufacture='" + Manufacture + '\'' +
                ", Model='" + Model + '\'' +
                ", year=" + year +
                ", engineCapacity=" + engineCapacity +
                ", transmission=" + transmission +
                ", fuelTypel=" + fuelTypel +
                '}';
    }
}
