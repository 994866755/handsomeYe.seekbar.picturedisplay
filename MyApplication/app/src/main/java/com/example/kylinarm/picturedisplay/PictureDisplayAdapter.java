package com.example.kylinarm.picturedisplay;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kylinARM on 2017/9/6.
 */

public class PictureDisplayAdapter extends RecyclerView.Adapter<PictureDisplayHolder> {

    private Context context;
    private List<String> dataSource;
    private PictureDisplayType type;
    private int count;

    public PictureDisplayAdapter(Context context,List<String> dataSource){
        this.context = context;
        this.dataSource = dataSource;
    }

    public void addAll(List<String> dataSource){
        this.dataSource.addAll(dataSource);
        notifyDataSetChanged();
    }

    public void add(String str){
        this.dataSource.add(str);
        notifyDataSetChanged();
    }

    public void remove(int position){
        this.dataSource.remove(position);
        notifyDataSetChanged();
    }

    public void delete(int position,String str){
        this.dataSource.set(position,str);
        notifyDataSetChanged();
    }

    public List<String> getDataSource() {
        return dataSource;
    }

    @Override
    public PictureDisplayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureDisplayHolder(LayoutInflater.from(context).inflate(R.layout.test_item,null),context,type);
    }

    @Override
    public void onBindViewHolder(PictureDisplayHolder holder, int position) {
        if (type.equals(PictureDisplayType.ADD)) {
            if (position < dataSource.size()) {
                holder.setDataToView(dataSource.get(position));
            } else {
                holder.setDataToView(null);
            }
        }else if (type.equals(PictureDisplayType.ONLY_SHOW)){
            holder.setDataToView(dataSource.get(position));
        }else if (type.equals(PictureDisplayType.ALL_SHOW)){
            holder.setDataToView(dataSource.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (type.equals(PictureDisplayType.ADD)){
            //如果小于count， + 1 是为了没到max的时候显示一个 “+” 的item
            if (dataSource.size()<count){
                return dataSource.size() + 1;
            }else {
                return dataSource.size();
            }
        }else if (type.equals(PictureDisplayType.ONLY_SHOW)){
            return dataSource.size();
        }else if (type.equals(PictureDisplayType.ALL_SHOW)){
            return count;
        }
        return dataSource.size();
    }

    public void setType(PictureDisplayType type) {
        this.type = type;
    }

    public PictureDisplayType getType() {
        return type;
    }

    public void setCount(int count){
        this.count = count;
    }

}
