package com.honghei.gank.base;

import android.view.View;

/**
 * @author Honghei
 * @time 2017/3/7  15:19
 * @desc 所有view的基类
 */
public interface BaseView<T> {
    /**
     * @param presenter
     * @desc 给view设置对应的presenter。
     */
     void setPresenter(T presenter);


    /**
     *@desc 初始化布局使用
     */
     void initView(View view);

}
