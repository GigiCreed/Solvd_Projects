package solvd.projects.enums.myenums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public enum Animal {
    DOG("Dog"),CAT("Cat"),FROG("Frog");

    private static final Logger LOGGER = LogManager.getLogger(Animal.class);
    private String animalIntoZoo;


    Animal(String animalIntoZoo){
        this.animalIntoZoo=animalIntoZoo;
    }

    Animal() {

    }

    public String getAnimalIntoZoo() {
        return animalIntoZoo;
    }

    public void choseAnimal(){
        switch (animalIntoZoo){
            case "Dog":
                LOGGER.info("You chose to buy Dog");
                break;
            case "Cat":
                LOGGER.info("You chose to buy Cat");
                break;
            case "Frog":
                LOGGER.info("You chose to buy Frog");
                break;
            default:
                LOGGER.error("nope");
        }
    }

}
