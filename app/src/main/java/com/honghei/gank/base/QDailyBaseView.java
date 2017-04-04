package com.honghei.gank.base;

import com.honghei.gank.ui.presenter.QDailyPresenter;

/**
 * @author Honghei
 * @time 2017/4/4  19:26
 * @desc ${TODD}
 */
public interface QDailyBaseView extends BaseView<QDailyPresenter> {

    void onLoading();

    void onError();

    void onSuccess();

    void onRefrash();

    void onLoadMore();



}
