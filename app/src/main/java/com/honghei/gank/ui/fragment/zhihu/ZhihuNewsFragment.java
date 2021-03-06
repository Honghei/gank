package com.honghei.gank.ui.fragment.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghei.gank.R;
import com.honghei.gank.adapter.ZhihuNewsItemRecyclerAdapter;
import com.honghei.gank.base.BaseRecyclerAdapter;
import com.honghei.gank.base.ZhihuNewsItemBaseView;
import com.honghei.gank.bean.zhihunews.StoriesBean;
import com.honghei.gank.bean.zhihunews.ZhihuNewsLatest;
import com.honghei.gank.ui.GlideImageLoader;
import com.honghei.gank.ui.activity.ZhihuNewsDetailActivity;
import com.honghei.gank.ui.presenter.ZhihuNewsItemPresenter;
import com.honghei.gank.util.DateUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * @author Honghei
 * @time 2017/3/4  21:00
 * @desc ${TODD}
 */
public class ZhihuNewsFragment extends Fragment implements ZhihuNewsItemBaseView<ZhihuNewsItemPresenter> {
    private ZhihuNewsItemPresenter mPresenter;
    private Banner mBanner;
    private RecyclerView mRecyclerView;
    public ZhihuNewsItemRecyclerAdapter mAdapter;
    private View mBannerView;
    RecyclerView.LayoutManager mLayoutManager;

    Calendar mCalendar = Calendar.getInstance();
    private SwipeRefreshLayout mSwiper;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhihunews,container,false);
        initView(view);

        setPresenter(new ZhihuNewsItemPresenter(this,container.getContext()));


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mPresenter!= null) {
            mPresenter.getZhihuItemNews();
        }

    }

    @Override
    public void setPresenter(ZhihuNewsItemPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void initView(View view) {
        mBannerView = LayoutInflater.from(view.getContext()).inflate(R.layout.banner_zhihunewsitem,null);
        mBanner = (Banner) mBannerView.findViewById(R.id.banner);
        mBanner.setOnBannerListener(new ZhihuNewsOnbannerListener());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recylcerview);
        mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(true);
        mAdapter = new ZhihuNewsItemRecyclerAdapter();

        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                ArrayList<StoriesBean> datas = mAdapter.getDatas();
                jump2DetailActivityFromRecyclerItem(datas.get(position));
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new ZhihuRecyclerScrollistener());

        initSwipeLayout(view);

    }

    private void initSwipeLayout(View view) {

        mSwiper = (SwipeRefreshLayout) view.findViewById(R.id.zhihunews_swipelayout);
        //为SwipeRefreshLayout设置监听事件
        mSwiper.setOnRefreshListener(new ZhihuNewsOnrefrashlistener());
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        mSwiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }


    @Override
    public void setBanner(List<String> images, List<String> titles) {
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
    public void setHeaderView() {
        mAdapter.setHeaderView(mBannerView);
    }

    @Override
    public void setRecyclerViewDatas(List<StoriesBean> datas) {
        mAdapter.addDatas(datas);
    }

    @Override
    public void setRecyclerViewLatestDatas(List<StoriesBean> datas) {
        mAdapter.addLatestDatas(datas);
    }

    @Override
    public void startRefresh() {
        if(mSwiper != null && !mSwiper.isRefreshing())
            mSwiper.setRefreshing(true);
    }

    @Override
    public void stopRefresh() {
        if(mSwiper != null && mSwiper.isRefreshing())
            mSwiper.setRefreshing(false);

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

    private class ZhihuNewsOnbannerListener implements OnBannerListener{

        @Override
        public void OnBannerClick(int position) {
            if(mPresenter == null)
                return;
            ZhihuNewsLatest zhihuNewsLatest = mPresenter.getZhihuNewsLatest();
            if(zhihuNewsLatest == null)
                return;

            ZhihuNewsLatest.TopStoriesBean topStoriesBean = zhihuNewsLatest.getTop_stories().get(position);
            jump2DetailActivityFromBanner(topStoriesBean);
        }
    }

    private void jump2DetailActivityFromBanner(ZhihuNewsLatest.TopStoriesBean topStoriesBean) {
        Intent intent = new Intent(getActivity(),ZhihuNewsDetailActivity.class);
        intent.putExtra("id",topStoriesBean.getId());
        startActivity(intent);
    }

    private void jump2DetailActivityFromRecyclerItem(StoriesBean storiesBean){
        Intent intent = new Intent(getActivity(),ZhihuNewsDetailActivity.class);
        intent.putExtra("id",storiesBean.getId());
        startActivity(intent);
    }


    private class ZhihuRecyclerScrollistener extends OnScrollListener{

            //用来标记是否正在向最后一个滑动
            boolean isSlidingToLast = false;

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
                                mCalendar.add(Calendar.DAY_OF_MONTH,-1);
                                mPresenter.getBeforeZhihuNews(DateUtils.ZhihuDailyDateFormat(mCalendar.getTimeInMillis()));

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

    private class ZhihuNewsOnrefrashlistener implements SwipeRefreshLayout.OnRefreshListener{

        @Override
        public void onRefresh() {
            //在这里处理网络请求。
            if(mPresenter != null) mPresenter.getZhihuItemNews();
        }
    }
}
