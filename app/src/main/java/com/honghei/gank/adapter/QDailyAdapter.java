package com.honghei.gank.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.honghei.gank.MyApp;
import com.honghei.gank.R;
import com.honghei.gank.bean.daily.ColumnsBean;
import com.honghei.gank.bean.daily.FeedsBean;

import java.util.ArrayList;
import java.util.List;

import static com.honghei.gank.base.BaseRecyclerAdapter.TYPE_HEADER;

/**
 * @author Honghei
 * @time 2017/4/5  14:33
 * @desc ${TODD}
 */
public class QDailyAdapter extends RecyclerView.Adapter {

    public static final int TYPE_HEAD = 0;
    public static final int TYPE_COLUMN = 1;
    public static final int TYPE_FEED_COLUMN = 2;
    public static final int TYPE_FEED_NORMAL = 3;
    public static final int TYPE_END = 4;



    private ArrayList<FeedsBean> mDatas = new ArrayList<>();
    private View mHeaderView;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void addDatas(List<FeedsBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public ArrayList<FeedsBean> getDatas() {
        return mDatas;
    }

    public void addLatestDatas(List<FeedsBean> datas) {

        mDatas.addAll(0,datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int thereIsAHead = 0;
        //如果是有头
        if(mHeaderView != null){
            if(position == 0) {
                return TYPE_HEAD;
            }
            thereIsAHead = 1;
        }

        if(position == mDatas.size()+thereIsAHead){
            return TYPE_END;
        }

        FeedsBean feedsBean = mDatas.get(position - thereIsAHead);

        if(feedsBean.getPost().getColumn() == null){
            //表示的是 TYPE_FEED_NORMAL
            return TYPE_FEED_NORMAL;
        }else{
            if(feedsBean.getPost().getCategory() == null){
                return TYPE_COLUMN;
            }else
                return TYPE_FEED_COLUMN;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_HEAD:
                viewHolder = new HeadHolder(mHeaderView);
                break;
            case TYPE_END:
                View listFooter = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_footer,parent,false);
                viewHolder = new FooterHolder(listFooter);
                break;
            case TYPE_COLUMN:
                View columsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.qdaily_item_columns,parent,false);
                viewHolder = new ColumnsHolder(columsView);
                break;
            case TYPE_FEED_COLUMN:
                View feedColumView = LayoutInflater.from(parent.getContext()).inflate(R.layout.qdaily_item_feed_column,parent,false);
                viewHolder = new FeedColumnHolder(feedColumView);
                break;
            case TYPE_FEED_NORMAL:
                View feedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.qdaily_item_feed,parent,false);
                viewHolder = new FeedHolder(feedView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEAD) return;

        if(getItemViewType(position) == TYPE_END){
            FooterHolder mFooterHolder = (FooterHolder) holder;
            if(mDatas.size() == 0)
                mFooterHolder.footer_container.setVisibility(View.GONE);
            else
                mFooterHolder.footer_container.setVisibility(View.VISIBLE);
            return;
        }
        int realPosition = getRealPosition(holder);

        switch (getItemViewType(position)){
            case TYPE_COLUMN:
                ColumnsHolder mColumnsHolder = (ColumnsHolder) holder;
                setColumnData(mColumnsHolder,realPosition);
                break;
            case TYPE_FEED_COLUMN:

                break;
            case TYPE_FEED_NORMAL:

                break;

        }

    }

    @Override
    public int getItemCount() {
        //考虑到头和最后的加载更多。
        return mHeaderView == null ? mDatas.size()+1 : mDatas.size() + 2;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            if(mHeaderView!=null)
                p.setFullSpan(holder.getLayoutPosition() == 0);
            if(holder.getLayoutPosition() == (mHeaderView == null ? mDatas.size() : mDatas.size()+1)){
                p.setFullSpan(true);
            }
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }


    public interface OnItemClickListener<FeedsBean> {
        void onItemClick(int position,FeedsBean data);
    }

    /*****************************填充数据*****************************************/
    /*
     *为column布局填充数据
     */
    private void setColumnData(ColumnsHolder mColumnsHolder, final int realPosition) {
        ColumnsBean column = mDatas.get(realPosition).getPost().getColumn();

        mColumnsHolder.columns_name.setText(column.getName());
        mColumnsHolder.columns_content_provider.setText("本专栏由"+column.getContent_provider()+"提供");
        mColumnsHolder.columns_description.setText("专题介绍:"+column.getDescription());
        mColumnsHolder.columns_sort_time.setText("最近更新时间:"+column.getSort_time());
        mColumnsHolder.columns_subscriber_num.setText("订阅数:"+column.getSubscriber_num());

        loadImageByGilide(column.getIcon(),mColumnsHolder.columns_ic);
        loadImageByGilide(column.getImage(),mColumnsHolder.columns_image);

        mColumnsHolder.columns_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(realPosition,mDatas.get(realPosition));
            }
        });
    }


    /*****************************viewholder************************************/

    private class HeadHolder extends RecyclerView.ViewHolder{

        public HeadHolder(View itemView) {
            super(itemView);
        }
    }


    private class FooterHolder extends RecyclerView.ViewHolder{
        public View footer_container;
        public FooterHolder(View itemView) {
            super(itemView);
            footer_container = itemView.findViewById(R.id.footer_container);
        }
    }


    private class ColumnsHolder extends RecyclerView.ViewHolder{
        public ImageView columns_ic,columns_image;
        public TextView columns_name,columns_description,columns_content_provider,
                columns_sort_time,columns_subscriber_num;
        public View columns_root;

        public ColumnsHolder(View itemView) {
            super(itemView);
            columns_ic = (ImageView) itemView.findViewById(R.id.columns_ic);
            columns_image = (ImageView) itemView.findViewById(R.id.columns_image);
            columns_name = (TextView) itemView.findViewById(R.id.columns_name);
            columns_description = (TextView) itemView.findViewById(R.id.columns_description);
            columns_content_provider = (TextView) itemView.findViewById(R.id.columns_content_provider);
            columns_sort_time = (TextView) itemView.findViewById(R.id.columns_sort_time);
            columns_subscriber_num = (TextView) itemView.findViewById(R.id.columns_subscriber_num);
            columns_root = itemView.findViewById(R.id.columns_root);
        }
    }

    private class FeedColumnHolder extends RecyclerView.ViewHolder{
        public FeedColumnHolder(View itemView) {
            super(itemView);
        }
    }

    private class FeedHolder extends RecyclerView.ViewHolder{

        public FeedHolder(View itemView) {
            super(itemView);
        }
    }

    private void loadImageByGilide(String url,ImageView iv){
        Glide.with(MyApp.mContext).load(url).placeholder(R.mipmap.fillbitmap).error(R.mipmap.fillbitmap)
                .fitCenter().into(iv);
    }

}
