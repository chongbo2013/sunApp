package sunlearning.sunlearningdemo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenny on 2018/4/2.
 */

public class DateFormatUtil {
    public static String dateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(date);
    }


    public static Date string2Date(String date,String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date result=null;
        try {
           result = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
