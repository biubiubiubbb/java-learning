package base.date;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Demo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();        // EEE MMM dd HH:mm:ss zzz yyyy
        System.out.println(date);
        Date dateBegin = new Date(0);  // Thu Jan 01 08:00:00 CST 1970
        long time = date.getTime();   // time == System.currentTimeMillis()
        long timeBegin = dateBegin.getTime(); // 0
        long now = time - timeBegin;
        System.out.println(now);
        System.out.println(time);
        System.out.println(dateBegin); // Thu Jan 01 08:00:00 CST 1970
        System.out.println(date);  // Sun Jun 07 18:29:23 CST 2020


        // parse: String -> Date
        // format: Date -> String
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss"); // 自定义时间格式

        Date myBirthday = sdf.parse("1996-08-05 17:20:12"); // 不符合定义的格式则会抛异常
        System.out.println(myBirthday); // Mon Aug 05 17:20:12 CST 1996

        String nowFormatTime = sdf.format(new Date()); // 当前定义的格式的字符串时间 20-05-23 13:30:11
        System.out.println(nowFormatTime);

        // Calendar 日历
        Calendar cal = Calendar.getInstance();  // 多态
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        System.out.println(cal);
    }
}

