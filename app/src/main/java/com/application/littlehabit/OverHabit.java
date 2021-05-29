package com.application.littlehabit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OverHabit extends AppCompatActivity {

    private List<HabitListItem> list;
    private ListView overHabitListView;
    private HabitListItemAdapter itemAdapter;
    private Button btnOverHabitBackTofg3;

    private Habit[] habit;

    //数据库相关变量
    private MySqliteHelper helper;
    private SQLiteDatabase db;
    private DBManager mgr;


    @Override
    protected void onResume() {
        super.onResume();
        refresh_list();
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over_habit);

        //数据库变量初始化
        helper = DBManager.getIntance(this);
        db = helper.getWritableDatabase();//创建或打开数据库
        mgr = new DBManager(db);

        overHabitListView = this.findViewById(R.id.ListViewOverHabit);
        btnOverHabitBackTofg3 = this.findViewById(R.id.btnOverHabitBackTofg3);

        btnOverHabitBackTofg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        overHabitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OverHabit.this, HabitLog.class);
                intent.putExtra("isFinished",1);
                intent.putExtra("name",habit[position].hname);
                intent.putExtra("days",habit[position].days+"");
                intent.putExtra("insistedDays",habit[position].insisted_days+"");
                intent.putExtra("highdays",habit[position].highdays+"");
                intent.putExtra("createdate",habit[position].createdate);
                startActivity(intent);
            }
        });
        refresh_list();
    }

    public void refresh_list() {
        list = new ArrayList<HabitListItem>();
        habit = mgr.getHabit("任意时间", 0);
        for (int i = 0; i < habit.length; i++) {
            HabitListItem t = new HabitListItem(habit[i].hname, habit[i].htips, habit[i].days + "", habit[i].hIcon);
            list.add(t);
        }
        itemAdapter = new HabitListItemAdapter(this, R.layout.habit_list_item, list);
        overHabitListView.setAdapter(itemAdapter);
    }
}
