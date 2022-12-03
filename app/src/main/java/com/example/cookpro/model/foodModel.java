package com.example.cookpro.model;

public class foodModel {
 private String anhmonan ,  tenmonan ,
         tacgia, anhtacgia , tendanhmuc  ,
         time , gthmonan , ngaydang ,nguyenlieu
         ,songuoian ,video;

    public foodModel(String anhmonan, String tenmonan, String tacgia, String anhtacgia , String tendanhmuc) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.tacgia = tacgia;
        this.anhtacgia = anhtacgia;
        this.tendanhmuc = tendanhmuc;
    }

    public foodModel(String anhmonan, String tenmonan, String tacgia, String anhtacgia, String tendanhmuc, String time, String gthmonan, String ngaydang, String nguyenlieu, String songuoian, String video) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.tacgia = tacgia;
        this.anhtacgia = anhtacgia;
        this.tendanhmuc = tendanhmuc;
        this.time = time;
        this.gthmonan = gthmonan;
        this.ngaydang = ngaydang;
        this.nguyenlieu = nguyenlieu;
        this.songuoian = songuoian;
        this.video = video;
    }

    public foodModel() {
    }

    public foodModel(String anhmonan, String tenmonan, String tacgia, String anhtacgia, String time, String gthmonan,
                     String ngaydang, String nguyenlieu, String songuoian, String video) {
        this.anhmonan = anhmonan;
        this.tenmonan = tenmonan;
        this.tacgia = tacgia;
        this.anhtacgia = anhtacgia;
        this.time = time;
        this.gthmonan = gthmonan;
        this.ngaydang = ngaydang;
        this.nguyenlieu = nguyenlieu;
        this.songuoian = songuoian;
        this.video = video;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGthmonan() {
        return gthmonan;
    }

    public void setGthmonan(String gthmonan) {
        this.gthmonan = gthmonan;
    }

    public String getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(String ngaydang) {
        this.ngaydang = ngaydang;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getSonguoian() {
        return songuoian;
    }

    public void setSonguoian(String songuoian) {
        this.songuoian = songuoian;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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
