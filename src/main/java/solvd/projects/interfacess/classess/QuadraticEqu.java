package solvd.projects.interfacess.classess;
import solvd.projects.interfacess.myinterfacess.IQEquation;
public class QuadraticEqu implements IQEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEqu(){
        this.a=0;
        this.b=0;
        this.c=0;
    }
    public QuadraticEqu(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public void setA(double a){
        this.a=a;
    }
    public void setB(double b){
        this.b=b;
    }
    public void setC(double c){
        this.c=c;
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
    public double findDiscriminating() {
        return (b*b)-(4*a*c);
    }

    @Override
    public double findFirstRoot()  {

        return -b+Math.sqrt(findDiscriminating())/(2*a);
    }

    @Override
    public double findSecondRoot()  {

        return -b-Math.sqrt(findDiscriminating())/(2*a);
    }

    public String toString(){

        return "a = "+getA()+"\nb = "+getB()+"\nc = "+getC()+"\nD = "+ findDiscriminating()+"\nX1 = "+ findFirstRoot()+"\t\tX2 = "+ findSecondRoot();
    }
}
