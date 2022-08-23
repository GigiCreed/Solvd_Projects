package solvd.projects.abstractclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.abstractclass.vechile.*;

public class Main {
    private final static Logger LOGGER= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Bus b=new Bus();
        LOGGER.info(b);
        b.isGoing("batumi","tbilisi");
        System.out.println();

        Car c=new Car();
        LOGGER.info(c);
        c.isGoing("batumi","tbilisi");
        System.out.println();

        Train t=new Train();
        LOGGER.info(t);
        t.isGoing("batumi","tbilisi");
        System.out.println();

        Plane p=new Plane();
        LOGGER.info(p);
        p.isGoing("batumi","tbilisi");
        System.out.println();

        MotoBike m=new MotoBike();
        LOGGER.info(m);
        m.isGoing("batumi","tbilisi");
        System.out.println();

        Bike bi=new Bike();
        LOGGER.info(bi);
        bi.isGoing("batumi","tbilisi");
        System.out.println();
    }
}

