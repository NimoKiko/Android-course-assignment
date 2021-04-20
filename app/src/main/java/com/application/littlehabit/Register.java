package com.application.littlehabit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    //声明返回,注册按钮
    private Button btnBack,btnRegister;
    //声明账号密码编辑框
    private EditText editPhone,editPassword,editResurePSD;
    //获取手机号，密码，确认密码的字符串
    String username,password,resurepwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();

        //设置返回按钮的点击事件
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置注册按钮的点击事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });



    }

    void initView(){
        btnBack = this.findViewById(R.id.btnBack);
        btnRegister = this.findViewById(R.id.btnRegister);

    }




}
