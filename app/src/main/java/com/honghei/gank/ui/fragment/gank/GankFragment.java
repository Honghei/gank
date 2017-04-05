package com.honghei.gank.ui.fragment.gank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghei.gank.R;
import com.honghei.gank.adapter.GankAdapter;
import com.honghei.gank.base.BaseRecyclerAdapter;
import com.honghei.gank.base.GankBaseView;
import com.honghei.gank.bean.gank.MeiZhi;
import com.honghei.gank.ui.presenter.GankPresenter;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/26  20:27
 * @desc ${TODD}
 */
public class GankFragment extends Fragment implements GankBaseView<GankPresenter> {
    private GankPresenter mPresenter;
    private SwipeRefreshLayout mSwiper;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
    private GankAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gank,container,false);
        setPresenter(new GankPresenter(this));
        initView(view);

        mPresenter.handleWelfare(1);

        return view;
    }




    @Override
    public void setPresenter(GankPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void initView(View view) {
        initSwipeLayout(view);
        initRecyclerView(view);
    }

    private void initSwipeLayout(View view) {

        mSwiper = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        //为SwipeRefreshLayout设置监听事件
        mSwiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在这里进行刷新请求操作。
                mPresenter.handleWelfare(1);
            }
        });


        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        mSwiper.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }


    private void initRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GankAdapter();
        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                //在这里实现页面跳转。

                if(data instanceof MeiZhi.ResultsBean){
                    Intent intent = new Intent(getActivity(),GankDetailActivity.class);
                    intent.putExtra("image_url",((MeiZhi.ResultsBean)data).getUrl());

                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                }


            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new GankRecyclerScrollistener());

    }

    @Override
    public void setRecyclerViewDatas(List<MeiZhi.ResultsBean> datas) {
        mAdapter.addDatas(datas);
    }

    @Override
    public void setRecyclerViewLatestDatas(List<MeiZhi.ResultsBean> datas) {
        mAdapter.addLatestDatas(datas);
    }

    @Override
    public void stopRefrash() {
        if(mSwiper!=null && mSwiper.isRefreshing()){
            mSwiper.setRefreshing(false);
        }
    }

    private class GankRecyclerScrollistener extends RecyclerView.OnScrollListener {

        //用来标记是否正在向最后一个滑动
        boolean isSlidingToLast = false;
        private int pageCount = 1;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            // 当不滚动时
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                //获取最后一个完全显示的ItemPosition
                int[] lastVisibleItems = manager.findLastCompletelyVisibleItemPositions(new int[2]);
                int totalItemCount = manager.getItemCount();

                // 判断是否滚动到底部，并且是向右滚动
                if ((lastVisibleItems[0] == (totalItemCount - 1) || lastVisibleItems[1] == (totalItemCount-1)) && isSlidingToLast) {
                    //加载更多功能的代码
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                          //在这里实现加载更多。
                           mPresenter.handleWelfare(++pageCount);
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
