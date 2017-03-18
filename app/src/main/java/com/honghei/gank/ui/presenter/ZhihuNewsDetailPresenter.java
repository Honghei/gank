package com.honghei.gank.ui.presenter;

import android.content.Context;

import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;

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



}