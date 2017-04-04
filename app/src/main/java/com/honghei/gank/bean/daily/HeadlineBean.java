package com.honghei.gank.bean.daily;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/4/4  8:51
 * @desc ${TODD}
 */
public class HeadlineBean {
    /**
     * list : []
     * headline_genre : 1
     */

    private int headline_genre;
    private List<?> list;

    public int getHeadline_genre() {
        return headline_genre;
    }

    public void setHeadline_genre(int headline_genre) {
        this.headline_genre = headline_genre;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
