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
        //printRandomDate(30);
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
        if (sdf.format(new Date()).equals(sdf.format(date))) {
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


    public static void printRandomDate(int n) {
        for (int i = 0; i < 30; i++) {
            Date date = randomDate("2019-01-01","2019-01-31");
            System.out.println(date);
            String format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
            System.out.println(format);
        }
    }

    /**
     * 生成随机时间
     * @param beginDate
     * @param endDate
     * @return
     */
    private static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

}
