package solvd.projects.patterns.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IAnimalType {
    static final Logger LOGGER = LogManager.getLogger(IAnimalType.class);
    void writeType();
}
