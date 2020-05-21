package lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda2 {

    // ->操作符,将lambda表达式拆分成两部分,左边是参数,右边是功能体,自带类型腿短
    @Test
    public void test1(){
        Runnable r1 = () -> System.out.println("Hello Lambda!");

        r1.run();
    }

    @Test
    public void test2(){
        Consumer<Integer> consumer = (x)-> System.out.println(x);
        consumer.accept(1);
    }

    @Test
    public void test3(){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("玛利亚",18,new BigDecimal(666));
        Employee e2 = new Employee("井空",16,new BigDecimal(6666));
        employees.add(e1);
        employees.add(e2);
        Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
        System.out.println(employees);
    }

    @Test
    public void test4(){
        System.out.println(getValue("aBcD",(o1)-> o1.toLowerCase()));
    }

    public String getValue(String str, GetValueFromString getValueFromString){
        return getValueFromString.getValue(str);
    }
    @Test
    public void test5(){
        long arg1 = 2;
        long arg2 = 3;
        System.out.println(getValue(arg1,arg2,(o1,o2)-> o1 * o2));
    }

    public long getValue(long arg1,long arg2 ,ArithmeticOperation<Long, Long> arithmetic){
        return arithmetic.getValue(arg1,arg2);
    }


}
