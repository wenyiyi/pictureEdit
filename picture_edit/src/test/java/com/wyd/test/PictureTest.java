package com.wyd.test;


import com.alibaba.excel.EasyExcel;
import org.junit.Test;

public class PictureTest {

    @Test
    public void test(){
        String fileName = "/Users/vincentwen/Desktop/huizi.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, User.class, new UserListener()).sheet().doRead();
    }
}