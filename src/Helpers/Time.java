package Helpers;

import java.sql.Timestamp;

public class Time {

    public static long getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()/1000);
        return timestamp.getTime();
    }
}
