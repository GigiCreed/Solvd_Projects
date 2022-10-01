package solvd.projects.patterns.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IAnimal {
    static final Logger LOGGER = LogManager.getLogger(IAnimal.class);
    void writeAnimal();
}
