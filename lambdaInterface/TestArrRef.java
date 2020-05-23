package lambdaInterface;

import org.junit.Test;

import java.util.function.Function;

/**
 * 数组引用 Type[]::new
 */
public class TestArrRef {
    @Test
    public void test1(){
        //不使用数组引用
        Function<Integer,String[]> function = (x)-> new String[x];
        String[] apply = function.apply(10);
        //使用数组引用
        Function<Integer,String[]> function1 = String[]::new;
        String[] apply1 = function1.apply(10);
    }
}
