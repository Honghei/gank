package com.honghei.gank.base;


import com.honghei.gank.bean.zhihunews.StoriesBean;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/16  10:22
 * @desc ${TODD}
 */
public interface ZhihuNewsItemBaseView<T> extends BaseView<T> {

    /**
     * @desc 设置轮播图信息
     * @param images
     * @param titles
     */
    void setBanner(List<String> images,List<String> titles);

    void setHeaderView();

    void setRecyclerViewDatas(List<StoriesBean> datas);

    void setRecyclerViewLatestDatas(List<StoriesBean> datas);

    void startRefresh();

    void stopRefresh();

}
