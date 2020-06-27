package TimeApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestDateFormatThreadLocal {
    //使用ThreadLocal可以解决部分线程安全问题
    private static final ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                System.out.println("执行任务");
                Date date = sdf.get().parse("20200626");
                sdf.remove();
                return date;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
            System.out.println("填入任务" + i);
        }
        for (Future<Date> result : results) {
            System.out.println("准备获取");
            System.out.println(result.get());
        }

        pool.shutdown();
    }
}
