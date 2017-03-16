package com.honghei.gank.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.honghei.gank.R;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;
import com.honghei.gank.ui.presenter.ZhihuNewsDetailPresenter;

/**
 * @author Honghei
 * @time 2017/3/16  11:17
 * @desc ${TODD}
 */
public class ZhihuNewsDetailActivity extends Activity implements ZhihuNewsDetailBaseView<ZhihuNewsDetailPresenter> {
    private int mId;
    private ZhihuNewsDetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihunewdetail);
        setPresenter(new ZhihuNewsDetailPresenter(this,this));
        initId();
        initView(null);

    }

    private void initId(){
        Intent intent = getIntent();
        mId = intent.getIntExtra("id",-1);
    }

    @Override
    public void setPresenter(ZhihuNewsDetailPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void initView(View view) {
//        findViewById();
    }
}
