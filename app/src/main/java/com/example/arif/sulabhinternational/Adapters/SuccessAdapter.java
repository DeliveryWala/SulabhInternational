package com.example.arif.sulabhinternational.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arif.sulabhinternational.R;

/**
 * Created by Arif on 12/12/16.
 */

public class SuccessAdapter extends RecyclerView.Adapter<SuccessAdapter.MyViewHolder> {
    private String[] successDetail,successHead;
    private int[] image;
    private Context context;

    public SuccessAdapter(Context context, int[] image,String[] successHead,String[] successDetail) {
        this.context = context;
        this.image = image;
        this.successHead=successHead;
        this.successDetail = successDetail;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.success_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.successHead.setText(successHead[position]);
        holder.successDetail.setText(successDetail[position]);
        holder.image.setImageResource(image[position]);


    }

    @Override
    public int getItemCount() {
        return successDetail.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView successDetail,successHead;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            successDetail = (TextView) itemView.findViewById(R.id.success_det);
            successHead= (TextView) itemView.findViewById(R.id.success);
            image = (ImageView) itemView.findViewById(R.id.success_image);
        }
    }
}
