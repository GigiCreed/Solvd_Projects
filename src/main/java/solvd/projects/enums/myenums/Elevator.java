package solvd.projects.enums.myenums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Elevator {
    FIRST(1),SECOND(2),THIRD(3), FOURTH(4), FIFTH(5),SIXTH(6),
    SEVENTH(7), EIGHTH(8), NINTH(9);

    private static final Logger LOGGER = LogManager.getLogger(Elevator.class);
    private int florNumber;
    Elevator(int florNumber){
        this.florNumber=florNumber;
    }

    public int getFlor() {
        return florNumber;
    }

    public void choseFlor(){
        switch (florNumber){
            case 1:
                LOGGER.info("Elevator is moving to first flor");
                break;
            case 2:
                LOGGER.info("Elevator is moving to second flor");
                break;
            case 3:
                LOGGER.info("Elevator is moving to third flor");
                break;
            case 4:
                LOGGER.info("Elevator is moving to fourth flor");
                break;
            case 5:
                LOGGER.info("Elevator is moving to fifth flor");
                break;
            case 6:
                LOGGER.info("Elevator is moving to sixth flor");
                break;
            case 7:
                LOGGER.info("Elevator is moving to seventh flor");
                break;
            case 8:
                LOGGER.info("Elevator is moving to eight flor");
                break;
            case 9:
                LOGGER.info("Elevator is moving to ninth flor");

        }
    }

}
