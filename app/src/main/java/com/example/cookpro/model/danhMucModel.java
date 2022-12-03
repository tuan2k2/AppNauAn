package com.example.cookpro.model;

public class danhMucModel {
    String tendanhmuc , anhdanhmuc , tenmonan, time , songuoian , gth ,anhmonan;

    public danhMucModel(String tendanhmuc, String anhdanhmuc) {
        this.tendanhmuc = tendanhmuc;
        this.anhdanhmuc = anhdanhmuc;
    }

    public danhMucModel(String tendanhmuc, String tenmonan, String time, String songuoian, String gth, String anhmonan) {
        this.tendanhmuc = tendanhmuc;
        this.tenmonan = tenmonan;
        this.time = time;
        this.songuoian = songuoian;
        this.gth = gth;
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

    public String getSonguoian() {
        return songuoian;
    }

    public void setSonguoian(String songuoian) {
        this.songuoian = songuoian;
    }

    public String getGth() {
        return gth;
    }

    public void setGth(String gth) {
        this.gth = gth;
    }

    public String getAnhmonan() {
        return anhmonan;
    }

    public void setAnhmonan(String anhmonan) {
        this.anhmonan = anhmonan;
    }

    public danhMucModel() {
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getAnhdanhmuc() {
        return anhdanhmuc;
    }

    public void setAnhdanhmuc(String anhdanhmuc) {
        this.anhdanhmuc = anhdanhmuc;
    }
}
