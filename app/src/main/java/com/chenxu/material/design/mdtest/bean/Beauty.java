package com.chenxu.material.design.mdtest.bean;

/**
 * Created by Administrator on 2019/3/22 0022.
 */
public class Beauty {
    private String name;
    private int imageId;

    public Beauty(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
