package com.example.cookpro.model;

public class danhMucModel {
    String tendanhmuc , anhdanhmuc;

    public danhMucModel(String tendanhmuc, String anhdanhmuc) {
        this.tendanhmuc = tendanhmuc;
        this.anhdanhmuc = anhdanhmuc;
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
