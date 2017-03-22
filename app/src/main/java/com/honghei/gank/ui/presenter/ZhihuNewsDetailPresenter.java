package com.honghei.gank.ui.presenter;

import android.content.Context;

import com.honghei.gank.api.ApiFactory;
import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;
import com.honghei.gank.bean.zhihunews.NewsDetailBean;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Honghei
 * @time 2017/3/16  11:15
 * @desc 知乎详细信息页面的presenter
 */
public class ZhihuNewsDetailPresenter implements BasePresenter<ZhihuNewsDetailBaseView> {
    private ZhihuNewsDetailBaseView mView;
    private Context mContext;
    public ZhihuNewsDetailPresenter(ZhihuNewsDetailBaseView view, Context context){
        mView = view;
        mContext = context;
    }



    public void getNewsDetail(String id){
        ApiFactory.getZhihuApiSingleton().getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsDetailBean>() {
                    @Override
                    public void call(NewsDetailBean newsDetailBean) {
                        mView.loadUrl(newsDetailBean.getShare_url());
                    }
                });


    }



}
