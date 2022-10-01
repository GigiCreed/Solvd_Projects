package solvd.projects.patterns.abstractfactory;

public class Cat implements IAnimal {
    @Override
    public void writeAnimal() {
        LOGGER.info("Animal is Cat");
    }
}
