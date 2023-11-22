package com.example.tgpzinmana;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tgpzinmana.frg.frg_donhang;
import com.example.tgpzinmana.frg.frg_sanPham;
import com.example.tgpzinmana.frg.frg_them;
import com.example.tgpzinmana.frg.frg_tongQuan;
import com.example.tgpzinmana.frg.frg_vanchuyen;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class bottom extends AppCompatActivity {
BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        bottomNavigationView = findViewById(R.id.bottomnav);
        //sử lý sự kiện khi chọn item
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if (item.getItemId()==R.id.tongquan){
                   frg_tongQuan frgTongQuan= new frg_tongQuan();
                   replaceFrg(frgTongQuan);
               }else
                   if (item.getItemId()==R.id.donHang) {
                       frg_donhang frgDonhang = new frg_donhang();
                       replaceFrg(frgDonhang);
                   }else
                       if (item.getItemId()==R.id.vanChuyen){
                           frg_vanchuyen frgVanchuyen = new frg_vanchuyen();
                           replaceFrg(frgVanchuyen);
                       }else
                           if (item.getItemId()==R.id.sanPham) {
                              frg_sanPham frgSanPham = new frg_sanPham();
                              replaceFrg(frgSanPham);
                           }else
                               if (item.getItemId()==R.id.them){
                                   frg_them frgThem= new frg_them();
                                   replaceFrg(frgThem);
                               }

                           return true;
            }
        });

    }
    public void replaceFrg(Fragment frg){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frmbottom,frg).commit();
    }
}