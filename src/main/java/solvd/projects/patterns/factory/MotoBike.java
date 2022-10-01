package solvd.projects.patterns.factory;

import solvd.projects.patterns.factory.IVechile;

public class MotoBike implements IVechile {
    @Override
    public void writeType() {
        LOGGER.info("Vechile is type MotoBike");
    }
}
