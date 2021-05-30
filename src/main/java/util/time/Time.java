package util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : chenliangzhou
 * create at:  2021/5/17  11:34 AM
 * @description:
 **/
public class Time {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
