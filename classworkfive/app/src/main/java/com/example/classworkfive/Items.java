package com.example.classworkfive;

public class Items {

    private String itemName;
    private double itemPrice;
    private int itemImg;

    public Items(String itemName, double itemPrice, int itemImg) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemImg() {
        return itemImg;
    }

    public void setItemImg(int itemImg) {
        this.itemImg = itemImg;
    }
}
