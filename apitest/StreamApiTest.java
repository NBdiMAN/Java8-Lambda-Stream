package apitest;

import lambdaInterface.Employee;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: WangYang
 * @Date: 2020/6/14 1:45
 */
public class StreamApiTest {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",11,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("李四",12,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("王五",24,new BigDecimal(6666), Employee.Status.FREE),
            new Employee("赵六",26,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",37,new BigDecimal(6666), Employee.Status.BUSY),
            new Employee("赵六",38,new BigDecimal(6666), Employee.Status.VOCATION));
    /**
     * 1.给定一个数字列表,返回数字平方的列表
     */
    public List<Integer> getSquareList(List<Integer> list){
        List<Integer> collect = list.stream().map((num) -> num * num).collect(Collectors.toList());
        return collect;
    }

    /**
     * 使用map和reduce方法数一数流中有多少个Employee
     */
    public Integer countOfEmployees(List<Employee> employees){
//        Long collect = employees.stream().collect(Collectors.counting());
//        return collect.intValue();
        Optional<Integer> optional = employees.stream().map((x) -> 1).reduce(Integer::sum);
        Integer count = optional.get();
        return count;
    }
}
