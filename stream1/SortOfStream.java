package stream1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SortOfStream {
    @Test
    public void test1(){
        List<String> list = Arrays.asList("abd","abc","bac","bca");
        list.stream().sorted().forEach(System.out::println);
    }
}
