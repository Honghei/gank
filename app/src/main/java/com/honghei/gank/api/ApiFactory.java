package com.honghei.gank.api;

/**
 * 统一提供
 */
public class ApiFactory {

    protected static final Object monitor = new Object();
    static ZhihuApi zhihuApiSingleton = null;
    static GankApi gankApiSingleton = null;
    static QDailyApi sQDailyApiSingleton = null;

    //return Singleton
    public static ZhihuApi getZhihuApiSingleton() {
        synchronized (monitor) {
            if (zhihuApiSingleton == null) {
                zhihuApiSingleton = new ApiRetrofit().getZhihuApiService();
            }
            return zhihuApiSingleton;
        }
    }

    //return Singleton
    public static GankApi getGankApiSingleton() {
        synchronized (monitor) {
            if (gankApiSingleton == null) {
                gankApiSingleton = new ApiRetrofit().getGankApiService();
            }
            return gankApiSingleton;
        }
    }


    //return Singleton
    public static QDailyApi getQDailyApiSingleton() {
        synchronized (monitor) {
            if (sQDailyApiSingleton == null) {
                sQDailyApiSingleton = new ApiRetrofit().getQDailyApiService();
            }
            return sQDailyApiSingleton;
        }
    }




}
