package solvd.projects.lambdafunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.lambdafunctions.customlambdafunctions.*;
import java.util.function.*;


public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Predicate<String> start =text ->text.startsWith("H");
        Predicate<String> end =text->text.endsWith("d");
        Predicate<String> checkText = start.and(end);
        String text1 ="Hello World";
        boolean result =checkText.test(text1);
        LOGGER.info(result);

        DoubleToIntFunction doubleToIntFunction =d -> {return (int) d;};
        double test1 =3.2;
        LOGGER.info(doubleToIntFunction.applyAsInt(test1));

        IntPredicate intPredicate = (x) -> {if (x <= 10) return true;return false;};
        LOGGER.info( intPredicate.test(11));

        Supplier<Double> randomValue = () -> Math.random();
        LOGGER.info(randomValue.get());


        //Custom Lambda Functions
//
//        IWriteText exampleOne = text-> LOGGER.info(text);
//        exampleOne.write(3);
//
//        ISumNumbers<Double,Double, Double> exampleTwo=((firstNumber, secondNumber) -> firstNumber+secondNumber );
//        LOGGER.info("Sum is "+exampleTwo.sum(5.0,6.4));
//
//        ICheckSomething<Integer>exampleThird=somehting -> { if(somehting > 0)return true; else return false;};
//        LOGGER.info(exampleThird.checking(5));












    }


}
