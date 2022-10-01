package solvd.projects.patterns.abstractfactory;

public class FactoryGenerator {

    public static AbstractFactory getFactory(String factory){
        if (factory.equalsIgnoreCase("Animal")){
            return new AnimalFactory();
        }
        if (factory.equalsIgnoreCase("AnimalType")){
            return new AnimalTypeFactory();
        }
        return null;
    }
}
