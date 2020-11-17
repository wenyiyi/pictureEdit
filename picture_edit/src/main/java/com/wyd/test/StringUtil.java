package com.wyd.test;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;

public class StringUtil {

    public StringUtil() {
    }

    public static String handleString(String str, int length) {
        if(StringUtils.isBlank(str)){
            return "";
        }
        String[] split = str.split(";");
        String newStr = "";
        for (int i = 0; i < split.length; i++) {
            int count = length - split[i].length();
            if(count > 0){
                for (int j = 0; j < count; j++) {
                    //split[i] += " ";
                    // 填充中文全角空格
                    split[i] += "\u3000";
                }
            }
            newStr += split[i];
        }
        return newStr;
    }

    /**
     * 计算中文字符长度
     * @param name 字符
     * @param endcoding 编码方式
     * @return
     * @throws Exception
     */
    public static int getChineseLength(String name, String endcoding) throws Exception {
        int len = 0; //定义返回的字符串长度
        int j = 0;
        //按照指定编码得到byte[]
        byte[] b_name = name.getBytes(endcoding);
        do {
            short tmpst = (short) (b_name[j] & 0xF0);
            if (tmpst >= 0xB0) {
                if (tmpst < 0xC0) {
                    j += 2;
                    len += 2;
                } else if ((tmpst == 0xC0) || (tmpst == 0xD0)) {
                    j += 2;
                    len += 2;
                } else if (tmpst == 0xE0) {
                    j += 3;
                    len += 2;
                } else {
                    short tmpst0 = (short) (((short) b_name[j]) & 0x0F);
                    if (tmpst0 == 0) {
                        j += 4;
                        len += 2;
                    } else if (tmpst0 < 12) {
                        j += 5;
                        len += 2;
                    } else {
                        j += 6;
                        len += 2;
                    }
                }
            } else {
                j += 1;
                len += 1;
            }
        } while (j <= b_name.length - 1);
        return len;
    }


    public static void main(String[] args) throws Exception {
        String text = "DIY";
        //String text = "\u3000";

        JLabel label = new JLabel(text);
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int textH = metrics.getHeight();
        //字符串的宽
        int textW = metrics.stringWidth(label.getText());

        System.out.println(textH);
        System.out.println(textW);
        System.out.println(text);
    }

}
