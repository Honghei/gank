package com.honghei.gank.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Honghei
 * @time 2017/3/22  20:49
 * @desc ${TODD}
 */
public class LayoutUtil {

    /**
     * 设置某个View的margin
     *
     * @param view   需要设置的view
     * @param topPx    上边距
     * @return
     */
    public static ViewGroup.LayoutParams setViewMargin(View view,int topPx) {
        if (view == null) {
            return null;
        }


        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginParams = null;
        //获取view的margin设置参数
        if (params instanceof ViewGroup.MarginLayoutParams) {
            marginParams = (ViewGroup.MarginLayoutParams) params;
        } else {
            //不存在时创建一个新的参数
            marginParams = new ViewGroup.MarginLayoutParams(params);
        }

        //根据DP与PX转换计算值

        //设置margin
        marginParams.setMargins(0, topPx, 0,0);
        view.setLayoutParams(marginParams);
        return marginParams;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }



}
