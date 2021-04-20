package com.application.littlehabit.Fragment;

import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.application.littlehabit.Login;
import com.application.littlehabit.R;


public class fragment3 extends Fragment {

    //声明头像按钮
    private Button touxiang;
    private View view;
    private TextView txtAccountName;




    public fragment3() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fg3_mine, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        initView();

        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });

    }


    void initView(){
        touxiang = view.findViewById(R.id.btnTouxiang);
        txtAccountName = view.findViewById(R.id.txtAccountName);
    }





}