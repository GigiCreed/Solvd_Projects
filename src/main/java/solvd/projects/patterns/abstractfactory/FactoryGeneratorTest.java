package solvd.projects.patterns.abstractfactory;

public class FactoryGeneratorTest {
    public static void main(String[] args) {
        AbstractFactory animalFactory = FactoryGenerator.getFactory("Animal");
        IAnimal cat = animalFactory.getAnimal("Cat");
        cat.writeAnimal();

        AbstractFactory animalTypeFactory = FactoryGenerator.getFactory("AnimalType");
        IAnimalType predator = animalTypeFactory.getAnimalType("Predator");
        predator.writeType();
    }
}
