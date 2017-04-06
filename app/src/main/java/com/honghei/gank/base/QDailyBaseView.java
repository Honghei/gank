package com.honghei.gank.base;

import com.honghei.gank.bean.daily.FeedsBean;
import com.honghei.gank.ui.presenter.QDailyPresenter;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/4/4  19:26
 * @desc ${TODD}
 */
public interface QDailyBaseView extends BaseView<QDailyPresenter> {

    void onLoading();

    void onError();

    void onSuccess(List<FeedsBean> feedsBeen);

    void onRefrash();

    void onLoadMore();

    void setBanner(List<String> images, List<String> titles,List<String> appviews);

}
