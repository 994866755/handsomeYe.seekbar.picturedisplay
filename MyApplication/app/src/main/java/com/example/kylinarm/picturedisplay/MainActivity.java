package com.example.kylinarm.picturedisplay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.pdl)
    PictureDisplayLayout pictureDisplayLayout;
    @InjectView(R.id.btn_log)
    Button btnLog;
    @InjectView(R.id.tv_log)
    TextView tvLog;

    private PictureDisplayAdapter adapter;
    private List<String> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        imgList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1944582709,2686578056&fm=27&gp=0.jpg");
        imgList.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3425952179,691185807&fm=27&gp=0.jpg");
        adapter = new PictureDisplayAdapter(this, imgList);
        pictureDisplayLayout.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 0x1111) {
            Uri uri = data.getData();
            adapter.add(uri.toString());
        }
    }

    public PictureDisplayAdapter getAdapter() {
        return adapter;
    }


    @OnClick(R.id.btn_log)
    public void click(){
        if (adapter.getDataSource() != null && adapter.getDataSource().size()>0){
            String str = "";
            for (int i = 0; i < adapter.getDataSource().size(); i++) {
                str += adapter.getDataSource().get(i);
                str += "\n";
            }
            tvLog.setText(str);
        }
    }

}
