package solvd.projects.patterns.factory;

public class VechileFactoryTest {
    public static void main(String[] args) {
        VechileFactory vechileFactory = new VechileFactory();

        IVechile car = vechileFactory.getVechile("Car");
        car.writeType();

        IVechile bus = vechileFactory.getVechile("Bus");
        bus.writeType();

        IVechile motoBike = vechileFactory.getVechile("MotoBike");
        motoBike.writeType();
    }
}
