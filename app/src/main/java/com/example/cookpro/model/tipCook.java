package com.example.cookpro.model;

public class tipCook {
    String cauhoi , traloi , imgtipcook;

    public tipCook() {
    }

    public tipCook(String cauhoi, String traloi, String imgtipcook) {
        this.cauhoi = cauhoi;
        this.traloi = traloi;
        this.imgtipcook = imgtipcook;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public String getImgtipcook() {
        return imgtipcook;
    }

    public void setImgtipcook(String imgtipcook) {
        this.imgtipcook = imgtipcook;
    }
}
