package com.honghei.gank.api;

import com.honghei.gank.bean.gank.MeiZhi;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Honghei
 * @time 2017/3/26  20:16
 * @desc ${TODD}
 */
public interface GankApi {

    @GET("data/福利/10/{page}")
    Observable<MeiZhi> getMeizhiData(@Path("page") int page);
}
