package com.application.littlehabit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.pickerview.view.TimePickerView;

public class AddHabit extends AppCompatActivity {

    //定义返回,确定按钮
    private Button btnBack,btnYes;
    //定义RadioGroup
    private RadioGroup radioGroup;
    //定义图标
    private ImageView imgHabit_Lable;
    //定义时段按钮
    private Button[] btnTime = new Button[4];
    private String[] timeFram = {"任意时间", "晨间习惯", "午间习惯", "晚间习惯"};
    //定义频次按钮 每周，每天，每月
    private Button[] btnFrequent = new Button[3];
    private String[] frequent = {"每日", "每周", "每月"};
    //定义频次文本
    private TextView txtSetTimes;
    //定义列表
    private ListView list;

    private String img;
    private String time;
    private String frequency;
    private String strHour = "";
    private String strMin = "";

    //数据库相关变量
    private MySqliteHelper helper;
    private SQLiteDatabase db;
    private DBManager mgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addhabits);
        final String[] imgName = {"habit_1", "habit_2", "habit_3", "habit_4", "habit_5"};

        //数据库变量初始化
        helper = DBManager.getIntance(this);
        db = helper.getWritableDatabase();//创建或打开数据库
        mgr = new DBManager(db);

        initView();

        //返回事件
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置初始选择任意时间
        selectTime(0);
        //设置初始选择每天
        selectFrequent(0);

        //设置初始图标
        img = imgName[0];

        //选择图标事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ChoosableImg1:
                        imgHabit_Lable.setImageResource(R.drawable.habit_1);
                        img = imgName[0];
                        break;
                    case R.id.ChoosableImg2:
                        imgHabit_Lable.setImageResource(R.drawable.habit_2);
                        img = imgName[1];
                        break;
                    case R.id.ChoosableImg3:
                        imgHabit_Lable.setImageResource(R.drawable.habit_3);
                        img = imgName[2];
                        break;
                    case R.id.ChoosableImg4:
                        imgHabit_Lable.setImageResource(R.drawable.habit_4);
                        img = imgName[3];
                        break;
                    case R.id.ChoosableImg5:
                        imgHabit_Lable.setImageResource(R.drawable.habit_5);
                        img = imgName[4];
                        break;
                }
            }
        });

        //时间选择器
//        final TimePickerView





    }

    //初始化按钮
    void initView(){
        btnBack = this.findViewById(R.id.btnBackToHome);
        btnYes = this.findViewById(R.id.btnYes);
        radioGroup = this.findViewById(R.id.radioGroup);
        imgHabit_Lable = this.findViewById(R.id.imgHabit_Lable);
        btnTime[0] = (Button) findViewById(R.id.anytime);
        btnTime[1] = (Button) findViewById(R.id.morning);
        btnTime[2] = (Button) findViewById(R.id.evening);
        btnTime[3] = (Button) findViewById(R.id.afternoon);
        btnFrequent[0] = (Button) findViewById(R.id.btnEveryDay);
        btnFrequent[1] = (Button) findViewById(R.id.btnEveryWeek);
        btnFrequent[2] = (Button) findViewById(R.id.btnEveryMonth);
        txtSetTimes = this.findViewById(R.id.txtSetTimes);
        list = this.findViewById(R.id.ListViewHabit);
    }

    //选择时间段
    public void selectTime(int k) {
        for (int i = 0; i < 4; i++) {
            if (i == k) {
                btnTime[i].setTextColor(getResources().getColor(R.color.white));
                btnTime[i].setBackgroundResource(R.drawable.shape2_selected);
            } else {
                btnTime[i].setTextColor(getResources().getColor(R.color.black));
                btnTime[i].setBackgroundResource(R.drawable.shape2);
            }
        }
        time = timeFram[k];
    }
    //“任意时间”按钮点击事件
    public void time1(View view) {
        selectTime(0);
    }
    //“晨间习惯”按钮点击事件
    public void time2(View view) {
        selectTime(1);
    }
    //“午间习惯”按钮点击事件
    public void time3(View view) {
        selectTime(2);
    }
    //“晚间习惯”按钮点击事件
    public void time4(View view) {
        selectTime(3);
    }

    //设置频次按钮
    public void selectFrequent(int k) {
        for (int i = 0; i < 3; i++) {
            if (i == k) {
                btnFrequent[i].setTextColor(getResources().getColor(R.color.white));
                btnFrequent[i].setBackgroundResource(R.drawable.shape2_selected);
            } else {
                btnFrequent[i].setTextColor(getResources().getColor(R.color.black));
                btnFrequent[i].setBackgroundResource(R.drawable.shape3);
            }
        }
        frequency = frequent[k];
        TextView txtSetTimes = (TextView) findViewById(R.id.txtSetTimes);
        txtSetTimes.setText(frequent[k]);
    }

    //“每天”按钮点击事件
    public void frequent1(View view) {
        selectFrequent(0);
    }
    //“每周”按钮点击事件
    public void frequent2(View view) {
        selectFrequent(1);
    }
    //“每月”按钮点击事件
    public void frequent3(View view) {
        selectFrequent(2);
    }

}
