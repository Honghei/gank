package com.honghei.gank.api;

/**
 * 统一提供
 */
public class ApiFactory {

    protected static final Object monitor = new Object();
    static ZhihuApi zhihuApiSingleton = null;
    static GankApi gankApiSingleton = null;

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


}
