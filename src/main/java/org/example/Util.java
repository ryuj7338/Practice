package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getNowStr() {
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now);
        return formatedNow;
    }
}
