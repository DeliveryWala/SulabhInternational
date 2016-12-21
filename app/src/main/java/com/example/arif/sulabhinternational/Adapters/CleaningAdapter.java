package com.example.arif.sulabhinternational.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arif.sulabhinternational.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by Arif on 15/12/16.
 */

public class CleaningAdapter extends RecyclerView.Adapter<CleaningAdapter.MyViewHolder> {
    private String[] cleanHead, cleanDetail, cleanInfo;
    private int[] image;
    private Context context;

    public CleaningAdapter(Context context, int[] image, String[] cleanHead, String[] cleanInfo, String[] cleanDetail) {
        this.context = context;
        this.image = image;
        this.cleanHead = cleanHead;
        this.cleanDetail = cleanDetail;
        this.cleanInfo = cleanInfo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clean_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.cleanHead.setText(cleanHead[position]);
        holder.cleanInfo.setText(cleanInfo[position]);
        holder.cleanDetail.setText(cleanDetail[position]);
        holder.image.setImageResource(image[position]);


    }

    @Override
    public int getItemCount() {
        return cleanHead.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ExpandableTextView cleanDetail;
        TextView cleanHead, cleanInfo;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            cleanDetail = (ExpandableTextView) itemView.findViewById(R.id.expand_clean);
            cleanInfo = (TextView) itemView.findViewById(R.id.info_clean);
            cleanHead = (TextView) itemView.findViewById(R.id.head_clean);
            image = (ImageView) itemView.findViewById(R.id.clean_image);
        }
    }
}

