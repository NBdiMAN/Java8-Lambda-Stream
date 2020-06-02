package stream1;

import lambdaInterface.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ReduceAndCollectOfStream {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",11,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("李四",12,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("王五",24,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("赵六",26,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",37,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",38,new BigDecimal(6666), Employee.Status.VOCATION));
    /**
     * 归约:reduce(T identity, BinaryOperator)/reduce(BinaryOperator)-可以将流中元素反复结合起来,得到一个值
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Double> reduce1 = employees.stream().map(Employee::getDoubleValue).reduce(Double::sum);
        Double aDouble = reduce1.get();
        System.out.println(aDouble);

    }

    @Test
    public void test2(){
        List<String> collect = employees.stream().map(Employee::getUsername).distinct().collect(Collectors.toList());
        System.out.println(collect);
        //获取想要类型的集合
        HashSet<String> collect1 = employees.stream().map(Employee::getUsername).collect(Collectors.toCollection(HashSet::new));
        //获取总数

        employees.stream().collect(Collectors.counting());
        //获取平均值
        employees.stream().collect(Collectors.averagingInt(Employee::getAge));

        //分组
        Map<Employee.Status, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect2);
        collect2.forEach((status,employees)-> System.out.println(status.name()+":"+employees));

        //多级分组
        Map<Employee.Status, Map<String, List<Employee>>> collect3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(ReduceAndCollectOfStream::groupByAge)));
        System.out.println(collect3);
    }

    public static String groupByAge(Employee e){
        if(e.getAge() < 20){
            return "懵懂";
        }else if(e.getAge() < 30){
            return "探索";
        }else{
            return "不惑";
        }
    }

}
