package com.el.dc.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String timeFormatter(long time) {
        return simpleDateFormat.format(new Date(time));
    }
}
