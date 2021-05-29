package com.application.littlehabit.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.application.littlehabit.Login;
import com.application.littlehabit.OverHabit;
import com.application.littlehabit.R;


public class fragment3 extends Fragment {

    //声明头像按钮
    private Button touxiang;
    private View view;
    private TextView txtAccountName;
    private ConstraintLayout c1,c2,c3,c4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fg3_mine, container, false);

        initView();

        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OverHabit.class);
                startActivity(intent);
            }
        });

        return view;

    }

    void initView(){
        touxiang = view.findViewById(R.id.btnTouxiang);
        txtAccountName = view.findViewById(R.id.txtAccountName);
        c1 = view.findViewById(R.id.constraintlayoutTodayCard);
        c2 = view.findViewById(R.id.constraintlayoutOverhabit);
        c3 = view.findViewById(R.id.constraintlayoutHelp);
        c4 = view.findViewById(R.id.constraintlayoutHelp);
    }





}