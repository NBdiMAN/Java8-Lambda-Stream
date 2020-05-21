package lambda;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TestLambda {

    @Test
    public void testLambda1(){


        //1.1匿名内部类不用Lambda表达式的实现
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> set1 = new TreeSet<>(comparator);
        set1.add(2);
        set1.add(3);
        set1.add(1);
        for (Integer integer : set1) {
            System.out.println(integer);
        }
        System.out.println("===============================================");
        //1.2.使用Lambda表达式的实现
        Comparator<Integer> comparator1 = (o1,o2)-> Integer.compare(o1,o2);
        TreeSet<Integer> set2 = new TreeSet<>(comparator1);
        set2.add(2);
        set2.add(6);
        set2.add(1);
        for (Integer integer : set2) {
            System.out.println(integer);
        }

    }
    //2.1 使用Lambda表达式简写匿名内部类,筛选出超过35岁的员工或工资超过5000的员工

    public List<Employee> filterEmployees(List<Employee> employees, MyPredicate<Employee> myPredicate){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if(myPredicate.test(employee)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
    @Test
    public void testLambda2(){
        List<Employee> employees = Arrays.asList(
                new Employee("a",54,new BigDecimal(66666)),
                new Employee("b",44,new BigDecimal(666)),
                new Employee("c",24,new BigDecimal(666)),
                new Employee("d",64,new BigDecimal(66)),
                new Employee("e",14,new BigDecimal(6))
        );
        //使用接口的匿名内部类,返回判断结果(未经简化)
        MyPredicate<Employee> myPredicate = o1 -> o1.getAge() > 35;
        MyPredicate<Employee> myPredicate1 = (o1) -> o1.getSalary().intValue() > 5000;
        List<Employee> employeesList = filterEmployees(employees, myPredicate);
        for (Employee employee : employeesList) {
            System.out.println(employee);
        }
        System.out.println("==========================================================");
        List<Employee> employeesList2 = filterEmployees(employees, myPredicate1);
        for (Employee employee : employeesList2) {
            System.out.println(employee);
        }
        System.out.println("==========================================================");
        //使用接口的匿名内部类,返回判断结果(简化)
        List<Employee> employeesList3 = filterEmployees(employees, o1 -> o1.getAge() > 35);
        employeesList3.forEach(System.out::println);
        System.out.println("==========================================================");
        //使用接口的匿名内部类,返回判断结果(极简)
        employees.stream().filter(employee -> employee.getSalary().intValue() > 5000).forEach(System.out::println);
    }
}
