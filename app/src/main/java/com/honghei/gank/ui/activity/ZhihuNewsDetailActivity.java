package com.honghei.gank.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.honghei.gank.R;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;
import com.honghei.gank.ui.presenter.ZhihuNewsDetailPresenter;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * @author Honghei
 * @time 2017/3/16  11:17
 * @desc ${TODD}
 */
public class ZhihuNewsDetailActivity extends SwipeBackActivity implements ZhihuNewsDetailBaseView<ZhihuNewsDetailPresenter> {
    private int mId;
    private ZhihuNewsDetailPresenter mPresenter;
    private WebView mDetailWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihunewdetail);
        setPresenter(new ZhihuNewsDetailPresenter(this,this));
        initId();
        initView(null);
        mPresenter.getNewsDetail(String.valueOf(mId));
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
        initWebView();
    }



    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }


    //使用webview的loaddata方法加载网页。
    @Override
    public void loadData(String data) {

        mDetailWebview.loadDataWithBaseURL(null,data,"text/html","utf-8",null);
    }


    //使用rul直接加载网页布局。
    @Override
    public void loadUrl(String url) {
        mDetailWebview.loadUrl(url);
    }


    private void initWebView() {
        mDetailWebview = (WebView)findViewById(R.id.detail_webview);
        mDetailWebview.getSettings().setJavaScriptEnabled(true);
        mDetailWebview.getSettings().setDefaultTextEncodingName("UTF-8");
        mDetailWebview.getSettings().setBuiltInZoomControls(true);
        mDetailWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mDetailWebview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mDetailWebview.canGoBack()) {
                    // 返回键退回
                    mDetailWebview.goBack();
                    return true;
                } else
                    return false;
            }
        });
    }


}
