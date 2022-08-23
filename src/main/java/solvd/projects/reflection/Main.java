package solvd.projects.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Class triangleReflection= Triangle.class;
        Field[] fields=triangleReflection.getDeclaredFields();
        LOGGER.info("\t\t\tFields");
        for (Field field:fields) {
          LOGGER.info(Modifier.toString(field.getModifiers())+" "+field.getType()+" "+field.getName());
        }
        System.out.println();
        LOGGER.info("\t\t\tConstructor");
        Constructor[] constructors=triangleReflection.getDeclaredConstructors();
        for (Constructor constructor :constructors) {
            LOGGER.info(Modifier.toString(constructor.getModifiers())+" "+constructor.getName()+" "+ Arrays.toString(constructor.getParameters()));
        }
        System.out.println();
        LOGGER.info("\t\t\tMethods");
        Method[] methods = triangleReflection.getDeclaredMethods();
        for (Method method:methods) {
            LOGGER.info(Modifier.toString(method.getModifiers())+" "+method.getReturnType()+" "+method.getName()+" "+Arrays.toString(method.getParameters()));
        }
    }
}
