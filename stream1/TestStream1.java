package stream1;

import lambdaInterface.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Stream的三个步骤
 * 1.创建Stream
 *
 * 2.中间操作
 *
 * 3.终止操作(终端操作)
 */

public class TestStream1 {
    @Test
    public void test1(){
        //1.通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.可以通过Arrays中的静态方法stream()获得流
        Employee[] emps = new Employee[5];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.Stream类的of方法获取流
        Stream<String> stream3 = Stream.of("1", "2", "3");
        //stream3.forEach(System.out::println);

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(1, (x) -> x + 2);
        //stream4.forEach(System.out::println);

        //生成
        Stream<Integer> stream5 = Stream.generate(new Random()::nextInt).limit(5);
        stream5.forEach(System.out::println);
    }
}
