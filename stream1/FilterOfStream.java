package stream1;

import lambdaInterface.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterOfStream {

    List<Employee> employees = Arrays.asList(
            new Employee("张三",11,new BigDecimal(6666)),
            new Employee("李四",12,new BigDecimal(6666)),
            new Employee("王五",14,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666))
    );
    /**
     * 筛选与切片
     * filter-接收Lambda,从流中排除某些元素
     * limit-截断流,使元素不超过给定数量
     * skip(n)-跳过元素,返回一个扔掉了前n个元素的流,若个数小于n,返回一个空流
     * distinct-筛选,通过流所生成元素的hashCode()和equals()方法去除重复元素
     *
     * stream has already been operated upon or closed  一个流只能消费一次,可以用Supplier接口每次get一个流
     */
    @Test
    public void  test1(){
        //中间操作


        Stream<Employee> stream1 = employees.stream();
        stream1.filter((x)->x.getAge() > 11).limit(4).skip(1).distinct().forEach(System.out::println);

    }
}
