package com.application.littlehabit;

public class Habit {

    public String hname;  //习惯名
    public String hIcon;     //习惯图标
    public int everyday_num;     //习惯每日需完成次数
    public String time; //习惯时间区间：晨间习惯、午间、晚间、任意时间
    public String frequent;  //习惯频率：每日、每周、每月
    public String htips; //习惯标注
    public int finished_num;  //习惯今日已完成次数
    public int days;    //坚持天数
    public int insisted_days; //当前已坚持天数
    public int highdays;    //最高坚持天数
    public String createdate;  //创建日期
    public int swit;    //习惯是否开启

    public Habit(String hname, String hIcon, int everyday_num, String time, String frequent, String htips, int finished_num, int days, int insisted_days, int highdays, String createdate, int swit) {
        setHname(hname);
        sethIcon(hIcon);
        setEveryday_num(everyday_num);
        setTime(time);
        setFrequent(frequent);
        setHtips(htips);
        setFinished_num(finished_num);
        setDays(days);
        setInsisted_days(insisted_days);
        setHighdays(highdays);
        setCreatedate(createdate);
        setSwit(swit);
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String gethIcon() {
        return hIcon;
    }

    public void sethIcon(String hIcon) {
        this.hIcon = hIcon;
    }

    public int getEveryday_num() {
        return everyday_num;
    }

    public void setEveryday_num(int everyday_num) {
        this.everyday_num = everyday_num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrequent() {
        return frequent;
    }

    public void setFrequent(String frequent) {
        this.frequent = frequent;
    }

    public String getHtips() {
        return htips;
    }

    public void setHtips(String htips) {
        this.htips = htips;
    }

    public int getFinished_num() {
        return finished_num;
    }

    public void setFinished_num(int finished_num) {
        this.finished_num = finished_num;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getInsisted_days() {
        return insisted_days;
    }

    public void setInsisted_days(int insisted_days) {
        this.insisted_days = insisted_days;
    }

    public int getHighdays() {
        return highdays;
    }

    public void setHighdays(int highdays) {
        this.highdays = highdays;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getSwit() {
        return swit;
    }

    public void setSwit(int swit) {
        this.swit = swit;
    }


}
