package solvd.projects.patterns.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IVechile {
    static final Logger LOGGER = LogManager.getLogger(IVechile.class);
    void writeType();
}
