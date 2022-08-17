package solvd.projects.enums.myenums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Transmission {
    FIRST("First"),SECOND("Second"),FOURTH("Fourth"),FIFTH("Fifth"),SIXTH("Sixth"),REVERSE("Reverse");

    private static final Logger LOGGER= LogManager.getLogger(Transmission.class);
    private String stage;

    Transmission(String stage){
        this.stage=stage;
    }

    public String getStage() {
        return stage;
    }

    public void turnStage(){
        switch (stage) {
            case "First":
                LOGGER.info("Car is moving on First Stage");
                break;
            case "Second":
                LOGGER.info("Car is moving on Second Stage");
                break;
            case "Third":
                LOGGER.info("Car is moving on Third Stage");
                break;
            case "Fourth":
                LOGGER.info("Car is moving on Fourth Stage");
                break;
            case "Fifth":
                LOGGER.info("Car is moving on Fifth Stage");
                break;
            case "Sixth":
                LOGGER.info("Car is moving on Sixth Stage");
                break;
            case "Reverse":
                LOGGER.info("Car moving reverse");
        }
    }
}
