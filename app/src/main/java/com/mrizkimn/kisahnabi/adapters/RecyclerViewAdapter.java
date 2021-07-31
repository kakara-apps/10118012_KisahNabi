package com.mrizkimn.kisahnabi.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.mrizkimn.kisahnabi.R;
import com.mrizkimn.kisahnabi.activities.NabiActivity;
import com.mrizkimn.kisahnabi.models.Nabi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Nabi> mData;
    private String url;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Nabi> mData) {
        this.mContext = mContext;
        this.mData = mData;

        options = new RequestOptions().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.nabi_row_item,parent,false);
        //part2
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, NabiActivity.class);
                i.putExtra("prophet_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("prophet_description",mData.get(viewHolder.getAdapterPosition()).getDecription());
                i.putExtra("prophet_age",mData.get(viewHolder.getAdapterPosition()).getUsia());
                i.putExtra("prophet_life",mData.get(viewHolder.getAdapterPosition()).getTempat());
                i.putExtra("prophet_birth", mData.get(viewHolder.getAbsoluteAdapterPosition()).getThn_kelahiran());
                i.putExtra("prophet_img",mData.get(viewHolder.getAdapterPosition()).getImg_url());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_born.setText(mData.get(position).getThn_kelahiran());
        holder.tv_age.setText(mData.get(position).getUsia());
        url = mData.get(position).getImg_url();

        //load image image from the internet and set int
        Glide.with(mContext).load(url).apply(options).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_born, tv_age, tv_life;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.prophet_name);
            tv_born = itemView.findViewById(R.id.prophet_born);
            tv_age = itemView.findViewById(R.id.prophet_age);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
