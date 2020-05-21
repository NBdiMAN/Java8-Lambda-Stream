package lambda;

@FunctionalInterface//这个注解表示函数式接口,只能有一个抽象方法
public interface MyPredicate <T>{

    boolean test(T t1);
}
