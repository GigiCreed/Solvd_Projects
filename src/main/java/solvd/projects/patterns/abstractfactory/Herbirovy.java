package solvd.projects.patterns.abstractfactory;

public class Herbirovy implements IAnimalType{
    @Override
    public void writeType() {
        LOGGER.info("Animal is Herbirovy");
    }
}
