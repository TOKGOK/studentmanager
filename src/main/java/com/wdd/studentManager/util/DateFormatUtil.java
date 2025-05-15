package com.wdd.studentManager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateFormatUtil
 * @Description None
 * @Date 2019/7/2 13:22
 * @Created by WDD
 */
public class DateFormatUtil {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getFormatDate(Date date){
        return sdf.format(date);
    }

    public static String getFormatDate(){
        return getFormatDate(new Date());
    }
}
