package solvd.projects.collections;

public class Triangle implements Comparable<Triangle> {
    private int a;
    private int b;
    private int c;

    public Triangle(){
        setABC(0,0,0);
    }

    public Triangle (int a,int b, int c){
        setABC(a,b,c);
    }

    public void setABC(int a,int b, int c){
        this.a=Math.abs(a);
        this.b=Math.abs(b);
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

    public int perimeter(){
        return a+b+c;
    }


    @Override
    public int compareTo(Triangle o) {
        return perimeter()-o.perimeter();

    }

    @Override
    public String toString() {
        return "P = "+perimeter();
    }
}