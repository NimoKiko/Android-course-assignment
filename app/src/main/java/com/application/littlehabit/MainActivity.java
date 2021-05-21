package com.application.littlehabit;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.littlehabit.Fragment.fragment1;
import com.application.littlehabit.Fragment.fragment2;
import com.application.littlehabit.Fragment.fragment3;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    //底部三个导航布局：今日，全部，我的
    private LinearLayout layoutToday,layoutAll,layoutMine;
    //底部四个导航布局的图片按钮
    private ImageView imgToday,imgAll,imgMine;
    //初始化三个Fragment
    private Fragment fg1_habit_grid,fg2_all_habit,fg3_mine;
    //初始化标题文字
    private TextView top_text;
    //初始化添加习惯按钮
    private Button btnAddHabit;
    //数据库相关变量
    private MySqliteHelper helper;
    private SQLiteDatabase db;
    private DBManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //数据库变量初始化
        helper = DBManager.getIntance(this);
        db = helper.getWritableDatabase();//创建或打开数据库
        mgr = new DBManager(db);
        //创建表
        mgr.createTableOrNot();

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        initView();
        setDefaultFragment();

        layoutToday.setOnClickListener(this);
        layoutAll.setOnClickListener(this);
        layoutMine.setOnClickListener(this);
        btnAddHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddHabit.class);
                startActivity(intent);
            }
        });

    }


    void initView(){

        layoutToday = this.findViewById(R.id.layoutToday);
        layoutAll = this.findViewById(R.id.layoutAll);
        layoutMine = this.findViewById(R.id.layoutMine);
        imgToday = this.findViewById(R.id.imgToday);
        imgAll = this.findViewById(R.id.imgAll);
        imgMine = this.findViewById(R.id.imgMine);
        top_text= this.findViewById(R.id.top_text);
        btnAddHabit = this.findViewById(R.id.btnAddHabit);

    }


    @Override
    public void onClick(View v) {



        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        imgToday.setImageResource(R.drawable.ic_home_1_normal);
        imgAll.setImageResource(R.drawable.ic_all_normal);
        imgMine.setImageResource(R.drawable.ic_more_normal);

        switch (v.getId()){
            case R.id.layoutToday:
                top_text.setText("今日习惯");
                fg1_habit_grid = new fragment1();
                ((fragment1) fg1_habit_grid).setDBManager(mgr);
                btnAddHabit.setVisibility(View.VISIBLE);
                transaction.replace(R.id.content,fg1_habit_grid);
                imgToday.setImageResource(R.drawable.ic_home_1_select);
                break;
            case R.id.layoutAll:
                top_text.setText("全部习惯");
                fg2_all_habit = new fragment2();
                ((fragment2)fg2_all_habit).setDBManager(mgr);
                btnAddHabit.setVisibility(View.GONE);
                transaction.replace(R.id.content,fg2_all_habit);
                imgAll.setImageResource(R.drawable.ic_all_select);
                break;
            case R.id.layoutMine:
                top_text.setText("个人中心");
                fg3_mine = new fragment3();
                btnAddHabit.setVisibility(View.GONE);
                transaction.replace(R.id.content,fg3_mine);
                imgMine.setImageResource(R.drawable.ic_more_select);
                break;
        }
        transaction.commit();
    }


    // 设置默认进来是tab 显示的页面
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        top_text.setText("今日习惯");
        fg1_habit_grid = new fragment1();
        ((fragment1) fg1_habit_grid).setDBManager(mgr);
        transaction.replace(R.id.content,fg1_habit_grid);
        imgToday.setImageResource(R.drawable.ic_home_1_select);
        transaction.commit();
    }


}