package solvd.projects.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.enums.myenums.*;

public class Main {
    private static final Logger LOGGER= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Garage g =Garage.CAR1;
        LOGGER.info("Type "+g.getType());
        LOGGER.info("Manufacturers "+g.getManufacturers());
        LOGGER.info("Model "+g.getModel());
        LOGGER.info("Max Speed "+g.getMaxSpeed()+"km");



    }
}
