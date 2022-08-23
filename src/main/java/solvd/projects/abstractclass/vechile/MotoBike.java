package solvd.projects.abstractclass.vechile;

public class MotoBike extends Vechile {
    private int seat;
    private double engineCapacity;

    public MotoBike() {
        super.setType("MotoBike");
        super.setYear(2005);
        seat = 2;
        engineCapacity = 0.5;
    }

    public MotoBike(String type, int year, int seat, double engineCapacity) {
        super(type, year);
        this.seat = seat;
        this.engineCapacity = engineCapacity;
    }

    public MotoBike(int seat, double engineCapacity) {
        this.engineCapacity = engineCapacity;
        this.seat = seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getSeat() {
        return seat;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public void isGoing(String firstStation, String secondStation) {
        LOGGER.info(super.getType() + " is moving from " + firstStation + " to " + secondStation);
    }
}
