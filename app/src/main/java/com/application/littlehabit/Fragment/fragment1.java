package com.application.littlehabit.Fragment;

import android.os.Build;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import androidx.annotation.RequiresApi;

import com.application.littlehabit.DBManager;
import com.application.littlehabit.Habit;
import com.application.littlehabit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class fragment1 extends Fragment {

    public fragment1() {
        // Required empty public constructor
    }

    Habit[] habit;
    private View v;
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    //选择时间button
    private Button[] bt = new Button[4];
    //当前选择的时间段
    private String[] t = {"任意时间", "晨间习惯", "午间习惯", "晚间习惯"};
    private String time;

    //数据库manager
    private DBManager mgr;

    public void setDBManager(DBManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public void onResume() {
        super.onResume();
        selectTime(0);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fg1_habit_grid, container, false);
//        //选择时间button
//        bt[0] = (Button) v.findViewById(R.id.btn_anytime);
//        bt[1] = (Button) v.findViewById(R.id.btn_morning);
//        bt[2] = (Button) v.findViewById(R.id.btn_afternoon);
//        bt[3] = (Button) v.findViewById(R.id.btn_evening);
//
//        //设置默认时间
//        selectTime(0);
//        //选择时间事件
//        for (int i = 0; i < 4; i++) {
//            bt[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    switch (v.getId()) {
//                        case R.id.btn_anytime:
//                            selectTime(0);
//                            break;
//                        case R.id.btn_morning:
//                            selectTime(1);
//                            break;
//                        case R.id.btn_afternoon:
//                            selectTime(2);
//                            break;
//                        case R.id.btn_evening:
//                            selectTime(3);
//                            break;
//                    }
//                }
//            });
//        }
//
//        gview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                change_data(position);
//            }
//        });

//        return v;
    }

    //点击的时候更新数据
    private void change_data(int item_id) {
        if (habit[item_id].finished_num < habit[item_id].everyday_num) {
            habit[item_id].finished_num++;
            if (habit[item_id].finished_num == habit[item_id].everyday_num)
                habit[item_id].hIcon = habit[item_id].hIcon + "_gray";
            refresh_grid();
            Toast.makeText(getActivity(), habit[item_id].hname + "已打卡成功", Toast.LENGTH_SHORT).show();

            //更新数据库
            mgr.clickUpdateDB(habit[item_id].hname);
        } else {
            Toast.makeText(getActivity(), habit[item_id].hname + "已完成", Toast.LENGTH_SHORT).show();
        }
    }


    public void getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < habit.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("imgHabitLable", getResources().getIdentifier(habit[i].hIcon, "drawable", getContext().getApplicationInfo().packageName));
            map.put("txtHabitName", habit[i].hname);
            map.put("txtSignedInfo", habit[i].finished_num + "/" + habit[i].everyday_num);
            data_list.add(map);
        }
    }


    //选择时间事件
    public void selectTime(int k) {
        for (int i = 0; i < 4; i++) {
            if (k == i) {
                bt[i].setBackgroundResource(R.drawable.shape2_selected);
            } else {
                bt[i].setBackgroundResource(R.drawable.shape2);
            }
        }
        time = t[k];
        habit = mgr.getHabit(time, 1);
        for (int i = 0; i < habit.length; i++) {
            if (habit[i].finished_num == habit[i].everyday_num) {
                habit[i].hIcon = habit[i].hIcon + "_gray";
            }
        }
        refresh_grid();
    }

    //更新视图
    private void refresh_grid() {
        gview = (GridView) v.findViewById(R.id.GDVHabitInfo);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"imgHabitLable", "txtHabitName", "txtSignedInfo"};//传入数据
        int[] to = {R.id.imgHabitLable, R.id.txtHabitName, R.id.txtSignedInfo};//传出数据
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.grid_item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
    }

}