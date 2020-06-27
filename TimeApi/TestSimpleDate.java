package TimeApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDate {
    //以前的时间操作存在线程安全问题
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                System.out.println("执行任务");
                System.out.println(sdf.getCalendar());
                return sdf.parse("20200626");//在这里会重新设置年月日，在只设置了年的时候，另一个线程打印了，导致报错
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
            System.out.println("填入任务" + i);
        }
        for (Future<Date> result : results) {
            System.out.println(result.get());
        }
        pool.shutdown();*/

        //使用新的API解析时间，线程安全，因为其不可变
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                System.out.println("执行任务");
                return LocalDate.parse("20200626",dtf);//在这里会重新设置年月日，在只设置了年的时候，另一个线程打印了，导致报错
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
            System.out.println("填入任务" + i);
        }
        for (Future<LocalDate> result : results) {
            System.out.println(result.get());
        }
        pool.shutdown();
    }
}
