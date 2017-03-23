package com.honghei.gank.ui;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.honghei.gank.R;
import com.youth.banner.loader.ImageLoader;

import static com.honghei.gank.MyApp.mContext;

/**
 * @author Honghei
 * @time 2017/3/16  9:01
 * @desc 为首页轮播图提供图片加载器。这里使用的是glide加载。
 */
public class GlideImageLoader extends ImageLoader {
    //单例设计，减少工具类的创建次数。
    private static GlideImageLoader mGlideImageLoader = null;

    private GlideImageLoader(){}

    public static GlideImageLoader getInstance(){
        if(mGlideImageLoader == null){
            synchronized (GlideImageLoader.class){
                if(mGlideImageLoader == null){
                    mGlideImageLoader = new GlideImageLoader();
                }
            }
        }
        return mGlideImageLoader;
    }
    //
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(mContext).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.mipmap.fillbitmap).error(R.mipmap.fillbitmap).into(imageView);

    }

}
