package solvd.projects.interfacess.classess;
import solvd.projects.interfacess.myinterfacess.ICircle;
public class Circle implements ICircle {
    private double radius;

    public Circle(){
        this.radius =0;
    }
    public Circle(double radius){
        this.radius =Math.abs(radius);
    }

    public void setRadius(double radius){
        this.radius =Math.abs(radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double writeArea() {
        return M_PI* radius * radius;
    }

    @Override
    public double writePerimeter() {
        return 2*M_PI* radius;
    }

    @Override
    public double writeDiagonal() {
        return radius + radius;
    }

    public String toString(){
        return "R = "+ getRadius()+"\nS = "+ writeArea()+"\tP = "+writePerimeter()+"\tD = "+ writeDiagonal();
    }
}
