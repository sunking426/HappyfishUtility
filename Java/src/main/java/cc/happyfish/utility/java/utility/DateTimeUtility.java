package cc.happyfish.utility.java.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-03-30
 * 说明:无
 */
public class DateTimeUtility {

    public final static String DefaultDatePattern = "yyyy-MM-dd";

    public final static String DefaultDateTimePattern = "yyyy-MM-dd HH:mm:ss";

    public final static String date2Str(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public final static Date str2Date(String date, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(date);
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }
}
