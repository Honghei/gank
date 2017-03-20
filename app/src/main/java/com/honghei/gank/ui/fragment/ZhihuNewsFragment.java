package com.honghei.gank.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghei.gank.R;
import com.honghei.gank.adapter.ZhihuNewsItemRecyclerAdapter;
import com.honghei.gank.base.ZhihuNewsItemBaseView;
import com.honghei.gank.bean.zhihunews.StoriesBean;
import com.honghei.gank.bean.zhihunews.ZhihuNewsLatest;
import com.honghei.gank.ui.GlideImageLoader;
import com.honghei.gank.ui.activity.ZhihuNewsDetailActivity;
import com.honghei.gank.ui.presenter.ZhihuNewsItemPresenter;
import com.honghei.gank.util.DateUtils;
import com.honghei.gank.widght.SelfDefinedRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

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
    private SelfDefinedRecyclerView mRecyclerView;
    public ZhihuNewsItemRecyclerAdapter mAdapter;
    private View mBannerView;
    RecyclerView.LayoutManager mLayoutManager;

    Calendar mCalendar = Calendar.getInstance();


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
        mRecyclerView = (SelfDefinedRecyclerView) view.findViewById(R.id.recylcerview);
        mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(true);
        mAdapter = new ZhihuNewsItemRecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new ZhihuRecyclerScrollistener());
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
            Log.d("hnghei1191","轮播图被点击了！");
            Intent intent = new Intent(getActivity(),ZhihuNewsDetailActivity.class);
            intent.putExtra("id",topStoriesBean.getId());
            startActivity(intent);
        }
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
}
