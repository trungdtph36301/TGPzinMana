package com.example.tgpzinmana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgpzinmana.dao.adMin_dao;
import com.example.tgpzinmana.model.Admin;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText edtUserName, edtPassWord;
    CheckBox chkRememberPass;
    adMin_dao adMinDao;
    String strUserName, strPassWord;
    TextView txtsignUp;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUserName = findViewById(R.id.edtUsername);
        edtPassWord = findViewById(R.id.edtPassword);
        txtsignUp= findViewById(R.id.txtsignup);
        btnLogin = findViewById(R.id.btnLogin);
        chkRememberPass= findViewById(R.id.chkluumk);
        adMinDao = new adMin_dao(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this,bottom.class);

                strUserName = edtUserName.getText().toString().trim();
                    strPassWord = edtPassWord.getText().toString().trim();
                    if (strUserName.isEmpty() || strPassWord.isEmpty()) {
                        Toast.makeText(Login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    } else {
                        if (adMinDao.checkLogin(strUserName, strPassWord)) {
                            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }

            }
        });
        txtsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,dangKy.class);
                startActivity(intent);
            }
        });
    }
}