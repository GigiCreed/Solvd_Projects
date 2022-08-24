package solvd.projects.exceptions;
import solvd.projects.exceptions.customexceptions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws IsThisTriangle, WriteOnlyZero {
//        //------------------------------1
        System.out.println("1 Method");
        try {
            writeOnlyZero();
        } catch (WriteOnlyZero e) {
            LOGGER.error("Write only zero!!!!!!");
        }


//        //-------------------------------2
        System.out.println("\n\t\t2 Method");
        try {
            divideByFive();
        }catch (DivideByFive e){
            LOGGER.error("Cant divide by 5");
        }

        //------------------------------3

        System.out.println("\n\t\t3 Method");
        try {
            writeDiscriminant();
        } catch (DiscriminantLeesThanZero e){
            LOGGER.error("D is lees than 0");
        }

        //-----------------------------4

        System.out.println("\n\t\t4 Method");
        try {
            WriteCompany();
        }catch (OnlyInputSolvd e){
            LOGGER.error("Here is no written Solvd");
        }
        //  ----------------------------5
        System.out.println("\n\t\t5 Method");
        try {
            writeTriangle();
        }catch (IsThisTriangle e){
            LOGGER.error("This is Not Triangle");
        }

//     writeTriangle();
//     System.out.println();
// if we want to run code without using try catch we need to
// add Exception to main method signature


    }





    //                                       1
    public static void writeOnlyZero() throws WriteOnlyZero {
        Scanner scanner = new Scanner(System.in);
        while(true){
            LOGGER.info("x = ");
            int x = Integer.parseInt(scanner.nextLine());

            if(x != 0){
                throw new WriteOnlyZero("Write only Zero");
            }
        }
    }


    //                                    2
    public static void divideByFive() throws DivideByFive {
        Scanner scanner =new Scanner(System.in);
        double a;
        double b;
        LOGGER.info("a = ");
        a=scanner.nextInt();
        LOGGER.info("b = ");
        b=scanner.nextInt();
        double z = a/b;
        if(b == 5)
            throw  new DivideByFive("/ by 5");
        else
            LOGGER.info(z);
    }

    //                                  3

    public static void writeDiscriminant()throws DiscriminantLeesThanZero {
        Scanner scanner = new Scanner(System.in);
        double a; double b; double c;
        LOGGER.info("a = ");a=scanner.nextInt();
        LOGGER.info("b = ");b=scanner.nextInt();
        LOGGER.info("c = ");c=scanner.nextInt();
        double D=(b*b)-(4*a*c);
        if(D<0)
            throw new DiscriminantLeesThanZero("D < 0");
    }

    //                               4

    public static void WriteCompany() throws OnlyInputSolvd {
        Scanner scanner = new Scanner(System.in);
        String nameCompany;
        String solvd ="Solvd";
        LOGGER.info("Name of Company_");
        nameCompany=scanner.next();
        if(nameCompany == solvd) LOGGER.info("You are in Company Solvd");
        else throw new OnlyInputSolvd("Can't find Solvd");
    }

    //                              5

    public static void writeTriangle() throws IsThisTriangle {
        Scanner scanner = new Scanner(System.in);
        double a; double b; double c;
        LOGGER.info("a = "); a=scanner.nextDouble();
        LOGGER.info("b = "); b=scanner.nextDouble();
        LOGGER.info("c = "); c=scanner.nextDouble();
        if((a+b>c)&&(b+c>a)&&(c+a>b))
            LOGGER.info("This is Triangle");
        else throw new IsThisTriangle("This is Not Triangle");
    }

}