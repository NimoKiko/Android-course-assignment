package com.application.littlehabit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HabitListItemAdapter extends ArrayAdapter<HabitListItem> {

    private int layoutId;

    //声明习惯名称，激励语句，习惯图标，习惯坚持天数
    private TextView HabitName,MotivationWord,HabitDay;
    private ImageView imgPath;

    public HabitListItemAdapter(@NonNull Context context, int layoutId, @NonNull List<HabitListItem> list) {
        super(context, layoutId, list);
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HabitListItem item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(layoutId,parent,false);
        //通过索引对应标签
        HabitName = view.findViewById(R.id.txtHabitNameSample);
        MotivationWord = view.findViewById(R.id.txtMotivationWord);
        HabitDay = view.findViewById(R.id.txtHabitDaySample);
        imgPath = view.findViewById(R.id.imgHabitLableSample);
        //设值
        HabitName.setText(item.getHabitName());
        MotivationWord.setText(item.getMotivationWord());
        HabitDay.setText(item.getDay());
        imgPath.setImageResource(getContext().getResources().getIdentifier(item.getImgPath(),"drawable",getContext().getApplicationInfo().packageName));

        return view;
    }

}
