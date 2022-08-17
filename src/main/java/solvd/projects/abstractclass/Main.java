package solvd.projects.abstractclass;

import solvd.projects.abstractclass.vechile.*;

public class Main {
    public static void main(String[] args) {
        Bus b=new Bus();
        System.out.println(b);
        b.isGoing("batumi","tbilisi");
        System.out.println();

        Car c=new Car();
        System.out.println(c);
        c.isGoing("batumi","tbilisi");
        System.out.println();

        Train t=new Train();
        System.out.println(t);
        t.isGoing("batumi","tbilisi");
        System.out.println();

        Plane p=new Plane();
        System.out.println(p);
        p.isGoing("batumi","tbilisi");
        System.out.println();

        MotoBike m=new MotoBike();
        System.out.println(m);
        m.isGoing("batumi","tbilisi");
        System.out.println();

        Bike bi=new Bike();
        System.out.println(bi);
        bi.isGoing("batumi","tbilisi");
        System.out.println();
    }
}

