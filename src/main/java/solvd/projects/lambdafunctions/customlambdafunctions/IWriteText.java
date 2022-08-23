package solvd.projects.lambdafunctions.customlambdafunctions;

@FunctionalInterface
public interface IWriteText<T>{
    void write(T text);
}
