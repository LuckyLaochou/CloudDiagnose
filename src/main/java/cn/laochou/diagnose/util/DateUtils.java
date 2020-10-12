package cn.laochou.diagnose.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String defaultFormat = "YYYY-MM-dd HH:mm:ss";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultFormat);

    public static String getTimeFormDefaultFormat() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

}
