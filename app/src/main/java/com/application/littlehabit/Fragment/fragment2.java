package com.application.littlehabit.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.application.littlehabit.DBManager;
import com.application.littlehabit.Habit;
import com.application.littlehabit.HabitListItem;
import com.application.littlehabit.HabitListItemAdapter;
import com.application.littlehabit.HabitLog;
import com.application.littlehabit.R;

import java.util.ArrayList;
import java.util.List;


public class fragment2 extends Fragment {

    //声明HabitListItem类的列表
    private List<HabitListItem> list;
    //声明ListView控件
    private ListView listViewHabit;
    //声明listview适配器
    private HabitListItemAdapter habitListItemAdapter;
    //声明habit数组
    private Habit[] habit;
    //声明数据库管理工具
    private DBManager mgr;
    //视图
    View view;

    public void setDBManager(DBManager mgr) {
        this.mgr = mgr;
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh_list();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fg2_all_habit, container, false);

        listViewHabit = view.findViewById(R.id.ListViewHabit);

        listViewHabit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HabitLog.class);
                intent.putExtra("isFinished",0);
                intent.putExtra("name",habit[position].hname);
                intent.putExtra("days",habit[position].days+"");
                intent.putExtra("insistedDays",habit[position].insisted_days+"");
                intent.putExtra("highdays",habit[position].highdays+"");
                intent.putExtra("createdate",habit[position].createdate);
                startActivity(intent);
            }
        });
        refresh_list();
        return view;
    }

    //刷新列表
    public void refresh_list(){
        list = new ArrayList<HabitListItem>();
        habit = mgr.getHabit("任意时间",1);//显示全部习惯标签
        for( int i = 0; i<habit.length ;i++){
            HabitListItem habitListItem = new HabitListItem(habit[i].hname,habit[i].htips,habit[i].days+"",habit[i].hIcon);
            list.add(habitListItem);
        }
        habitListItemAdapter = new HabitListItemAdapter(getActivity(),R.layout.habit_list_item,list);
        listViewHabit.setAdapter(habitListItemAdapter);
    }


}