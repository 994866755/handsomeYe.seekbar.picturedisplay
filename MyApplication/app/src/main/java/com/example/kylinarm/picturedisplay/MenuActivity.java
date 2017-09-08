package com.example.kylinarm.picturedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by kylinARM on 2017/9/6.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_add,R.id.btn_only_show,R.id.btn_all_show})
    public void click(View v){
        switch (v.getId()){
            case R.id.btn_add:
                intentHelper(MainActivity.class);
                break;
            case R.id.btn_only_show:
                intentHelper(OnlyShowActivity.class);
                break;
            case R.id.btn_all_show:
                intentHelper(AllShowActivity.class);
                break;
        }
    }


    private void intentHelper(Class cls){
        Intent intent = new Intent(MenuActivity.this,cls);
        startActivity(intent);
    }

}
