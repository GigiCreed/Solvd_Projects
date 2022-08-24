package solvd.projects.multithread;
import solvd.projects.multithread.simplethreads.*;
public class Main {
    public static void main(String[] args) {
        MyThreadExample myThreadExample =new MyThreadExample();
        Thread myThreadExample2= new Thread(new MyThreadExample2());
        myThreadExample.start();
        myThreadExample2.start();
    }
}
