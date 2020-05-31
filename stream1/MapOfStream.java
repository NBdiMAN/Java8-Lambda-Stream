package stream1;

import lambdaInterface.Employee;
import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOfStream {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",11,new BigDecimal(6666)),
            new Employee("李四",12,new BigDecimal(6666)),
            new Employee("王五",14,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666)),
            new Employee("赵六",15,new BigDecimal(6666))
    );

    /**
     * 映射:map接收lambda,将元素转换成其他形式或提取信息.接收一个函数作为参数,该函数会被应用到每一个元素上,并将其映射成一个新元素
     *      flatMap,接收一个函数作为参数,将流中的每一个值都换成另一个流,然后把所有流连接成一个流
     */
    @Test
    public void test(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
            .map(String::toUpperCase).forEach(System.out::println);
        System.out.println("=====================================================");
        employees.stream().map(Employee::getUsername).forEach(System.out::println);
        System.out.println("=====================================================");
        //flatMap {{a,a,a},{b,b,b}}自动转换成{a,a,a,b,b,b}相当于list.addAll
        list.stream().flatMap(MapOfStream::filterCharactor).forEach(System.out::println);
    }

    public static Stream<Character> filterCharactor(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
}
