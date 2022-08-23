package solvd.projects.streams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.projects.streams.car.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
     List<Car> cars =getCars();
     LOGGER.info("\t\tFiltered Type and Sorted Year");
     System.out.println();

     List<Car> sedans=cars.stream()
             .filter(car -> car.getType().equals(Type.SEDAN))
             .sorted(Comparator.comparing(Car::getYear))
             .toList();
     sedans.forEach(LOGGER::info);
     System.out.println();

     //----------------------------------------------------------------

     LOGGER.info("\t\tGroupBy Type");
     System.out.println();

     Map<Type,List<Car>> typeListMap=cars.stream()
                .collect(Collectors.groupingBy(Car::getType));
     typeListMap.forEach(((type, cars1) -> {
         LOGGER.info(type);
         cars1.forEach(LOGGER::info);
         System.out.println();
     }));


     //-----------------------------------------------------------------
        LOGGER.info("\t\tManufactures");
        System.out.println();

        List<String> manufactureList= cars.stream()
                .map(Car::getManufacture)
                .distinct()
                .toList();
        manufactureList.forEach(LOGGER::info);
        System.out.println();

     //------------------------------------------------------------------

        LOGGER.info("\t\tALL_MATCH");
        System.out.println();

        boolean result=cars.stream()
                .allMatch(car -> car.getYear()>1990 && car.getEngineCapacity()>1.0);
        LOGGER.info(result);
        System.out.println();

     //------------------------------------------------------------------

        LOGGER.info("\t\tANY_MATCH");
        System.out.println();

        boolean result2=cars.stream().anyMatch(car -> car.getManufacture().equals("SUBARU"));
        LOGGER.info(result2);
        System.out.println();

     //----------------------------------------------------------------

        LOGGER.info("\t\tMaximum Year");
        System.out.println();

        cars.stream()
               .max(Comparator.comparing(Car::getYear))
               .ifPresent(LOGGER::info);
        System.out.println();

     //---------------------------------------------------------------

        LOGGER.info("\t\tMinimum Year");
        System.out.println();

        cars.stream()
                .min(Comparator.comparing(Car::getYear))
                .ifPresent(LOGGER::info);
        System.out.println();

     //---------------------------------------------------------------





    }

    public static List<Car> getCars(){
        return List.of(
         new Car(Type.SEDAN,"Nissan","Tiida",2005,1.5, Transmission.AUTOMATIC,FuelType.BENZINE),
         new Car(Type.SEDAN,"Mercedes","E320",2003,3.2, Transmission.AUTOMATIC,FuelType.DIESEL),
         new Car(Type.SPORTSCAR,"ford","MUSTANG",2022,5.0, Transmission.AUTOMATIC,FuelType.BENZINE),
         new Car(Type.SEDAN,"Renault","LOGAN",2014,1.6, Transmission.MANUAL,FuelType.BENZINE),
         new Car(Type.SPORTSCAR,"Toyota","Supra",1998,3.0, Transmission.MANUAL,FuelType.BENZINE),
         new Car(Type.SUPERCAR,"Lamborghini","Aventador",2020,6.5, Transmission.TIPTRONIC,FuelType.BENZINE),
         new Car(Type.SEDAN,"Toyota","Prius",2010,1.6, Transmission.VARIATOR,FuelType.HYBRID),
         new Car(Type.SEDAN,"Toyota","Camry",2012,2.5, Transmission.AUTOMATIC,FuelType.HYBRID),
         new Car(Type.CROSSOVER,"BMW","X5",2005,4.0, Transmission.AUTOMATIC,FuelType.DIESEL),
         new Car(Type.CROSSOVER,"Mercedes","ML",2005,4.0, Transmission.AUTOMATIC,FuelType.DIESEL)
         );
    }
}
