package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {    //훨씬 유연하게 출력하기 위해 String이 아니라 Object로 받음
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n" , time, Thread.currentThread().getName(), obj);
    }
}
