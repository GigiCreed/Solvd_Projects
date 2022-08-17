package solvd.projects.abstractclass.vechile;

import java.util.Objects;

public class Bus extends Vechile{
    private int busNumber;
    private int seatInBus;

    public Bus(){
        super.setType("Bus");
        super.setYear(2015);
        busNumber=1;
        seatInBus=10;
    }
    public Bus(String type,int year,int busNumber,int seatInBus){
        super(type,year);
        this.busNumber=busNumber;
        this.seatInBus=seatInBus;
    }
    public Bus(int busNumber,int seatInBus){
        this.busNumber=busNumber;
        this.seatInBus=seatInBus;
    }
    public void setBusNumber(int busNumber){
        this.busNumber=busNumber;
    }

    public void setSeatInBus(int seatInBus){
        this.seatInBus=seatInBus;
    }

    public int getSeatInBus() {
        return seatInBus;
    }

    public int getBusNumber() {
        return busNumber;
    }

    @Override
    public void isGoing(String firstStation, String secondStation) {
        logger.info(super.getType()+" Number "+busNumber+" is moving from "+firstStation+" to "+secondStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return busNumber == bus.busNumber && seatInBus == bus.seatInBus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busNumber, seatInBus);
    }

    @Override
    public String toString(){
        return super.toString()+"\tBus Number_"+getBusNumber()+"\tSeatInBus_"+getSeatInBus();
    }
}
