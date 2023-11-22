package com.example.tgpzinmana.dao;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.tgpzinmana.database.DBhelper;
import com.example.tgpzinmana.model.Admin;

import java.util.ArrayList;

public class adMin_dao {
    DBhelper dBhelper;
    public adMin_dao(Context context){
        dBhelper = new DBhelper(context);
    }
    public ArrayList<Admin> selectAll(){
        ArrayList<Admin> list= new ArrayList<Admin>();
        SQLiteDatabase db = dBhelper.getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery("select * from adMin", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Admin admin = new Admin();
                    admin.setMaAdmin(cursor.getInt(0));
                    admin.setTenDN(cursor.getString(1));
                    admin.setHoten(cursor.getString(2));
                    admin.setMatKhau(cursor.getString(3));
                    list.add(admin);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi", e);
        }
        return list;
    }
    public  boolean insert(Admin obj){
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maAdMin",obj.getMaAdmin());
        values.put("tenDN",obj.getTenDN());
        values.put("hoTen",obj.getHoten());
        values.put("matKhau",obj.getMatKhau());
        long row = db.insert("adMin",null,values);
        return (row>0);
    }
    public  boolean update(Admin obj){
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maAdMin",obj.getMaAdmin());
        values.put("tenDN",obj.getTenDN());
        values.put("hoTen",obj.getHoten());
        values.put("matKhau",obj.getMatKhau());
        long row = db.update("adMin",values,"maAdMin=?",new String[]{String.valueOf(obj.getMaAdmin())});
        return (row>0);
    }
    public  boolean delete(int maAdMin){
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        long row = db.delete("adMin","maAdMin=?",new String[]{String.valueOf(maAdMin)});
        return (row>0);
    }
    public boolean checkLogin(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dBhelper.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from adMin where tenDN=? and matKhau=? ",new String[]{username,password});
        int row = cursor.getCount();
        return (row>0);
    }
}
