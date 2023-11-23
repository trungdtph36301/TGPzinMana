package com.example.tgpzinmana.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TPGzinMana.db";
    private static final int DATABASE_VERSION = 1;

    public DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tbAdmin= "create table adMin(" +
                "maAdMin integer primary key Autoincrement ," +
                "tenDN text  not null ," +
                "hoTen text  not null ," +
                "matKhau text not null )";
        sqLiteDatabase.execSQL(tbAdmin);
        String dtAdmin="insert into  adMin values(0,'admin','pham van tai','admin')";
        sqLiteDatabase.execSQL(dtAdmin);
        /*
create table AdMin(
maAdMin integer primary key Autoincrement ,
tenDN text  not null ,
matKhau text not null ,

)
create table sanPham(
maSP integer primary key autoincrement ,
tenSP text not null ,
soLuong integer not null ,
giaNhap integer not null ,
giaBan integer not null
)
create table nhaCC(
maNCC integer primary key autoincrement ,
tenNCC text not null ,
diaChi text not null ,
sdtNCC text not null
)

create table khachHang(
maKH integer primary key autoincrement ,
tenKH text not null ,
diaChiKH text not null ,
sdtKH text not null
)
create table donNhap(
maDN integer primary key autoincrement ,
maAdMin integer not null ,
maSP integer not null ,
maNCC integer not null ,
tongSL integer not null ,
tongDG integer not null ,
foreign key (maAdMin) references AdMin(maAdMin),
foreign key (maSP) references sanPham(maSP),
foreign key (maNCC)references nhaCC(maNCC)
)
create table donHang(
maDH integer primary key autoincrement ,
maAdMin integer not null ,
maSP integer not null ,
maKH integer not null ,
donGiaDH integer not null ,
tongSLDH integer not null ,
foreign key (maAdMin) references AdMin(maAdMin),
foreign key (maSP) references sanPham(maSP),
foreign key (maKH)references khachHang(maKH)
)
 */
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i!= i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS adMin");

            onCreate(sqLiteDatabase);
        }
    }
}
