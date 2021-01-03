package com.wyd.test;


import com.alibaba.excel.EasyExcel;
import com.wyd.domain.User;
import com.wyd.service.UserListener;
import com.wyd.util.ImageUtils;
import org.junit.Test;

import java.io.IOException;

public class PictureTest {

    @Test
    public void test(){
        String fileName = "src/main/resources/test.xlsx";
        // 这里默认读取第一个sheet
        EasyExcel.read(fileName, User.class, new UserListener()).sheet().doRead();
    }

    @Test
    public void test2() throws IOException {


        String watermarkUrl = "";
        String source = "";
        String output = "src/main/resources/final";

        ImageUtils.markImgMark(watermarkUrl, source, output);
    }



}