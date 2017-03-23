package com.honghei.gank.ui.presenter;

import android.content.Context;
import android.util.Log;

import com.honghei.gank.api.ApiFactory;
import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;
import com.honghei.gank.bean.zhihunews.NewsDetailBean;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author Honghei
 * @time 2017/3/16  11:15
 * @desc 知乎详细信息页面的presenter
 */
public class ZhihuNewsDetailPresenter implements BasePresenter<ZhihuNewsDetailBaseView> {
    private ZhihuNewsDetailBaseView mView;
    private Context mContext;
    public ZhihuNewsDetailPresenter(ZhihuNewsDetailBaseView view, Context context){
        mView = view;
        mContext = context;
    }



    public void getNewsDetail(String id){
        ApiFactory.getZhihuApiSingleton().getDetailNews(id)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsDetailBean>() {
                    @Override
                    public void call(NewsDetailBean newsDetailBean) {
                        handleNewsDetail(newsDetailBean);
                    }
                });

    }

    private void handleNewsDetail(NewsDetailBean newsDetailBean) {
        if(newsDetailBean == null){
            return;
        }


        Log.i("hongheibisheng",newsDetailBean.getCss().get(0));
        mView.loadDataWithBaseUrl(null,convertZhihuContent(newsDetailBean.getBody()));
        mView.setTitleImageRes(newsDetailBean.getImage());
        mView.setToolbarTitle(newsDetailBean.getTitle());

    }

    private String convertZhihuContent(String preResult) {

        preResult = preResult.replace("<div class=\"img-place-holder\">", "");
        preResult = preResult.replace("<div class=\"headline\">", "");


        //加载本地assets文件夹中的css
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/zhihu_daily.css\" type=\"text/css\">";

        String theme = "<body className=\"\" onload=\"onLoaded()\">";

        return new StringBuilder()
                .append("<!DOCTYPE html>\n")
                .append("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n")
                .append("<head>\n")
                .append("\t<meta charset=\"utf-8\" />")
                .append(css)
                .append("\n</head>\n")
                .append(theme)
                .append(preResult)
                .append("</body></html>").toString();
    }


}
