package com.wyd.test;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserListener extends AnalysisEventListener<User> {

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param user    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(User user, AnalysisContext context) {
        handleExcelData(user);
        System.out.println("处理后的user="+user);
        Color color = new Color(89, 57, 214);
        String sortNum = user.getSort();
        int sortX = 645;
        int sortY = 56;
        int sortFont = 43;
        if(sortNum.length() == 1){
            sortX = 651;
            sortY = 60;
            sortFont = 55;
        }
        // 序号
        ImageUtils.pressText(user.getSort(), "/Users/vincentwen/Desktop/test.png", "/Users/vincentwen/Desktop/test/test1.png",
            "微软雅黑", Font.BOLD, color, sortFont, sortX, sortY, 1f);
        // 属性
        ImageUtils.pressText(user.getNumber() + user.getAttribute() + " " + user.getBirth(), "/Users/vincentwen/Desktop/test/test1.png", "/Users/vincentwen/Desktop/test/test2.png",
            "微软雅黑", Font.BOLD, Color.white, 80, 65, 270, 1f);
        String addressNum = user.getAddress();
        int addressX = 110;
        int addressY = 368;
        int addressFont = 80;
        if(StringUtils.isNotBlank(addressNum)&&addressNum.length() == 3){
            addressX = 110;
            addressY = 368;
            addressFont = 73;
        }
        // 地址
        ImageUtils.pressText(  user.getAddress()+" " + user.getConstellation(), "/Users/vincentwen/Desktop/test/test2.png", "/Users/vincentwen/Desktop/test/test3.png",
            "微软雅黑", Font.BOLD, Color.white, addressFont, addressX, addressY, 1f);
        // 昵称
        ImageUtils.pressText(user.getUsername(), "/Users/vincentwen/Desktop/test/test3.png", "/Users/vincentwen/Desktop/test/test4.png",
            "微软雅黑", Font.BOLD, Color.white, 90, 370, 150, 1f);
        // 自我介绍
        ImageUtils.pressText3(user.getSelfIntroduction(), "/Users/vincentwen/Desktop/test/test4.png", "/Users/vincentwen/Desktop/test/test5.png",
            "微软雅黑", Font.BOLD, Color.white, 25, 280, 580, 1f, 250);
        String work = user.getWork();
        if(StringUtils.isNotBlank(user.getWork())){
            String[] split = user.getWork().split("：");
            work = split[0];
        }
        // 职业
        ImageUtils.pressText3(StringUtil.handleString(work, 6), "/Users/vincentwen/Desktop/test/test5.png", "/Users/vincentwen/Desktop/test/test6.png",
            "微软雅黑", Font.BOLD, color, 25, 187, 840, 1f, 150);
        // 我的标签
        ImageUtils.pressText3(StringUtil.handleString(user.getMyLabel(), 6), "/Users/vincentwen/Desktop/test/test6.png", "/Users/vincentwen/Desktop/test/test7.png",
            "微软雅黑", Font.BOLD, color, 25, 164, 920, 1f, 150);
        // 她的标签
        ImageUtils.pressText2(StringUtil.handleString(user.getHerLabel(), 4), "/Users/vincentwen/Desktop/test/test7.png", "/Users/vincentwen/Desktop/test/test8.png",
            "微软雅黑", Font.BOLD, color, 25, 340, 225, 1f, 100);
        // 她的爱好
        ImageUtils.pressText2(StringUtil.handleString(user.getHobby(), 2), "/Users/vincentwen/Desktop/test/test8.png", "/Users/vincentwen/Desktop/final/" + user.getUsername() + ".png",
            "微软雅黑", Font.BOLD, color, 25, 182, 410, 1f, 50);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public void handleExcelData(User user){
        // 属性处理
        if(StringUtils.isNotBlank(user.getAttribute()) && user.getAttribute().equals("无法判断")){
            user.setAttribute("？");
        }
        //工作
        if(StringUtils.isNotBlank(user.getWork())){
            String[] split = user.getWork().split("：");
            user.setWork(split[0]);
        }
        // 匹配所有的数字和减号
        Pattern pattern = Pattern.compile("[0-9]\\-");
        // 她的标签
        if(StringUtils.isNotBlank(user.getHerLabel())){
            Matcher m = pattern.matcher(user.getHerLabel());
            String newHerLabel = m.replaceAll("");
            user.setHerLabel(newHerLabel);
        }
        // 她的爱好
        if(StringUtils.isNotBlank(user.getHobby())){
            Matcher m = pattern.matcher(user.getHobby());
            String newHerHobby = m.replaceAll("");
            user.setHobby(newHerHobby);
        }
    }

}
