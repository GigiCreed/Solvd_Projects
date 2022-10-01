package solvd.projects.patterns.abstractfactory;

public class Predator implements IAnimalType{
    @Override
    public void writeType() {
        LOGGER.info("Animal is Predator");
    }
}
