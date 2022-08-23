package solvd.projects.lambdafunctions.customlambdafunctions;
@FunctionalInterface
public interface ISumNumbers<T,Z,V>{
    T sum(V firstNumber,Z secondNumber);
}
