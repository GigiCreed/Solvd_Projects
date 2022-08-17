package solvd.projects.abstractclass.vechile;


import java.util.Objects;

public final class Bike extends Vechile {
    private final int wheels=2;
    private int seat;

    public Bike(){
        super.setType("Bike");
        super.setYear(2015);
        seat=2;
    }
    public Bike(String type,int year,int seat){
        super(type,year);
        this.seat=seat;
    }

    public Bike(int seat){
        this.seat=seat;
    }

    public void setSeat(int seat){
        this.seat=seat;
    }

    public int getSeat() {
        return seat;
    }


    @Override
    public void isGoing(String firstStation, String secondStation) {
        logger.info(super.getType()+" is going From "+firstStation+" to "+secondStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return wheels == bike.wheels && seat == bike.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wheels, seat);
    }

    @Override
    public String toString(){
        return super.toString()+"\twheels_"+wheels+"\tseat_"+getSeat();
    }


}
