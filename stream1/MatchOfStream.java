package stream1;

import lambdaInterface.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchOfStream {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",11,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("李四",12,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("王五",14,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("赵六",16,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",17,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",18,new BigDecimal(6666), Employee.Status.VOCATION));

    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少有一个元素匹配
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中任意一个元素
     * count-返回流中元素的总个数
     * max-返回流中的最大值
     * min-返回流中的最小值
     */
    @Test
    public void test1(){
        boolean allMatch = employees.stream().allMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(allMatch);
        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(anyMatch);
        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(noneMatch);
        Optional<Employee> first = employees.stream().findFirst();
        Employee employee = first.get();
        System.out.println(employee);
        Optional<Employee> any = employees.stream().findAny();
        Employee employee1 = any.get();
        System.out.println(employee1);
        long count = employees.stream().count();
        System.out.println(count);
        Optional<Employee> max = employees.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        Employee employee2 = max.get();
        System.out.println(employee2);
        Optional<Employee> min = employees.stream().min((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
        Employee employee3 = min.get();
        System.out.println(employee3);

    }
}
