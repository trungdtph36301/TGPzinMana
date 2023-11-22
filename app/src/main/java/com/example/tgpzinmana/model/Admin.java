package com.example.tgpzinmana.model;

public class Admin {
    private int maAdmin;
    private String tenDN;
    private String hoten;
    private String matKhau;

    public Admin() {
        this.maAdmin = maAdmin;
        this.tenDN = tenDN;
        this.hoten = hoten;
        this.matKhau = matKhau;
    }

    public Admin(String tenDN, String hoten, String matKhau) {
        this.tenDN = tenDN;
        this.hoten = hoten;
        this.matKhau = matKhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(int maAdmin) {
        this.maAdmin = maAdmin;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
