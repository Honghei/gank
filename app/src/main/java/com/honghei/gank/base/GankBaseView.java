package com.honghei.gank.base;

import com.honghei.gank.bean.gank.MeiZhi;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/29  20:31
 * @desc ${TODD}
 */
public interface GankBaseView<T> extends BaseView<T> {

    void setRecyclerViewDatas(List<MeiZhi.ResultsBean> datas);



}
