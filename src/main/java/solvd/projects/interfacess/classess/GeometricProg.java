package solvd.projects.interfacess.classess;
import solvd.projects.interfacess.myinterfacess.IGProgression;
public class GeometricProg implements IGProgression {
    private double firstGeometricTerm;
    private double secondGeometricTerm;
    private double numberGeometricTerms;

    public GeometricProg() {
        this.firstGeometricTerm = 0;
        this.secondGeometricTerm = 1;
        this.numberGeometricTerms = 1;
    }

    public GeometricProg(double firstGeometricTerm, double secondGeometricTerm, double numberGeometricTerms) {
        this.firstGeometricTerm = firstGeometricTerm;
        this.secondGeometricTerm = secondGeometricTerm;
        this.numberGeometricTerms = Math.abs(numberGeometricTerms);
    }

    public void setFirstGeometricTerm(double firstGeometricTerm) {
        this.firstGeometricTerm = firstGeometricTerm;
    }

    public void setSecondGeometricTerm(double secondGeometricTerm) {
        this.secondGeometricTerm = secondGeometricTerm;
    }

    public void setNumberGeometricTerms(double numberGeometricTerms) {
        this.numberGeometricTerms = Math.abs(numberGeometricTerms);
    }

    public double getNumberGeometricTerms() {
        return numberGeometricTerms;
    }

    public double getFirstGeometricTerm() {
        return firstGeometricTerm;
    }

    public double getSecondGeometricTerm() {
        return secondGeometricTerm;
    }

    @Override
    public double findCommonRatioTerm() {
        return secondGeometricTerm / firstGeometricTerm;
    }

    @Override
    public double findNumberOfTermSequence() {
        return firstGeometricTerm * Math.pow(findCommonRatioTerm(), numberGeometricTerms - 1);
    }

    @Override
    public double sumOfTerms() {
        return firstGeometricTerm * (1 - Math.pow(findCommonRatioTerm(), numberGeometricTerms)) / (1 - findCommonRatioTerm());
    }

    public String toString() {
        return "b1 = " + getFirstGeometricTerm() + "\nb2 = " + getSecondGeometricTerm() + "\nn = " + getNumberGeometricTerms() + "\nd = " + findCommonRatioTerm() + "\nbn = " + findNumberOfTermSequence() + "\nSn = " + sumOfTerms();
    }
}