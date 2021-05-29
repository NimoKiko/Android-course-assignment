package com.application.littlehabit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Time;
import java.util.Date;

public class DBManager {

    //创建数据库帮助类
    private static MySqliteHelper helper;
    //创建数据库操作类
    private SQLiteDatabase db;
    //实例化helper
    public static MySqliteHelper getIntance(Context context){
        if(helper == null){
            helper = new MySqliteHelper(context);
        }
        return helper;
    }

    public DBManager(SQLiteDatabase db){
        this.db = db;
    }

//    //删除数据表
//    public void deleteSql(){
//        db.delete()
//
//    }


    //数据库创建函数
    public void createTableOrNot(){
        boolean notable = true;
        int count = -1;
        //先判断是否存在表
        String sql = "select count(*) as c from sqlite_master where type ='table' and name ='habits'";
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            count = cursor.getInt(0);
            if(count > 0){
                notable = false;
            }
        }
        if(notable){//不存在则建表
            String sql1 = "create table habits (hname text primary key,hIcon text, everyday_num integer,time text,frequent text,htips text,finished_num integer,days integer, insisted_days integer, highdays integer, createdate text , swit integer)";
            String sql2 = "create table daka (hname text,dakadate date)";
            db.execSQL(sql1);
            db.execSQL(sql2);
            this.InsertTestRecord();
        }
    }

    public void InsertTestRecord(){
        String sql1 = "insert into habits values ('测试习惯1','habit_1',2,'晨间习惯','每天','只有千锤百炼，才能成为好钢。',0,5,0,3,'20190526',1)";
        String sql2 = "insert into habits values ('测试习惯2','habit_2',3,'午间习惯','每天','只有千锤百炼，才能成为好钢。',0,3,0,2,'20190515',1)";
        String sql3 = "insert into habits values ('测试习惯3','habit_3',1,'晚间习惯','每天','只有千锤百炼，才能成为好钢。',0,4,0,2,'20190522',1)";
        String sql4 = "insert into habits values ('测试习惯4','habit_4',1,'任意时间','每天','只有千锤百炼，才能成为好钢。',0,6,0,3,'20190531',1)";

        String sql5 = "insert into daka values ('测试习惯1','20190601'),('测试习惯1','20190602'),('测试习惯1','20190603'),('测试习惯1','20190610'),('测试习惯1','20190611')";
        String sql6 = "insert into daka values ('测试习惯2','20190603'),('测试习惯2','20190610'),('测试习惯2','20190611')";
        String sql7 = "insert into daka values ('测试习惯3','20190603'),('测试习惯3','20190604'),('测试习惯3','20190610'),('测试习惯3','20190611')";
        String sql8 = "insert into daka values ('测试习惯4','20190601'),('测试习惯4','20190602'),('测试习惯4','20190603'),('测试习惯4','20190609'),('测试习惯4','20190610'),('测试习惯4','20190611')";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
    }

    //点击图标签到更新到数据库
    public void clickUpdateDB(String hname){
        //必做操作：finished_num++ 、插入打卡记录
        Date date = new Date();     ///获取当前日期
        String date_s = Utils.date2String(date);
        String sql1 = "update habits set finished_num = finished_num+1 where hname ='" + hname + "'";
        String sql2 = "insert into daka values ('" + hname + "','" + date_s + "')";
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    //返回给定时间段下的习惯
    //isNotFinished为1时返回未结束的,为0返回已结束的
    public Habit[] getHabit(String time, int isNotFinished) {
        String[] Time = new String[]{time};
        if (time == "任意时间") {//选中的时间是任意时间时返回全部habits
            String sql1 = "select count(*) from habits where swit=" + isNotFinished;
            Cursor cursor1 = db.rawQuery(sql1, null);//遍历数据表
            cursor1.moveToNext();
            int count = cursor1.getInt(0);//获取习惯总数
            Habit[] habits = new Habit[count];//创建habit数组
            String sql2 = "select * from habits where swit=" + isNotFinished;
            Cursor cursor2 = db.rawQuery(sql2, null);
            cursor2.moveToFirst();
            int i = 0;
            while (!cursor2.isAfterLast()) {
                Habit h1 = new Habit(cursor2.getString(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5), cursor2.getInt(6), cursor2.getInt(7), cursor2.getInt(8), cursor2.getInt(9), cursor2.getString(10), cursor2.getInt(11));
                habits[i++] = h1;
                cursor2.moveToNext();
            }
            ///应当有count == h.length;
            return habits;
        }else{//其他情况
            String sql1 = "select count(*) from habits where time=? and swit =" + isNotFinished;
            Cursor cursor1 = db.rawQuery(sql1, Time);
            cursor1.moveToNext();
            int count = cursor1.getInt(0);//获取习惯总数
            Habit[] habits = new Habit[count];//创建habit数组
            String sql2 = "select * from habits where time=? and swit =" + isNotFinished;
            Cursor cursor2 = db.rawQuery(sql2, Time);
            cursor2.moveToFirst();
            int i = 0;
            while (!cursor2.isAfterLast()) {
                Habit h1 = new Habit(cursor2.getString(0), cursor2.getString(1), cursor2.getInt(2), cursor2.getString(3), cursor2.getString(4), cursor2.getString(5), cursor2.getInt(6), cursor2.getInt(7), cursor2.getInt(8), cursor2.getInt(9), cursor2.getString(10), cursor2.getInt(11));
                habits[i++] = h1;
                cursor2.moveToNext();
            }
            ///应当有count == h.length ==i;实际h数组的下标应该为0至i-1
            //调试用Log.i("tag##",Integer.toString(i));
            return habits;
        }
    }

    //用于在添加新的习惯时更新数据库，成功返回ture，失败返回false（表示该习惯已经存在）。
    public boolean insertHabitDB(Habit habit) {

        //第一步先看要添加的habit名称是否已经存在
        String sql1 = "select count(*) from habits where hname = '" + habit.getHname() + "'";    //sql语句查询是否存在该名字
        Cursor cursor = db.rawQuery(sql1, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count == 1)      //若已经存在这个名字的习惯则直接返回false
            return false;
        //否则创建这个习惯。
        String sql2 = "insert into habits values('" + habit.getHname() + "','" + habit.gethIcon() + "'," + habit.getEveryday_num() + ",'" + habit.getTime() + "','" + habit.getFrequent() + "','" + habit.getHtips() + "'," + habit.getFinished_num() + "," + habit.getDays() + "," + habit.getInsisted_days() + "," + habit.getHighdays() + ",'" + habit.getCreatedate() + "'," + habit.getSwit() + ")";
        db.execSQL(sql2);
        return true;    ///添加则返回true
    }

    //设置习惯是否开启
    public void switchHabit(String hname,int swit) {
        String sql = "update habits set swit = "+swit+" where hname='" + hname + "'";
        db.execSQL(sql);
    }

    //获取查看的习惯已经打卡的日期,返回存放已打卡日期的int数组
    public int[] getDates(String hname) {
        int[] dates;//存放结果的int数组
        int count;//数组长度 通过查询记录获得
        String sql1 = "select count(*) from daka where hname = '" + hname + "'";
        Cursor cursor1 = db.rawQuery(sql1, null);
        cursor1.moveToFirst();
        count = cursor1.getInt(0);
        dates = new int[count];  ///获取该习惯打卡总数后，实例化int数组，准备存数据

        String sql2 = "select dakadate from daka where hname = '" + hname + "'";
        Cursor cursor2 = db.rawQuery(sql2, null);
        cursor2.moveToFirst();
        int i = 0;
        while (!cursor2.isAfterLast()) {//获取日期
            String s1 = cursor2.getString(0);
            dates[i++] = Integer.parseInt(s1.substring(6, 8));
            cursor2.moveToNext();
        }
        //while过后，应当有count==i==h.length，且s[]下标范围0至i-1

        return dates;
    }


}
