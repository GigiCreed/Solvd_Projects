package solvd.projects.patterns.factory;

public class VechileFactory {

    public IVechile getVechile(String type){
        return switch (type) {
            case "Car" -> new Car();
            case "Bus" -> new Bus();
            case "MotoBike" -> new MotoBike();
            default -> null;
        };
    }
}
