package com.honghei.gank.ui.presenter;

import android.util.Log;

import com.honghei.gank.api.ApiFactory;
import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.GankBaseView;
import com.honghei.gank.bean.gank.MeiZhi;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Honghei
 * @time 2017/3/26  20:28
 * @desc ${TODD}
 */
public class GankPresenter implements BasePresenter<GankBaseView> {
    private GankBaseView view;
    public GankPresenter(GankBaseView view){
        this.view = view;
    }
    private List<MeiZhi.ResultsBean>  mLatestResults = new ArrayList<>();

    public void handleWelfare(final int page){
        ApiFactory.getGankApiSingleton().getMeizhiData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MeiZhi>() {
                    @Override
                    public void call(MeiZhi meiZhi) {
                       doRefrashOrLoadMore(page,meiZhi);
                    }
                });

    }


    private void doRefrashOrLoadMore(int page,MeiZhi meiZhi){
        Log.i("hongheibisheng",meiZhi.getResults().toString());
        if(page == 1){
            //判断刷新内容是否更新。
            if(mLatestResults.size() == 0){
                mLatestResults = meiZhi.getResults();
                view.setRecyclerViewDatas(meiZhi.getResults());
            }else{
                checkDataAndRefrash(meiZhi);
            }
        }else{
            view.setRecyclerViewDatas(meiZhi.getResults());
        }
    }

    private void checkDataAndRefrash(MeiZhi meiZhi){
         List<MeiZhi.ResultsBean> tempList = new ArrayList<>();
          List<MeiZhi.ResultsBean> latestResults = meiZhi.getResults();
        for(MeiZhi.ResultsBean latestResult: latestResults){
            for(MeiZhi.ResultsBean beforeResult : mLatestResults){
                if(beforeResult.get_id() != null && beforeResult.get_id().equals(latestResult.get_id())){
                    tempList.add(latestResult);
                }
            }
        }

        for(MeiZhi.ResultsBean temp : tempList){
            latestResults.remove(temp);
        }

        if(latestResults.size() != 0){
            view.setRecyclerViewLatestDatas(latestResults);
            mLatestResults = meiZhi.getResults();
        }

        view.stopRefrash();
    }


}
