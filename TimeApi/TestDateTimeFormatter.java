package TimeApi;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * 时间格式化,时区操作
 */
public class TestDateTimeFormatter {
    @Test
    public void test(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dtf);
        System.out.println(format);

        LocalDateTime parse = localDateTime.parse(format,dtf);
        System.out.println(parse);


    }

    //ZonedDate,ZonedTime, ZonedDateTime
    @Test
    public void test2(){
        //查看所有时区
        /*Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }*/
        //获取某个时区的时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.of("America/Los_Angeles"));//获取带时区的时间，但是这个时间还是本地时间，只不过带了时区
        System.out.println(zonedDateTime);
    }
}
