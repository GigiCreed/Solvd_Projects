package solvd.projects.patterns.abstractfactory;

public class AnimalTypeFactory extends AbstractFactory{
    @Override
    IAnimal getAnimal(String animal) {
        return null;
    }

    @Override
    IAnimalType getAnimalType(String type) {
        return switch (type) {
            case "Predator" -> new Predator();
            case "Herbirovy" -> new Herbirovy();
            default -> null;
        };
    }
}
