package com.hnzx.hnrb.view.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.hnzx.hnrb.view.MScrollView;

public class PullableScrollView extends MScrollView implements Pullable {

    public PullableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
        if (getScrollY() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean canPullUp() {
        if (getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight()))
            return true;
        else
            return false;
    }

}