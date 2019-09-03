package com.bawei.liuhe20190903.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liuhe20190903.R;
import com.bawei.liuhe20190903.base.Bjiji;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyBase extends BaseAdapter {
    Context context;
    ArrayList<Bjiji.DataBean>arrayList;

    public MyBase(Context context, ArrayList<Bjiji.DataBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            view = View.inflate(context, R.layout.yemian, null);
            holder = new ViewHolder();
            holder.textView  = view.findViewById(R.id.text_one);
            holder.imageView =view.findViewById(R.id.image_one);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(arrayList.get(i).getCurrency_price());
        Glide.with(context).load(arrayList.get(i).getGoods_thumb()).into(holder.imageView);
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
