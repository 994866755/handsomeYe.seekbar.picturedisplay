package com.example.kylinarm.picturedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kylinARM on 2017/9/6.
 */

public class OnlyShowActivity extends AppCompatActivity{

    @InjectView(R.id.pdl)
    PictureDisplayLayout pictureDisplayLayout;

    private PictureDisplayAdapter adapter;
    private List<String> imgList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlyshow);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        imgList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1944582709,2686578056&fm=27&gp=0.jpg");
        imgList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3425952179,691185807&fm=27&gp=0.jpg");
        adapter = new PictureDisplayAdapter(this,imgList);
        pictureDisplayLayout.setAdapter(adapter);
    }


}
