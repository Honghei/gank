package com.honghei.gank.ui.presenter;

import android.content.Context;

import com.honghei.gank.api.ApiFactory;
import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.ZhihuNewsItemBaseView;
import com.honghei.gank.bean.zhihunews.ZhihuNewsBefore;
import com.honghei.gank.bean.zhihunews.ZhihuNewsLatest;
import com.honghei.gank.ui.fragment.ZhihuNewsFragment;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Honghei
 * @time 2017/3/14  14:51
 * @desc ${TODD}
 */
public class ZhihuNewsItemPresenter implements BasePresenter<ZhihuNewsItemBaseView> {
    private Context mContext;
    private ZhihuNewsItemBaseView view;
    private ZhihuNewsLatest mZhihuNewsLatest;

    public ZhihuNewsItemPresenter(ZhihuNewsItemBaseView view, Context context){
        this.view = view;
        this.mContext = context;
    }

    public void getZhihuItemNews(){
        //进行网络请求

        ApiFactory.getZhihuApiSingleton().getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ZhihuNewsLatest>() {
                    @Override
                    public void call(ZhihuNewsLatest zhihuNewsLatest) {

                        if(view instanceof ZhihuNewsFragment){
                            handleBanner(zhihuNewsLatest);
                            setZhihuNewsLatest(zhihuNewsLatest);
                        }

                    }
                });

    }

    public void getBeforeZhihuNews(String date){
        ApiFactory.getZhihuApiSingleton().getBeforetNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ZhihuNewsBefore>() {
                    @Override
                    public void call(ZhihuNewsBefore zhihuNewsBefore) {
                        //数据请求完成。进行数据显示。
                        view.setRecyclerViewDatas(zhihuNewsBefore.getStories());
                    }
                });
    }


    /**
     *处理轮播图数据，调用view层方法，进行数据展示
     */
    private void handleBanner(ZhihuNewsLatest bean){
        if(bean == null){
            //// TODO: 如果是空，表示数据请求失败，应该调用view层的相关方法，进行ui展示。
            return;
        }
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        List<ZhihuNewsLatest.TopStoriesBean> top_stories = bean.getTop_stories();
        if(top_stories == null || top_stories.size() == 0){
            //此处返回一个banner为空的提示。
            return;
        }
        for(ZhihuNewsLatest.TopStoriesBean topStoriy: top_stories){
            images.add(topStoriy.getImage());
            titles.add(topStoriy.getTitle());
        }
        view.setBanner(images,titles);
        view.setHeaderView();
        view.setRecyclerViewDatas(bean.getStories());

    }

    //方便activity和fragment获取
    public ZhihuNewsLatest getZhihuNewsLatest(){
        return mZhihuNewsLatest;
    }
    //在可以获得bean的地方进行赋值。
    private void setZhihuNewsLatest(ZhihuNewsLatest zhihuNewsLatest){
        this.mZhihuNewsLatest = zhihuNewsLatest;
    }
}
