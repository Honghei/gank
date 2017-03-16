package com.honghei.gank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.honghei.gank.R;
import com.honghei.gank.base.BaseRecyclerAdapter;
import com.honghei.gank.bean.zhihunews.ZhihuNewsItem;

/**
 * @author Honghei
 * @time 2017/3/16  13:36
 * @desc ${TODD}
 */
public class ZhihuNewsItemRecyclerAdapter extends BaseRecyclerAdapter<ZhihuNewsItem.StoriesBean> {

    //提供一个viewholder
    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_zhihunewsitem,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定数据
    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, ZhihuNewsItem.StoriesBean data) {
        ((MyViewHolder)viewHolder).tv.setText(data.getTitle());
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
