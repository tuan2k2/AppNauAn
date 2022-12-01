package com.example.cookpro.model;

public class foodModel {
 private String anhmonan ,  tenmonan , tacgia, anhtacgia , tendanhmuc;

    public foodModel(String anhmonan, String tenmonan, String tacgia, String anhtacgia , String tendanhmuc) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.tacgia = tacgia;
        this.anhtacgia = anhtacgia;
        this.tendanhmuc = tendanhmuc;
    }

    public foodModel() {
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
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

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getAnhtacgia() {
        return anhtacgia;
    }

    public void setAnhtacgia(String anhtacgia) {
        this.anhtacgia = anhtacgia;
    }
}
