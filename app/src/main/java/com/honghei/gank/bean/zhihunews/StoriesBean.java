package com.honghei.gank.bean.zhihunews;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/18  16:45
 * @desc ${TODD}
 */
public class StoriesBean {
    /**
     * images : ["https://pic2.zhimg.com/v2-dcc2361d23820aa53b0972c67b8033c1.jpg"]
     * type : 0
     * id : 9270660
     * ga_prefix : 031814
     * title : 只想吃点老鼠药自杀，结果非但没死，这药还救了好多人
     * multipic : true
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multipic;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
