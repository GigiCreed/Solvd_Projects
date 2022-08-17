package solvd.projects.enums.myenums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Point {
    A(100),B(90),C(80),D(70),E(60),FX(50),F(40);
    private static final Logger LOGGER = LogManager.getLogger(Point.class);
    private int point;
    Point(int point){
        this.point=point;
    }

    public int getPoint() {
        return point;
    }

    public void sumExamPoints(){
        switch (point){
            case 100:
                LOGGER.info("You pass exam on A");
                break;
            case 90:
                LOGGER.info("You pass exam on B");
                break;
            case 80:
                LOGGER.info("You pass exam on C");
                break;
            case 70:
                LOGGER.info("You pass exam on D");
                break;
            case 60:
                LOGGER.info("You pass exam on E");
                break;
            case 50:
                LOGGER.info("You have one more chance to write exam again");
                break;
            case 40:
                LOGGER.info("You failed on exam");
        }
    }
}
