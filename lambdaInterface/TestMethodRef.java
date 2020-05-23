package lambdaInterface;


import org.junit.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用:若lambda体中的内容已经有方法有实现了,我们可以使用"方法引用"(可以理解为方法引用是Lambda表达式的另外一种表现形式)
 * 主要有三种语法格式: 要求:引用方法的参数列表和返回值类型要和函数式接口的抽象方法参数列表和返回值类型保持一致
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名(当参数列表的第一个参数是实例方法的调用者,第二个参数是实例方法的参数时,可以使用,比如System::equals)
 */
public class TestMethodRef {
    @Test
    public void test1(){//实例
        PrintStream printStream = System.out;
        Consumer<String> consumer1 = (x) -> printStream.println(x);//初始
        Consumer<String> consumer2 = System.out::println;//简化
    }
    @Test
    public void test2(){//对象::实例方法名
        Employee employee = new Employee("wy",18,new BigDecimal(15000));
        Supplier<String> supplier = employee::getUsername;
        String username = supplier.get();
        System.out.println(username);
    }
    @Test
    public void test3(){//类::静态方法名
        Supplier<Integer> supplier = Employee::getIntValue;
        Integer integer = supplier.get();
        System.out.println(integer);
    }
    @Test
    public void test4(){//类::实例方法名
        MyPredicate<String> myPredicate = (x,y)-> x.equals(y);//简化前
        MyPredicate<String> myPredicate1 = String::equals;//简化后

    }
}
