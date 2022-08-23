package solvd.projects.abstractclass.vechile;

import java.util.Objects;

public class Train extends Vechile {
    private int wagons;
    private int travelTime;

    public Train(){
        super.setType("Train");
        super.setYear(2019);
        wagons=7;
        travelTime=5;
    }

    public Train(String type,int year,int wagons,int travelTime){
        super(type,year);
        this.wagons=wagons;
        this.travelTime=travelTime;
    }

    public Train(int wagons,int travelTime){
        this.wagons=wagons;
        this.travelTime=travelTime;
    }

    public void setWagons(int wagons){
        this.wagons=wagons;
    }
    public void setTravelTime(int travelTime){
        this.travelTime=travelTime;
    }

    public int getWagons() {
        return wagons;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public void isGoing(String firstStation, String secondStation) {
        LOGGER.info(super.getType()+" is going From "+firstStation+" to "+secondStation);
    }

    @Override
    public String toString(){
        return super.toString()+"\tWagons_"+getWagons()+"\tTravelTime_"+getTravelTime()+"h";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return wagons == train.wagons && travelTime == train.travelTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wagons, travelTime);
    }
}
