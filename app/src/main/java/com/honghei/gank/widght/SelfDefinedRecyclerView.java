package com.honghei.gank.widght;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author Honghei
 * @time 2017/3/16  17:17
 * @desc ${TODD}
 */
public class SelfDefinedRecyclerView extends RecyclerView {
    public SelfDefinedRecyclerView(Context context) {
        super(context);
    }

    public SelfDefinedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 解决外部嵌套viewpager出现滑动冲突的问题。
     */
    float x;
    float y;
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = e.getRawX();
                y = e.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float nextX = e.getRawX();
                float nextY = e.getRawY();

                float desX = Math.abs(x - nextX);
                float desY = Math.abs(y - nextY);

                if (desY > 20 && desY > desX)
                    getParent().requestDisallowInterceptTouchEvent(true);

                break;
                case MotionEvent.ACTION_UP:
                    break;
            }
        return super.onTouchEvent(e);
    }
}
