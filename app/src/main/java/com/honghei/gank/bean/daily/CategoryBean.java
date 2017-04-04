package com.honghei.gank.bean.daily;

/**
 * @author Honghei
 * @time 2017/4/4  8:54
 * @desc ${TODD}
 */
public class CategoryBean {
    /**
     * id : 17
     * title : 设计
     * normal : http://img.qdaily.com/category/icon_black/20160606004538bpyX8Nm7dL4ns5WQ.png?imageMogr2/auto-orient/thumbnail/!128x128r/gravity/Center/crop/128x128/quality/85/ignore-error/1
     * normal_hl : http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1
     * image_lab : http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1
     * image_experiment :
     */

    private int id;
    private String title;
    private String normal;
    private String normal_hl;
    private String image_lab;
    private String image_experiment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getNormal_hl() {
        return normal_hl;
    }

    public void setNormal_hl(String normal_hl) {
        this.normal_hl = normal_hl;
    }

    public String getImage_lab() {
        return image_lab;
    }

    public void setImage_lab(String image_lab) {
        this.image_lab = image_lab;
    }

    public String getImage_experiment() {
        return image_experiment;
    }

    public void setImage_experiment(String image_experiment) {
        this.image_experiment = image_experiment;
    }
}
