package solvd.projects.patterns.abstractfactory;

public class Dog implements IAnimal{
    @Override
    public void writeAnimal() {
        LOGGER.info("Animal is dog");
    }
}
