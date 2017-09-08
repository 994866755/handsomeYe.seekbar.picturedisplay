package com.example.kylinarm.picturedisplay;

/**
 * Created by kylinARM on 2017/9/6.
 */

public enum  PictureDisplayType {
    ONLY_SHOW(0),ADD(1),ALL_SHOW(2);
    private final int id;

    PictureDisplayType(int k){
        this.id = k;
    }

    public static PictureDisplayType getType(int k){
        switch (k){
            case 0:
                return ONLY_SHOW;// 只做展示，不做添加
            case 1:
                return ADD;//展示数量动态改变
            case 2:
                return ALL_SHOW;//展示数量为固定总数
            default:
                return ONLY_SHOW;
        }
    }

}
