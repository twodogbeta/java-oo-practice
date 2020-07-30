package com.twu.Entity;

public class TopTag implements Cloneable {
    private String name;
    private int votes;
    private boolean isSuperTopSearch;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TopTag(String name) {
        this.name = name;
        this.votes = 0;
        this.isSuperTopSearch = false;
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes += votes;
    }

    public boolean isSuperTopSearch() {
        return isSuperTopSearch;
    }

    public void setSuperTopSearch(boolean superTopSearch) {
        isSuperTopSearch = superTopSearch;
    }

    @Override
    public String toString() {
        return this.name + " " + this.votes;
    }

    @Override
    //判断包内的权限
    public Object clone() throws CloneNotSupportedException {
        TopTag tag = (TopTag) super.clone();
        return tag;
    }
}