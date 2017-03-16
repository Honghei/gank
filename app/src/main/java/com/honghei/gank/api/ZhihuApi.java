package com.honghei.gank.api;

import com.honghei.gank.bean.zhihunews.ZhihuNewsItem;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Werb on 2016/8/18.
 * Werb is Wanbo.
 * Contact Me : werbhelius@gmail.com
 * get Zhihu with retrofit
 */
public interface ZhihuApi {


   @GET("news/latest")
   Observable<ZhihuNewsItem> getLatestNews();
/*
    @GET("news/before/{time}")
    Observable<NewsTimeLine> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<News> getDetailNews(@Path("id") String id);*/
}
