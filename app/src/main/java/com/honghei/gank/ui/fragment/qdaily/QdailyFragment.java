package com.honghei.gank.ui.fragment.qdaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.honghei.gank.base.QDailyBaseView;
import com.honghei.gank.ui.presenter.QDailyPresenter;

/**
 * @author Honghei
 * @time 2017/4/4  19:33
 * @desc ${TODD}
 */
public class QdailyFragment extends Fragment implements QDailyBaseView {

    private QDailyPresenter mQDailyPresenter;
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new QDailyPresenter(this));

        tv = new TextView(container.getContext());

        return tv;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mQDailyPresenter.getQdailyDatas("0");
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onRefrash() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void setPresenter(QDailyPresenter presenter) {
        this.mQDailyPresenter = presenter;
    }

    @Override
    public void initView(View view) {

    }
}
