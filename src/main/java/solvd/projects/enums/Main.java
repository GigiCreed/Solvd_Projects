package solvd.projects.enums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.enums.myenums.*;

public class Main {
    private static final Logger LOGGER= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Animal a = Animal.CAT;
        LOGGER.info(a);
        a.choseAnimal();
        for (Object o:Animal.values()) {
            System.out.println(o);
        }


//        System.out.println("\n");
//
//        Elevator e = Elevator.EIGHTH;
//        e.choseFlor();
//        LOGGER.info(e);
//        for (Object o:Elevator.values()) {
//            System.out.println(o);
//        }

//        System.out.println("\n");
//
//        Menu m = Menu.COPY;
//        m.tapButton();
//        LOGGER.info(m);
//        for (Object o: Menu.values()) {
//            System.out.println(o);
//        }

//        System.out.println("\n");
//
//        Transmission t = Transmission.FOURTH;
//        t.turnStage();
//        LOGGER.info(t);
//        for (Object o:Transmission.values()) {
//            System.out.println(o);
//        }

//        System.out.println("\n");
//
//
//        Point p = Point.A;
//        p.sumExamPoints();
//        LOGGER.info(p);
//        for (Object o:Point.values()) {
//            System.out.println(o);
//        }



    }
}
