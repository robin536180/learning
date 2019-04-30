package com.liufei.totp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author:liufei
 * @create_time:2019/4/19-10:32
 */
public class Test {
    public static void main(String[] args) {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    //单纯输出时间
                    Date now = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
                    String hehe = dateFormat.format( now );
                    System.out.println(hehe);

                    //测试算法

                    String secret = "abcdefghijklmnopqrst";
                    String result = LinAuthenication.getCurrentCode(secret);
                    System.out.println(result);
                } catch (LinAuthenication.OtpSourceException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }
}