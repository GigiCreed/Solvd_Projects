package solvd.projects.patterns.factory;

public class Bus implements IVechile {
    @Override
    public void writeType() {
        LOGGER.info("Vechile type is Bus");
    }
}
