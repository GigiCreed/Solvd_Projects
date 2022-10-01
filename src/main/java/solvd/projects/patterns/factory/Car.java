package solvd.projects.patterns.factory;

public class Car implements IVechile {
    @Override
    public void writeType() {
        LOGGER.info("Vechile type is Car");
    }
}
