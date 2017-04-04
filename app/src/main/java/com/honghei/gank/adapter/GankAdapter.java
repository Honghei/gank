package com.honghei.gank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.honghei.gank.MyApp;
import com.honghei.gank.R;
import com.honghei.gank.base.BaseRecyclerAdapter;
import com.honghei.gank.bean.gank.MeiZhi;
import com.honghei.gank.ui.GlideImageLoader;

/**
 * @author Honghei
 * @time 2017/3/26  21:16
 * @desc ${TODD}
 */
public class GankAdapter extends BaseRecyclerAdapter<MeiZhi.ResultsBean> {
    public MyViewHolder myViewHolder;
    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_gank,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, MeiZhi.ResultsBean data) {
        myViewHolder = (MyViewHolder)viewHolder;
        GlideImageLoader.getInstance().displayImage(MyApp.mContext,
                data.getUrl(),
                myViewHolder.mImageView);
    }

    @Override
    public boolean needToLoadMore() {
        return true;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.picture_iv);
        }

    }

}
