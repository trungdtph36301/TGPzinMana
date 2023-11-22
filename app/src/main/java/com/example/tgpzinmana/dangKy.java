package com.example.tgpzinmana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgpzinmana.dao.adMin_dao;
import com.example.tgpzinmana.model.Admin;

import java.util.ArrayList;

public class dangKy extends AppCompatActivity {
Admin admin;
adMin_dao adMinDao;
ArrayList<Admin> list= new ArrayList<Admin>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        Button btndangkyb = findViewById(R.id.btndangkyb);
        TextView txtquayve = findViewById(R.id.txtquayve);
        EditText edtpasb = findViewById(R.id.edtpasb);
        EditText edthoten = findViewById(R.id.edthoten);
        EditText edtnameb = findViewById(R.id.edtnameb);
        EditText edtcfpasb = findViewById(R.id.edtcfpasb);

        adMinDao = new adMin_dao(this);
        list = adMinDao.selectAll();
        txtquayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(dangKy.this,Login.class);
                startActivity(intent);
            }
        });
        btndangkyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(dangKy.this,Login.class);
                String tenDN = edtnameb.getText().toString();
                String matkhau = edtpasb.getText().toString();
                String hoten = edthoten.getText().toString();
                String cfpas= edtcfpasb.getText().toString();
                admin= new Admin(tenDN,hoten,matkhau);
                if (TextUtils.isEmpty(hoten)||TextUtils.isEmpty(tenDN)|TextUtils.isEmpty(matkhau)|TextUtils.isEmpty(cfpas)){
                    Toast.makeText(dangKy.this, "Vui lòng nhập đầy đủ dl", Toast.LENGTH_SHORT).show();
                }else{
                    if (cfpas.equalsIgnoreCase(matkhau)){
                        if (adMinDao.insert(admin)){
                            list.clear();//xoa toan bo dl
                            list.addAll(adMinDao.selectAll());//lấy toàn bộ sl trong bảng để add vào list
                            //cập nhật lại dl cho adapter
                            Toast.makeText(dangKy.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(dangKy.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(dangKy.this, "Vui lòng nhập lại 2 mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
                startActivity(intent);
            }
        });
    }
}