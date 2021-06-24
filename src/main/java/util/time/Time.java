package util.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : chenliangzhou
 * create at:  2021/5/17  11:34 AM
 * @description:
 **/
public class Time {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());

        Date parse = sdf.parse(format);
        long time = parse.getTime();
        long l = System.currentTimeMillis();

        System.out.println((l-time)/1000/60/60);
    }

    /**
     * 判断日期是否为当天
     * @author zhouchenliang
     * @date 5:10 PM 2021/6/24
     * @param
     * @return
     * @throws
     **/
    public static boolean isToDay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (sdf.format(new Date()).equals(date)) {
            return true;
        } else {
            return false;
        }
    }

    public void format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
