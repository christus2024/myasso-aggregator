package fr.it4innov.myasso.myassoutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Christus TCHASSI
 * @Date 06/06/2024
 */
public class DateUtils {

    public static String dateToString( Date date ){
        String pattern = "yyyyMdd_HHmmss_SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
