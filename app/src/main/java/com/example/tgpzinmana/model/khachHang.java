package com.example.tgpzinmana.model;

public class khachHang {
    private int maKH;
    private String tenKH;
    private String diachiKH;
    private String sdtKH;

    public khachHang(int maKH, String tenKH, String diachiKH, String sdtKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diachiKH = diachiKH;
        this.sdtKH = sdtKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiachiKH() {
        return diachiKH;
    }

    public void setDiachiKH(String diachiKH) {
        this.diachiKH = diachiKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }
}
