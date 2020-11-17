package com.wyd.test;


import com.alibaba.excel.annotation.ExcelProperty;

public class User {

    /**
     * 序号
     */
    @ExcelProperty("序号")
    private String sort;
    /**
     * 昵称
     */
    @ExcelProperty("我的昵称")
    private String username;
    /**
     * 属性
     */
    @ExcelProperty("我的属性是")
    private String attribute;
    /**
     * 几点几
     */
    @ExcelProperty("0～1，我是几点几：")
    private String number;
    @ExcelProperty("我的所在地")
    private String address;
    @ExcelProperty("出生年代是？（匹配更精确喔）")
    private String birth;
    /**
     * 星座
     */
    @ExcelProperty("我的星座")
    private String constellation;
    /**
     * 职业
     */
    @ExcelProperty("我从事的工作")
    private String work;
    /**
     * 我的标签
     */
    @ExcelProperty("以下标签里，符合我特质的是：")
    private String myLabel;
    /**
     * 自我介绍
     */
    @ExcelProperty("用一句话向大家总结下自己吧~")
    private String selfIntroduction;
    /**
     * 她的爱好
     */
    @ExcelProperty("我希望她是个喜欢____的姑娘：")
    private String hobby;
    /**
     * 她的特质
     */
    @ExcelProperty("我会被有____特质的她吸引：")
    private String herLabel;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMyLabel() {
        return myLabel;
    }

    public void setMyLabel(String myLabel) {
        this.myLabel = myLabel;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHerLabel() {
        return herLabel;
    }

    public void setHerLabel(String herLabel) {
        this.herLabel = herLabel;
    }

    @Override
    public String toString() {
        return "User{" +
            "sort='" + sort + '\'' +
            ", username='" + username + '\'' +
            ", attribute='" + attribute + '\'' +
            ", number='" + number + '\'' +
            ", address='" + address + '\'' +
            ", birth='" + birth + '\'' +
            ", constellation='" + constellation + '\'' +
            ", work='" + work + '\'' +
            ", myLabel='" + myLabel + '\'' +
            ", selfIntroduction='" + selfIntroduction + '\'' +
            ", hobby='" + hobby + '\'' +
            ", herLabel='" + herLabel + '\'' +
            '}';
    }
}
