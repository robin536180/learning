package com.liufei.regx;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 * @author:liufei
 * @create_time:2019/3/5-17:12
 */
public class regx {

    /**
     * 4位小数
     * @param args
     */
    public static void main(String[] args) {
        BigDecimal num = new BigDecimal(0.12143);

        String pattern = "0\\.\\d{1,4}";
        System.out.println(num.setScale(4, RoundingMode.HALF_DOWN).toString());
        boolean isMatch = Pattern.matches(pattern, num.setScale(4, RoundingMode.HALF_DOWN).toString());
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);


        BigDecimal num1 = new BigDecimal(15.1);
        System.out.println(num1.compareTo(new BigDecimal(num1.intValue())));

    }
}
