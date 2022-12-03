package com.example.cookpro.model;

public class userModel {
    private String email;
    private String pass;
    private String fullname;
    private String quequan;
    private String nguoitheodoi;
    private String avatar;
    private String anhbia;
    private String anhmonan , tenmonan , time , gioithieu , songuoian;

    public userModel(String anhmonan, String tenmonan, String time, String gioithieu, String songuoian) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.time = time;
        this.gioithieu = gioithieu;
        this.songuoian = songuoian;
    }

    public String getAnhmonan() {
        return anhmonan;
    }

    public void setAnhmonan(String anhmonan) {
        this.anhmonan = anhmonan;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getSonguoian() {
        return songuoian;
    }

    public void setSonguoian(String songuoian) {
        this.songuoian = songuoian;
    }

    public userModel() {}

    public userModel(String fullName, String email) {
        this.fullname = fullName;
        this.email = email;
    }

    public String getAnhbia() {
        return anhbia;
    }

    public void setAnhbia(String anhbia) {
        this.anhbia = anhbia;
    }

    public userModel(String email, String pass, String fullname, String quequan, String nguoitheodoi, String avatar , String anhbia) {
        this.email = email;
        this.pass = pass;
        this.fullname = fullname;
        this.quequan = quequan;
        this.nguoitheodoi = nguoitheodoi;
        this.avatar = avatar;
        this.anhbia = anhbia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getNguoitheodoi() {
        return nguoitheodoi;
    }

    public void setNguoitheodoi(String nguoitheodoi) {
        this.nguoitheodoi = nguoitheodoi;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
