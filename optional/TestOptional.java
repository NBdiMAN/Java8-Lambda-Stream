package optional;
import java.math.BigDecimal;
import java.util.Optional;

import lambda.Employee;
import org.junit.Test;


/**
 * @Author: WangYang
 * @Date: 2020/6/14 17:58
 *  一、Optional 容器类：用于尽量避免空指针异常
 *  	Optional.of(T t) : 创建一个 Optional 实例
 *  	Optional.empty() : 创建一个空的 Optional 实例
 *   	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 *   	isPresent() : 判断是否包含值
 *   	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 *   	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 *   	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 *  	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test1(){
        Optional<Employee> optionalEmployee = Optional
                .of(new Employee("风", 18, new BigDecimal(2000)));
        System.out.println(optionalEmployee.get());
        System.out.println(optionalEmployee.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee1 = Optional
                .empty();
        System.out.println(optionalEmployee1.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee2 = Optional
                .ofNullable(null);
        System.out.println(optionalEmployee2.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee3 = Optional
                .ofNullable(null);
        System.out.println(optionalEmployee3.orElse(new Employee("云", 19, null)));
        System.out.println(optionalEmployee3.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee4 = Optional
                .ofNullable(null);
        System.out.println(optionalEmployee4.orElseGet(()->new Employee("霜", 20, null)));
        System.out.println(optionalEmployee4.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee5 = Optional
                .of(new Employee("风", 18, new BigDecimal(2000)));
        System.out.println(optionalEmployee5.get());
        System.out.println(optionalEmployee5.isPresent());
        Optional<Employee> optionalEmployee6 = optionalEmployee5.map((x) -> {
            x.setUsername("雄霸");
            x.setAge(45);
            return x;
        });
        System.out.println(optionalEmployee6.get());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee7 = Optional
                .empty();
        System.out.println(optionalEmployee7.isPresent());
        Optional<Employee> optionalEmployee8 = optionalEmployee7.map((x) -> {
            x.setUsername("雄霸");
            x.setAge(45);
            return x;
        });
        System.out.println(optionalEmployee8.isPresent());
        System.out.println("========================================");
        Optional<Employee> optionalEmployee9 = Optional
                .of(new Employee("风", 18, new BigDecimal(2000)));
        System.out.println(optionalEmployee9.get());
        System.out.println(optionalEmployee9.isPresent());
        Optional<Employee> optionalEmployee10 = optionalEmployee9.flatMap((e)-> Optional.of(new Employee("断浪",18,null)));
        System.out.println(optionalEmployee10.get());
        System.out.println("========================================");
    }


}
