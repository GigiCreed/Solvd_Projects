package solvd.projects.patterns.abstractfactory;

public abstract class AbstractFactory {
    abstract IAnimal getAnimal(String animal);
    abstract IAnimalType getAnimalType(String type);
}
