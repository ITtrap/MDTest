package com.chenxu.material.design.mdtest.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chenxu.material.design.mdtest.R;
import com.chenxu.material.design.mdtest.bean.Beauty;

import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */
public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.ViewHolder>{
    private Context mContext;
    private List<Beauty> mBeautuList;

    public BeautyAdapter(List<Beauty> list) {
        mBeautuList=list;
    }

    @Override
    public BeautyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.beauty_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeautyAdapter.ViewHolder holder, int position) {
        Beauty mBeauty=mBeautuList.get(position);
        holder.mBeautyName.setText(mBeauty.getName());
        Glide.with(mContext).load(mBeauty.getImageId()).into(holder.mBeautyImage);
    }

    @Override
    public int getItemCount() {
        return mBeautuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mBeautyName;
        ImageView mBeautyImage;
        public ViewHolder(View itemView) {
            super(itemView);
            mCardView= (CardView) itemView;
            mBeautyName= (TextView) itemView.findViewById(R.id.beauty_name);
            mBeautyImage= (ImageView) itemView.findViewById(R.id.beauty_image);
        }
    }
}
