package com.example.cookpro.model;

import java.util.List;

public class titleModel {
    private String nameTitle;
    private List<foodModel> foodModelList;

    public titleModel(String nameTitle, List<foodModel> foodModelList) {
        this.nameTitle = nameTitle;
        this.foodModelList = foodModelList;
    }


    public titleModel() {
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public List<foodModel> getFoodModelList() {
        return foodModelList;
    }

    public void setFoodModelList(List<foodModel> foodModelList) {
        this.foodModelList = foodModelList;
    }
}
