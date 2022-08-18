package solvd.projects.enums.myenums;


public enum Garage {
    CAR1(TypeOfCar.SPORT_CAR,Manufacturers.LAMBORGHINI,Model.AVENTADOR,MaxSpeed.SUPERHIGH.getSpeed()),
    CAR2(TypeOfCar.SEDAN,Manufacturers.MERCEDES,Model.E63,MaxSpeed.HIGH.getSpeed()),
    CAR3(TypeOfCar.MINIVAN,Manufacturers.TOYOTA,Model.SIENNA,MaxSpeed.NORMAL.getSpeed());

     private final TypeOfCar type;
     private final Manufacturers manufacturers;
     private final Model model;
     private double maxSpeed;
     Garage(TypeOfCar type, Manufacturers manufacturers, Model model, double maxSpeed) {
        this.type = type;
        this.manufacturers = manufacturers;
        this.model = model;
        this.maxSpeed = maxSpeed ;
    }

    public String getType() {
        return String.valueOf(type);
    }

    public String getModel() {
        return String.valueOf(model);
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getManufacturers() {
        return String.valueOf(manufacturers);
    }
}
