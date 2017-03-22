package com.honghei.gank.api;

import com.honghei.gank.bean.zhihunews.NewsDetailBean;
import com.honghei.gank.bean.zhihunews.ZhihuNewsBefore;
import com.honghei.gank.bean.zhihunews.ZhihuNewsLatest;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Honghei on 2017/3/7.
 * get Zhihu with retrofit
 */
public interface ZhihuApi {


   @GET("news/latest")
   Observable<ZhihuNewsLatest> getLatestNews();

    @GET("news/before/{time}")
    Observable<ZhihuNewsBefore> getBeforetNews(@Path("time") String time);


    @GET("news/{id}")
    Observable<NewsDetailBean> getDetailNews(@Path("id") String id);
}
