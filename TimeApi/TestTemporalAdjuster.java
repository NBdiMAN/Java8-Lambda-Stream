package TimeApi;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 时间校正器TemporalAdjuster
 */
public class TestTemporalAdjuster {
    @Test
    public void test(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);//制定年月日
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));//使用接口制定时间计算
        System.out.println(localDateTime2);

        //自定义下一个工作日
        LocalDateTime localDateTime5 = localDateTime.with((l) -> {
            LocalDateTime localDateTime3 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime3.getDayOfWeek();
            LocalDateTime localDateTime4 = null;
            if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {//找到下一个工作日，这里省略每一天的判断
                localDateTime4 = localDateTime3.plusDays(2);
            }
            return localDateTime4;
        });
        System.out.println(localDateTime5);
    }
}
