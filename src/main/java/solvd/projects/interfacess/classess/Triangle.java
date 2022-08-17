package solvd.projects.interfacess.classess;
import solvd.projects.interfacess.myinterfacess.ITriangle;
public class Triangle implements ITriangle {
    private double a;
    private double b;
    private double c;

    public Triangle(){
        this.a=0;
        this.b=0;
        this.c=0;
    }
    public Triangle(double a,double b,double c){
        this.a=Math.abs(a);
        this.b=Math.abs(b);
        this.c=Math.abs(c);
    }

    public void setA(double a){
        this.a=Math.abs(a);
    }

    public void setB(double b){
        this.b=Math.abs(b);
    }

    public void setC(double c){
        this.c=Math.abs(c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double findPerimeter() {
        return a+b+c;
    }

    @Override
    public double findArea() {
        double p= findPerimeter()/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public String toString(){
        return "a = "+getA()+"\nb = "+getB()+"\nc = "+getC()+"\nP = "+ findPerimeter()+"\tS = "+ findArea();
    }
}
