package com.example.kylinarm.picturedisplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by kylinARM on 2017/9/6.
 */

public class PictureDisplayHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.btn_add_img)
    ImageButton btnAddImg;
    @InjectView(R.id.iv_content)
    ImageView ivContent;
    @InjectView(R.id.btn_delete)
    ImageButton btnDelete;

    private Context context;
    private PictureDisplayType type;

    public PictureDisplayHolder(View itemView, Context context,PictureDisplayType type) {
        super(itemView);
        ButterKnife.inject(this,itemView);
        this.context = context;
        this.type = type;
    }

    public void setDataToView(String data){
        switch (type){
            case ADD:
                setDataToAdd(data);
                break;
            case ONLY_SHOW:
                setDataToOnlyshow(data);
                break;
            case ALL_SHOW:
                setDataToAllshow(data);
                break;
        }

    }

    private void setDataToAdd(String data){
        if (data == null){
            ivContent.setVisibility(View.GONE);
            btnAddImg.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.GONE);
        }else {
            ivContent.setVisibility(View.VISIBLE);
            btnAddImg.setVisibility(View.GONE);
            btnDelete.setVisibility(View.VISIBLE);
            Glide.with(context).load(data).into(ivContent);
        }
    }

    private void setDataToOnlyshow(String data){
        ivContent.setVisibility(View.VISIBLE);
        btnAddImg.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);
        Glide.with(context).load(data).into(ivContent);
    }

    private void setDataToAllshow(String data){
        if (data.equals("")){
            ivContent.setVisibility(View.GONE);
            btnAddImg.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.GONE);
        }else {
            ivContent.setVisibility(View.VISIBLE);
            btnAddImg.setVisibility(View.GONE);
            btnDelete.setVisibility(View.VISIBLE);
            Glide.with(context).load(data).into(ivContent);
        }
    }

    @OnClick({R.id.btn_add_img,R.id.btn_delete})
    public void itemClick(View v){
        switch (v.getId()){
            case R.id.btn_add_img:
                if (type.equals(PictureDisplayType.ALL_SHOW)) {
                    ((AllShowActivity) context).index = getAdapterPosition();
                }
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ((Activity) context).startActivityForResult(intent, 0x1111);
                break;
            case R.id.btn_delete:
                if (type.equals(PictureDisplayType.ADD)) {
                    ((MainActivity) context).getAdapter().remove(getAdapterPosition());
                }else if (type.equals(PictureDisplayType.ALL_SHOW)){
                    ((AllShowActivity) context).getAdapter().delete(getAdapterPosition(),"");
                }
                break;
        }
    }

}
