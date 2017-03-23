package com.honghei.gank.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.honghei.gank.R;
import com.honghei.gank.base.ZhihuNewsDetailBaseView;
import com.honghei.gank.ui.GlideImageLoader;
import com.honghei.gank.ui.SwipeBackToolBarActivity;
import com.honghei.gank.ui.presenter.ZhihuNewsDetailPresenter;

/**
 * @author Honghei
 * @time 2017/3/16  11:17
 * @desc ${TODD}
 */
public class ZhihuNewsDetailActivity extends SwipeBackToolBarActivity implements ZhihuNewsDetailBaseView<ZhihuNewsDetailPresenter> {
    private int mId;
    private ZhihuNewsDetailPresenter mPresenter;
    private WebView mDetailWebview;
    CollapsingToolbarLayout mToolbarLayout;
    ImageView mTitleIamgeView;
    Toolbar mToolbar;

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

        mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mTitleIamgeView = (ImageView) findViewById(R.id.image_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }


    @Override
    public void onLoading() {

    }

    @Override
    public void onError() {

    }


    //使用webview的loaddata方法加载网页。
    @Override
    public void loadDataWithBaseUrl(String baseUrl,String data) {

        mDetailWebview.loadDataWithBaseURL(baseUrl,data,"text/html","utf-8",null);
    }


    //使用rul直接加载网页布局。
    @Override
    public void loadUrl(String url) {
        mDetailWebview.loadUrl(url);
    }

    @Override
    public void setToolbarTitle(String title) {
        setCollapsingToolbarLayoutTitle(title);
    }

    @Override
    public void setTitleImageRes(String url) {
        GlideImageLoader.getInstance().displayImage(this,url,mTitleIamgeView);
    }


    private void initWebView() {
        mDetailWebview = (WebView)findViewById(R.id.web_view);
        mDetailWebview.getSettings().setJavaScriptEnabled(true);
        mDetailWebview.getSettings().setDefaultTextEncodingName("UTF-8");
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        mDetailWebview.getSettings().setBuiltInZoomControls(false);
        //缓存
        mDetailWebview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //开启DOM storage API功能
        mDetailWebview.getSettings().setDomStorageEnabled(true);
        //开启application Cache功能
        mDetailWebview.getSettings().setAppCacheEnabled(false);
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


    // to change the title's font size of toolbar layout
    private void setCollapsingToolbarLayoutTitle(String title) {
        mToolbarLayout.setTitle(title);
        mToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        mToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
        mToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
    }


}
