package com.honghei.gank.api;

import com.honghei.gank.bean.daily.QDailyBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Honghei
 * @time 2017/4/2  17:11
 * @desc 好奇心日报接口
 */
public interface QDailyApi {

    @GET("homes/index/{num}.json")
    Observable<QDailyBean> getQDailyResponse(@Path("num") String num);

    /*@GET("options/index/{id}/{num}.json")
    Observable<DailyTimeLine> getDailyFeedDetail(@Path("id") String id,@Path("num") String num);*/

}
