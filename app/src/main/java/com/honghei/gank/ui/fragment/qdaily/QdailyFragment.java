package com.honghei.gank.ui.fragment.qdaily;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghei.gank.R;
import com.honghei.gank.adapter.QDailyAdapter;
import com.honghei.gank.base.QDailyBaseView;
import com.honghei.gank.bean.daily.FeedsBean;
import com.honghei.gank.ui.GlideImageLoader;
import com.honghei.gank.ui.presenter.QDailyPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/4/4  19:33
 * @desc ${TODD}
 */
public class QdailyFragment extends Fragment implements QDailyBaseView {
    private SwipeRefreshLayout mSwiper;
    private QDailyPresenter mQDailyPresenter;
    private RecyclerView mRecycler;
    private Banner mBanner;
    private QDailyAdapter mQDailyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new QDailyPresenter(this));
        View view = inflater.inflate(R.layout.fragment_qdaily,container,false);
        initView(view);
        return view;
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
    public void onSuccess(List<FeedsBean> feedsBeen) {
        mQDailyAdapter.addDatas(feedsBeen);
    }

    @Override
    public void onRefrash() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void setBanner(List<String> images, List<String> titles){
        if(mBanner != null){
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            //设置图片加载器
            mBanner.setImageLoader(GlideImageLoader.getInstance());
            //设置图片集合
            mBanner.setImages(images);
            //设置banner动画效果
            mBanner.setBannerAnimation(Transformer.DepthPage);
            //设置标题集合（当banner样式有显示title时）
            mBanner.setBannerTitles(titles);
            //设置自动轮播，默认为true
            mBanner.isAutoPlay(true);
            //设置轮播时间
            mBanner.setDelayTime(3000);
            //设置指示器位置（当banner模式中有指示器时）
            mBanner.setIndicatorGravity(BannerConfig.RIGHT);
            //banner设置方法全部调用完毕时最后调用
            mBanner.start();
        }
    }

    @Override
    public void setPresenter(QDailyPresenter presenter) {
        this.mQDailyPresenter = presenter;
    }

    @Override
    public void initView(View view) {
        initSwipeLayout(view);
        initRecyclerView(view);
        initBanner(view);
    }

    private void initBanner(View view){
        View bannerContainer = LayoutInflater.from(view.getContext()).inflate(R.layout.banner_qdaily,null);
        mBanner = (Banner) bannerContainer.findViewById(R.id.banner);
        mBanner.setOnBannerListener(new QDailyBannerListenter());
    }

    private void initSwipeLayout(View view) {

        mSwiper = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        //为SwipeRefreshLayout设置监听事件
        mSwiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在这里进行刷新请求操作。

            }
        });

        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        mSwiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }


    private void initRecyclerView(View view) {
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setNestedScrollingEnabled(true);

        mQDailyAdapter = new QDailyAdapter();
        mRecycler.setAdapter(mQDailyAdapter);
        mQDailyAdapter.setOnItemClickListener(new QDailyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                //在这里实现页面跳转。
            }
        });
        /*

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new GankFragment.GankRecyclerScrollistener());*/

    }

    private class QDailyRecyclerScrollistener extends RecyclerView.OnScrollListener {

        //用来标记是否正在向最后一个滑动
        boolean isSlidingToLast = false;
        private int pageCount = 1;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            // 当不滚动时
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                //获取最后一个完全显示的ItemPosition
                int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
                int totalItemCount = manager.getItemCount();

                // 判断是否滚动到底部，并且是向右滚动
                if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
                    //加载更多功能的代码
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(1000);

                        }
                    }).start();
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
            if (dy > 0) {
                //大于0表示正在向右滚动
                isSlidingToLast = true;
            } else {
                //小于等于0表示停止或向左滚动
                isSlidingToLast = false;
            }
        }
    }

    private class QDailyBannerListenter implements OnBannerListener{

        @Override
        public void OnBannerClick(int position) {
            //调用跳转了。
        }
    }


    /****************************优化轮播图体验**********************************/
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mBanner != null)
            mBanner.stopAutoPlay();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mBanner != null)
            mBanner.startAutoPlay();
    }

}
