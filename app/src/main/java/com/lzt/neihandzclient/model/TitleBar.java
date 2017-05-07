package com.lzt.neihandzclient.model;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public class TitleBar {
    private String title;
    private int resouce;
    private String hint;

    public String getHint() {
        return hint;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResouce() {
        return resouce;
    }

    public void setResouce(int resouce) {
        this.resouce = resouce;
    }
}
