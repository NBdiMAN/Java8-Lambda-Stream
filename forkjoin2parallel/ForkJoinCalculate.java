package forkjoin2parallel;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 90764
 */
public class ForkJoinCalculate extends RecursiveTask<Long>{

    /**
     *
     */
    private static final long serialVersionUID = 13475679780L;

    private long start;
    private long end;

    private static volatile AtomicInteger count = new AtomicInteger(0);

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if(length <= THRESHOLD){
            long sum = 0;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }else{
//            System.out.println("==== 第"+ count.getAndIncrement() + "次任务分解 ====");
            long mid = (start + end) / 2;
//            System.out.println("start:" +start +",mid:" + mid + ",end:" + end);
            ForkJoinCalculate left = new ForkJoinCalculate(start, mid);
            //拆分子任务,同时压入线程队列
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(mid+1, end);
            right.fork();

            return left.join() + right.join();
        }

    }

}
