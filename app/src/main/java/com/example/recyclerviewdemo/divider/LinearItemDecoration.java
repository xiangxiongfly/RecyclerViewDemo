package com.example.recyclerviewdemo.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * RecyclerView线性分割线
 */
public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    //RecyclerView布局方向
    private int mOrientation = LinearLayoutManager.VERTICAL;
    //分割线大小
    private int mDividerSize = 1;
    //分割线颜色
    private int mColor = Color.RED;
    //Drawable分割线
    private Drawable mDividerDrawable;

    private Paint mPaint;
    private final Context mContext;

    /**
     * @param context
     * @param orientation 列表方向
     * @param color       颜色
     * @param dividerSize 分割线大小
     */
    public LinearItemDecoration(Context context, int orientation, int color, int dividerSize) {
        mContext = context;
        mOrientation = orientation;
        mColor = color;
        mDividerSize = dividerSize;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public LinearItemDecoration(Context context, int orientation, int drawableId) {
        mContext = context;
        mOrientation = orientation;
        mDividerDrawable = ContextCompat.getDrawable(context, drawableId);
        mDividerSize = mDividerDrawable.getIntrinsicHeight();
    }

    //设置分割线颜色
    public void setColor(int color) {
        mPaint.setColor(color);
    }

    //设置分割线大小
    public void setDividerSize(int size) {
        mDividerSize = size;
    }

    /**
     * 设置分割线大小
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (mOrientation == LinearLayout.VERTICAL) {
            outRect.set(0, 0, 0, mDividerSize);
        } else {
            outRect.set(0, 0, mDividerSize, 0);
        }
    }

    /**
     * 绘制分割线
     */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (mOrientation == LinearLayout.VERTICAL) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    /**
     * 垂直方向分割线绘制
     */
    private void drawVertical(@NonNull Canvas c, @NonNull RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int top = childView.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mDividerSize;
            if (mDividerDrawable == null) {
                c.drawRect(left, top, right, bottom, mPaint);
            } else {
                mDividerDrawable.setBounds(left, top, right, bottom);
                mDividerDrawable.draw(c);
            }
        }
    }

    /**
     * 水平方向分割线绘制
     */
    private void drawHorizontal(@NonNull Canvas c, @NonNull RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int left = childView.getRight() + layoutParams.rightMargin;
            final int right = left + mDividerSize;
            if (mDividerDrawable == null) {
                c.drawRect(left, top, right, bottom, mPaint);
            } else {
                mDividerDrawable.setBounds(left, top, right, bottom);
                mDividerDrawable.draw(c);
            }
        }
    }
}
