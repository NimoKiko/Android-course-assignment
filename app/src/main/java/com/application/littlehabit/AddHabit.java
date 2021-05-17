package com.application.littlehabit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddHabit extends AppCompatActivity {

    //定义返回,确定按钮
    private Button btnBack,btnYes;
    //定义RadioGroup
    private RadioGroup radioGroup;
    //定义图标
    private ImageView imgHabit_Lable;
    //定义时段按钮
    private Button anytime,morning,afternoon,evening;
    //定义频次按钮 每周，每天，每月
    private Button everyday,everyweek,everymonth;
    //定义频次文本
    private TextView txtSetTimes;
    //定义列表
    private ListView list;
    //测试
    private String[] buttons = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pimeapple","Cherry","Mango","Apple","Banana"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addhabits);

        initView();

        //返回事件
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //选择图标事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ChoosableImg1:
                        imgHabit_Lable.setImageResource(R.drawable.habit_1);
                        break;
                    case R.id.ChoosableImg2:
                        imgHabit_Lable.setImageResource(R.drawable.habit_2);
                        break;
                    case R.id.ChoosableImg3:
                        imgHabit_Lable.setImageResource(R.drawable.habit_3);
                        break;
                    case R.id.ChoosableImg4:
                        imgHabit_Lable.setImageResource(R.drawable.habit_4);
                        break;
                    case R.id.ChoosableImg5:
                        imgHabit_Lable.setImageResource(R.drawable.habit_5);
                        break;


                }
            }
        });

        //选择时段点击事件
        anytime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anytime.setBackgroundResource(R.drawable.shape2_selected);
                anytime.setTextColor(getResources().getColor(R.color.white));
                morning.setBackgroundResource(R.drawable.shape2);
                morning.setTextColor(getResources().getColor(R.color.black));
                afternoon.setBackgroundResource(R.drawable.shape2);
                afternoon.setTextColor(getResources().getColor(R.color.black));
                evening.setBackgroundResource(R.drawable.shape2);
                evening.setTextColor(getResources().getColor(R.color.black));
            }
        });
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anytime.setBackgroundResource(R.drawable.shape2);
                anytime.setTextColor(getResources().getColor(R.color.black));
                morning.setBackgroundResource(R.drawable.shape2_selected);
                morning.setTextColor(getResources().getColor(R.color.white));
                afternoon.setBackgroundResource(R.drawable.shape2);
                afternoon.setTextColor(getResources().getColor(R.color.black));
                evening.setBackgroundResource(R.drawable.shape2);
                evening.setTextColor(getResources().getColor(R.color.black));
            }
        });
        afternoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anytime.setBackgroundResource(R.drawable.shape2);
                anytime.setTextColor(getResources().getColor(R.color.black));
                morning.setBackgroundResource(R.drawable.shape2);
                morning.setTextColor(getResources().getColor(R.color.black));
                afternoon.setBackgroundResource(R.drawable.shape2_selected);
                afternoon.setTextColor(getResources().getColor(R.color.white));
                evening.setBackgroundResource(R.drawable.shape2);
                evening.setTextColor(getResources().getColor(R.color.black));
            }
        });
        evening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anytime.setBackgroundResource(R.drawable.shape2);
                anytime.setTextColor(getResources().getColor(R.color.black));
                morning.setBackgroundResource(R.drawable.shape2);
                morning.setTextColor(getResources().getColor(R.color.black));
                afternoon.setBackgroundResource(R.drawable.shape2);
                afternoon.setTextColor(getResources().getColor(R.color.black));
                evening.setBackgroundResource(R.drawable.shape2_selected);
                evening.setTextColor(getResources().getColor(R.color.white));
            }
        });

        //设置频次按钮点击事件
        everyday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                everyday.setBackgroundResource(R.drawable.shape2_selected);
                everyday.setTextColor(getResources().getColor(R.color.white));
                everyweek.setBackgroundResource(R.drawable.shape2);
                everyweek.setTextColor(getResources().getColor(R.color.black));
                everymonth.setBackgroundResource(R.drawable.shape2);
                everymonth.setTextColor(getResources().getColor(R.color.black));
                txtSetTimes.setText("每天");
            }
        });
        everyweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                everyday.setBackgroundResource(R.drawable.shape2);
                everyday.setTextColor(getResources().getColor(R.color.black));
                everyweek.setBackgroundResource(R.drawable.shape2_selected);
                everyweek.setTextColor(getResources().getColor(R.color.white));
                everymonth.setBackgroundResource(R.drawable.shape2);
                everymonth.setTextColor(getResources().getColor(R.color.black));
                txtSetTimes.setText("每周");
            }
        });
        everymonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                everyday.setBackgroundResource(R.drawable.shape2);
                everyday.setTextColor(getResources().getColor(R.color.black));
                everyweek.setBackgroundResource(R.drawable.shape2);
                everyweek.setTextColor(getResources().getColor(R.color.black));
                everymonth.setBackgroundResource(R.drawable.shape2_selected);
                everymonth.setTextColor(getResources().getColor(R.color.white));
                txtSetTimes.setText("每月");
            }
        });


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter adapter = new ArrayAdapter(AddHabit.this, android.R.layout.simple_list_item_1,buttons);//借助ArrayAdapter实现数据传递
                list.setAdapter(adapter);

                Intent intent = new Intent(AddHabit.this,MainActivity.class);
                startActivity(intent);
            }
        });










    }

    //初始化按钮
    void initView(){
        btnBack = this.findViewById(R.id.btnBack);
        btnYes = this.findViewById(R.id.btnYes);
        radioGroup = this.findViewById(R.id.radioGroup);
        imgHabit_Lable = this.findViewById(R.id.imgHabit_Lable);
        anytime = this.findViewById(R.id.anytime);
        morning = this.findViewById(R.id.morning);
        afternoon = this.findViewById(R.id.afternoon);
        evening = this.findViewById(R.id.evening);
        everyday = this.findViewById(R.id.btnEveryDay);
        everyweek = this.findViewById(R.id.btnEveryWeek);
        everymonth = this.findViewById(R.id.btnEveryMonth);
        txtSetTimes = this.findViewById(R.id.txtSetTimes);
        list = this.findViewById(R.id.ListViewHabit);
    }

}
