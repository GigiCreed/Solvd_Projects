package solvd.projects.abstractclass.vechile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Vechile {
    Logger LOGGER = LogManager.getLogger(Vechile.class);
    private String type;
    private int year;

    public Vechile() {

    }

    public Vechile(String type, int year) {
        this.type = type;
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public abstract void isGoing(String firstStation, String secondStation);

    @Override
    public String toString() {
        return "Type_" + getType() + "\tYear_" + getYear();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vechile vechile = (Vechile) o;
        return year == vechile.year && Objects.equals(type, vechile.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, year);
    }
}