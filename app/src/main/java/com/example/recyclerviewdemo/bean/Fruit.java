package com.example.recyclerviewdemo.bean;

public class Fruit {
    private String name;
    private int img;
    private String desc;

    public Fruit() {
    }

    public Fruit(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public Fruit(String name, int img, String desc) {
        this.name = name;
        this.img = img;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
