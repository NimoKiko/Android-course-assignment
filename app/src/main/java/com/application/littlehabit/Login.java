package com.application.littlehabit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.application.littlehabit.Fragment.fragment3;

public class Login extends AppCompatActivity {

    //声明返回，登录按钮
    private Button btnCancel,btnLogin,btnTouxiang;
    //声明注册按钮
    private TextView btnRegister,txtAccountName;
    //声明账号密码编辑框
    private EditText editPhone,editPassword;
    //获取文本框内容
    String username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        initView();

        //设置取消登录按钮点击事件
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置注册按钮的点击事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivityForResult(intent,1);
            }
        });

        //设置登录按钮的点击事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }


    void initView(){

        btnCancel = this.findViewById(R.id.btn_cancel);
        btnLogin = this.findViewById(R.id.btnLogin);
        btnRegister = this.findViewById(R.id.txtRegist);
        btnTouxiang = this.findViewById(R.id.btnTouxiang);
        txtAccountName = this.findViewById(R.id.txtAccountName);
    }


}
