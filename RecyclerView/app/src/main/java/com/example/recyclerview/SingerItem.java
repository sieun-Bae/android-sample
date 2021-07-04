package com.example.recyclerview;

public class SingerItem {
    String name;
    String mobile;

    //constructor
    public SingerItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

