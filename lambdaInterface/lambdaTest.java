package lambdaInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * java8内置四大核心接口
 *
 * Consumer<T>:消费型接口 accept(T t); andThen(Consumer<T> consumer)
 *
 * Supplier<T>:供给型接口 T get();
 *
 * Function<T,R>:函数型接口,T输入参数类型,R为返回参数类型 R apply(T t)
 *
 * Predicate<T>:断言型接口,判断值 test(T t)
 */
public class lambdaTest {

    @Test
    public void testConsumer(){
        //对某个值进行-2后打印
        Double money = 15.25;
        Consumer<Double> consumer = (o1) ->
        {o1 = o1 - 2;
            System.out.println(o1);};
        consumer.accept(money);//13.25 传入后是这样的 o1 = Double.valueOf(o1.doubleValue() - 2);
        System.out.println(money);//15.25
    }

    @Test
    public void testSupplier(){
        //返回十个随机整数
        Math.random();
        System.out.println(getNumList(10,()-> new Random().nextInt(100)));
    }

    public List<Integer> getNumList(int count, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Integer num = supplier.get();
            list.add(num);
        }
        return list;
    }

}
