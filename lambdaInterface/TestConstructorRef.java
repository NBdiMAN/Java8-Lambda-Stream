package lambdaInterface;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Supplier;

/**
 * 构造器引用,需要调用的构造器参数列表要和函数式接口中抽象方法的参数列表保持一致
 */
public class TestConstructorRef {

    @Test
    public void test1(){
        //不使用构造器引用
        Supplier<Employee> supplier =()-> new Employee();

        //使用构造器引用
        Supplier<Employee> supplier2 = Employee::new;
    }
}
