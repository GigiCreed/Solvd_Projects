package solvd.projects.interfacess;
import org.apache.logging.log4j.LogManager;
import solvd.projects.interfacess.classess.*;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Triangle T = new Triangle(4, 3, 6);
        LOGGER.info("\n"+T);

//        Circle c=new Circle(4);
//        LOGGER.info(c);
//        System.out.println();
//
//        QuadraticEqu q=new QuadraticEqu(14,2,14);
//        LOGGER.info(q);
//        System.out.println();
//
//        ArithmeticPro a=new ArithmeticPro(3,5,5);
//        LOGGER.info(a);
//        System.out.println();
//
//        GeometricProg g=new GeometricProg(3,6,4);
//        LOGGER.info(g);
//        System.out.println();
//    }
    }
}
