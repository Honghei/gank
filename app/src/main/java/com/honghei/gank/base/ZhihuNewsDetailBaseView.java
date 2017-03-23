package com.honghei.gank.base;

/**
 * @author Honghei
 * @time 2017/3/16  11:14
 * @desc ${TODD}
 */
public interface ZhihuNewsDetailBaseView<T> extends BaseView<T> {

    void onLoading();

    void onError();

    void loadDataWithBaseUrl(String baseUrl,String data);

    void loadUrl(String url);

    void setToolbarTitle(String title);

    void setTitleImageRes(String url);



}
