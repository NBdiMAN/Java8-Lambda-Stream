package lambda;
@FunctionalInterface
public interface ArithmeticOperation<T,R> {

    R getValue(T arg1 ,T arg2);
}
