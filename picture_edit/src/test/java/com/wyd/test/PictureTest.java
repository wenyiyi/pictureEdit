package com.wyd.test;


import com.alibaba.excel.EasyExcel;
import com.wyd.domain.User;
import com.wyd.service.UserListener;
import org.junit.Test;

public class PictureTest {

    @Test
    public void test(){
        String fileName = "/Users/vincentwen/Desktop/test.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, User.class, new UserListener()).sheet().doRead();
    }

}