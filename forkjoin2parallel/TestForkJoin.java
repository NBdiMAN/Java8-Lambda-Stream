package forkjoin2parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Author: WangYang
 * @Date: 2020/6/14 12:56
 */
public class TestForkJoin {

    /**
     * 经过测试,在我的电脑上,在亿级ForkJoin才有优势
     */
    @Test
    public void test1(){
        Instant start1 = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinCalculate forkJoinCalculate = new ForkJoinCalculate(0, 100000000L);
        Long invoke = forkJoinPool.invoke(forkJoinCalculate);
        Instant end1 = Instant.now();
        System.out.println("ForkJoin方式最终结果:"+invoke+",耗时:" + Duration.between(start1, end1));
        forkJoinPool.shutdown();

        Instant start2 = Instant.now();
        long sum = 0;
        for (long i = 0; i <= 100000000L; i++) {
            sum+=i;
        }
        Instant end2 = Instant.now();
        System.out.println("单线程方式最终结果:"+sum+",耗时:" + Duration.between(start2, end2));
    }


    /**
     * Java8中使用并行流
     */
    @Test
    public void test2(){
        Instant start1 = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000L).parallel().reduce(0, Long::sum);
        Instant end1 = Instant.now();
        System.out.println("parallel()方式最终结果:"+reduce+",耗时:" + Duration.between(start1, end1));
        Instant start2 = Instant.now();
        long reduce2 = LongStream.rangeClosed(0, 100000000L).sequential().reduce(0, Long::sum);
        Instant end2 = Instant.now();
        System.out.println("sequential()方式最终结果:"+reduce2+",耗时:" + Duration.between(start2, end2));
    }
}
