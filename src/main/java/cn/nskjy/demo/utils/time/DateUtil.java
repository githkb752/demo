package cn.nskjy.demo.utils.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date strDate(String str) throws ParseException {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        parse = date.parse(str);
        return parse;
    }

    public static void main(String[] args) throws ParseException {
        String str = "1991-1-1";
        System.out.println(strDate(str));
    }
}
