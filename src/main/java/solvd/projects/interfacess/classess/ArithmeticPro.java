package solvd.projects.interfacess.classess;
import  solvd.projects.interfacess.myinterfacess.IAProgression;
public class ArithmeticPro implements IAProgression {
    private double firstTerm;
    private double secondTerm;
    private double numberOfTerms;

    public ArithmeticPro(){
        this.firstTerm =0;
        this.secondTerm =1;
        this.numberOfTerms =1;
    }
    public ArithmeticPro(double a1,double a2,double n){
        this.firstTerm =a1;
        this.secondTerm =a2;
        this.numberOfTerms =Math.abs(n);
    }
    public void setFirstTerm(double firstTerm){
        this.firstTerm = firstTerm;
    }
    public void setSecondTerm(double secondTerm){
        this.secondTerm = secondTerm;
    }
    public void setNumberOfTerms(double numberOfTerms){
        this.numberOfTerms =Math.abs(numberOfTerms);
    }

    public double getSecondTerm() {
        return secondTerm;
    }

    public double getFirstTerm() {
        return firstTerm;
    }

    public double getNumberOfTerms() {
        return numberOfTerms;
    }

    @Override
    public double doCommonDifferance() {
        return secondTerm - firstTerm;
    }

    @Override
    public double doNumberOfTermsSequence() {
        return firstTerm +(numberOfTerms -1)*doCommonDifferance();
    }

    @Override
    public double sumOfTerms(){
        return (numberOfTerms /2)*(2* firstTerm +(numberOfTerms -1)*doCommonDifferance());
    }

    public String toString(){
        return "a1 = "+ getFirstTerm()+"\na2  = "+ getSecondTerm()+"\nn = "+ getNumberOfTerms()+"\nd = "+doCommonDifferance()+"\nan = "+ doNumberOfTermsSequence()+"\nSn = "+ sumOfTerms();
    }

}