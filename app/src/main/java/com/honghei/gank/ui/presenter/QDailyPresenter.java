package com.honghei.gank.ui.presenter;

import com.honghei.gank.api.ApiFactory;
import com.honghei.gank.base.BasePresenter;
import com.honghei.gank.base.QDailyBaseView;
import com.honghei.gank.bean.daily.ColumnsBean;
import com.honghei.gank.bean.daily.FeedsBean;
import com.honghei.gank.bean.daily.PostBean;
import com.honghei.gank.bean.daily.QDailyBean;

import java.util.List;
import java.util.Random;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author Honghei
 * @time 2017/4/4  19:32
 * @desc
 */
public class QDailyPresenter implements BasePresenter<QDailyBaseView> {

    private QDailyBaseView mView;

    public QDailyPresenter(QDailyBaseView baseView){
        mView = baseView;
    }


    public void getQdailyDatas(String num){
        ApiFactory.getQDailyApiSingleton().getQDailyResponse(num)
                .subscribeOn(Schedulers.io())
                .map(new Func1<QDailyBean, List<FeedsBean>>() {
                    @Override
                    public List<FeedsBean> call(QDailyBean dailyBean) {

                        return transformColumns2Feed(dailyBean);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<FeedsBean>>() {
                    @Override
                    public void call(List<FeedsBean> feedsBeen) {
                        mView.onSuccess(feedsBeen);
                    }
                });


    }



    private List<FeedsBean> transformColumns2Feed(QDailyBean dailyBean){

       if(dailyBean.getMeta().getStatus() != 200){
           return null;
       }

        List<ColumnsBean> columns = dailyBean.getResponse().getColumns();
        List<FeedsBean> feeds = dailyBean.getResponse().getFeeds();
        int columnsSize = columns.size();
        int feedsSize = feeds.size();

        for(int i = 0; i<columnsSize;i++){
            FeedsBean bean = new FeedsBean();
            PostBean postBean = new PostBean();
            postBean.setColumn(columns.get(i));
            bean.setPost(postBean);
            Random random = new Random();
            int insertPos = random.nextInt(feedsSize - 1);
            feeds.add(insertPos,bean);
            feedsSize = feeds.size();
        }

        return feeds;
    }


}
