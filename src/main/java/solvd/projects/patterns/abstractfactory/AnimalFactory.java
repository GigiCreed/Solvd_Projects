package solvd.projects.patterns.abstractfactory;

public class AnimalFactory extends AbstractFactory{
    @Override
    IAnimal getAnimal(String animal) {
        return switch (animal) {
            case "Cat" -> new Cat();
            case "Dog" -> new Dog();
            default -> null;
        };
    }

    @Override
    IAnimalType getAnimalType(String type) {
        return null;
    }
}
