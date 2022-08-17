package solvd.projects.enums.myenums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Menu {
    HOME("Home"),HELP("Help"),COPY("Copy"),PASTE("Paste");

    private static final Logger LOGGER = LogManager.getLogger(Menu.class);
    private String button;
    Menu(String button){
        this.button=button;
    }

    public String getButton() {
        return button;
    }

    public void tapButton(){
        switch (button){
            case "Home":
                LOGGER.info("Opened default application window");
                break;
            case "Copy":
                LOGGER.info("Copied text");
                break;
            case "Help":
                LOGGER.info("Opened instruction");
                break;
            case "Paste":
                LOGGER.info("Pasted text");
        }
    }

}
