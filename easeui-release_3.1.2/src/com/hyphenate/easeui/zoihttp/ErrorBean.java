package com.hyphenate.easeui.zoihttp;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/8/6
 */
public class ErrorBean {


    private String word;
    private int times;
    private int weight;
    private String attr;

    public void setWord(String word) {
        this.word = word;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getWord() {
        return word;
    }

    public int getTimes() {
        return times;
    }

    public int getWeight() {
        return weight;
    }

    public String getAttr() {
        return attr;
    }
}
