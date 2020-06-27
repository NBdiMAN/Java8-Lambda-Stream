package TimeApi;

import org.junit.Test;

import java.time.*;

public class TestLocalDateTime {
    //1.LocalDateTime
    @Test
    public void test1() {
        //获取当前系统时间
        //方式1
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //方式2
        LocalDateTime ldt2 = LocalDateTime.of(2019,7,15,0,0,1,1);
        System.out.println(ldt2);

        //运算
        LocalDateTime localDateTime = now.plusYears(1);//使用plus***()进行加
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = now.minusMonths(1);//使用minus***()进行减
        System.out.println(localDateTime1);


        int year = now.getYear();//获取年份
    }
    //2.Instant:时间戳,以Unix元年1970-01-01 00:00:00 到某个时间之间的毫秒值
    @Test
    public void test2(){
        Instant instant = Instant.now();//默认获取UTC时区
        System.out.println(instant.toString());
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//带偏移量的日期
        System.out.println(offsetDateTime);
        System.out.println(instant.toEpochMilli());//打印毫秒时间

        //时间戳运算
        Instant instant1 = Instant.ofEpochSecond(300);//注意这里用的是静态方法
        System.out.println(instant1);
    }
    //3.Duration:计算两个时间之间的间隔   Period: 计算两个日期之间的间隔
    @Test
    public void test3(){
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        Duration between = Duration.between(instant1, instant2);
        System.out.println(between.toMillis());
        System.out.println("=======================================");
        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime1 = LocalTime.now();
        Duration between1 = Duration.between(localTime, localTime1);
        System.out.println(between1.toMillis());

        System.out.println("------------------------------------------");
        LocalDate date = LocalDate.of(2020,6,26);
        LocalDate date1 = LocalDate.of(2020,6,27);
        System.out.println(Period.between(date,date1).getDays());

    }
}
