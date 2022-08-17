package solvd.projects.abstractclass.vechile;

import java.util.Objects;

public class Plane extends Vechile {
    private int flyTime;

    public Plane(){
        super.setType("Plane");
        super.setYear(2020);
        flyTime=3;
    }
    public Plane(String type,int year,int flyTime){
        super(type,year);
        this.flyTime=flyTime;
    }
    public Plane(int flyTime){
        this.flyTime=flyTime;
    }
    public void setFlyTime(int flyTime){
        this.flyTime=flyTime;
    }
    public int getFlyTime() {
        return flyTime;
    }
    @Override
    public void isGoing(String firstStation, String secondStation) {
        logger.info(super.getType()+" is flew away from "+firstStation+" to "+secondStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return flyTime == plane.flyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flyTime);
    }

    @Override
    public String toString(){
        return super.toString()+"\tFlyTime_"+getFlyTime()+"h";
    }
}
