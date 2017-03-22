package com.honghei.gank.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghei.gank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/16  13:32
 * @desc 方便recylerview进行添加头部
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    public static final int TEPE_FOOTER = 2;

    private ArrayList<T> mDatas = new ArrayList<>();

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

    public void addDatas(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public ArrayList<T> getDatas() {
        return mDatas;
    }

    public void addLatestDatas(List<T> datas) {

        mDatas.addAll(0,datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        if(mHeaderView != null && position == 0) return TYPE_HEADER;
        if(needToLoadMore() &&
                mHeaderView == null ? (position == mDatas.size()) : (position == mDatas.size()+1))
            return TEPE_FOOTER;

        return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER) return new Holder(mHeaderView);
        if(viewType == TEPE_FOOTER){
            View listFooter = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_footer,parent,false);
            return new FooterHolder(listFooter);
        }
        return onCreate(parent, viewType);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;

        if(getItemViewType(position) == TEPE_FOOTER){
            FooterHolder holder = (FooterHolder) viewHolder;
            if(mDatas.size() == 0)
                holder.mFootView.setVisibility(View.GONE);
            else
                holder.mFootView.setVisibility(View.VISIBLE);
            return;
        }
        final int pos = getRealPosition(viewHolder);
        final T data = mDatas.get(pos);
        onBind(viewHolder, pos, data);

        if(mListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(pos,data);
                }
            });
        }
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
            p.setFullSpan(holder.getLayoutPosition() == 0);
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        int itemCount = mHeaderView == null ? mDatas.size() : mDatas.size() + 1;
        if(needToLoadMore()){
            itemCount++;
        }
        return itemCount;
    }

    public abstract RecyclerView.ViewHolder onCreate(ViewGroup parent, final int viewType);
    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, T data);

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }
    }

    private class FooterHolder extends RecyclerView.ViewHolder{
        View mFootView;
        public FooterHolder(View itemView) {
            super(itemView);
            mFootView = itemView.findViewById(R.id.footer_container);
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T data);
    }


    /**
     * 如果子类有上拉加载更多的需求，覆写该方法，返回true。
     * @return
     */
    public  boolean needToLoadMore(){
        return false;
    }
}