package com.example.league;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Competition {
    String flag;
    String textTitle;
    String textDescription;
    String visitWeb;
    ArrayList<String> images= new ArrayList<>();

    Competition(){

    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getVisitWeb() {
        return visitWeb;
    }

    public void setVisitWeb(String visitWeb) {
        this.visitWeb = visitWeb;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> a) {
        this.images = a;
    }

}
