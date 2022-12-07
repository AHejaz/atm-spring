package com.brehon.week_10_practice_java_atm_spring.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MessageLoader {

    private static Properties prop = new Properties();

    static {
        InputStream in;
        try {
            in = new FileInputStream("E:\\Projects\\java spring camp\\" +
                    "week_9_practice_java_ATM_database_Maven\\src\\main\\resources\\message.properties");
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String key){
        String message = prop.getProperty(key);
        return message;
    }
}
