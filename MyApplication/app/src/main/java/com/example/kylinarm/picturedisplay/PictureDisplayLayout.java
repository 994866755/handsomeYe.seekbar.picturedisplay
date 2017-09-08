package com.example.kylinarm.picturedisplay;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class PictureDisplayLayout extends RelativeLayout {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;

    private Context context;
    private int count;
    private PictureDisplayType type;

    public PictureDisplayLayout(Context context) {
        super(context);
        initView();
    }

    public PictureDisplayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inial(context, attrs);
        initView();
    }

    public PictureDisplayLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inial(context, attrs);
        initView();
    }

    private void inial(Context context,AttributeSet attrs)  {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.picture_display_style);

        count = typedArray.getInteger(R.styleable.picture_display_style_count,3);
        type = PictureDisplayType.getType(typedArray.getInteger(R.styleable.picture_display_style_showtype,0));

        typedArray.recycle();

    }

    public void initView(){
        mRecyclerView = new RecyclerView(getContext());
        mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.addView(mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),count));
    }

    /**
     *  使用组合
     */
    public void setAdapter(RecyclerView.Adapter adapter){
        this.adapter = adapter;
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                // todo 可以做数据改变时的操作
            }
        });

        if (adapter instanceof PictureDisplayAdapter) {
            ((PictureDisplayAdapter)adapter).setType(type);
            ((PictureDisplayAdapter)adapter).setCount(count);
        }

        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(adapter);
        }
    }


}
