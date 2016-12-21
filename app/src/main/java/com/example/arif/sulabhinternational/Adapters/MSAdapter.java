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
 * Created by Arif on 14/12/16.
 */

public class MSAdapter extends RecyclerView.Adapter<MSAdapter.MyViewHolder> {
    private String[] ms_name, ms_des,ms_thought;
    private int[] dp;
    private Context context;

    public MSAdapter(Context context, int[] dp, String[] ms_name, String[] ms_thought,String[] ms_des) {
        this.context = context;
        this.ms_name = ms_name;
        this.ms_des = ms_des;
        this.dp = dp;
        this.ms_thought=ms_thought;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ms_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ms_name.setText(ms_name[position]);
        holder.ms_thought.setText(ms_thought[position]);
        holder.ms_des.setText(ms_des[position]);
        holder.ms_dp.setImageResource(dp[position]);

    }

    @Override
    public int getItemCount() {
        return ms_name.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ms_name,ms_thought;
        ImageView ms_dp;
        ExpandableTextView ms_des;

        public MyViewHolder(View itemView) {
            super(itemView);
            ms_name = (TextView) itemView.findViewById(R.id.ms_name);
            ms_thought= (TextView) itemView.findViewById(R.id.ms_thought);
            ms_dp = (ImageView) itemView.findViewById(R.id.ms_dp);
            ms_des = (ExpandableTextView) itemView.findViewById(R.id.ms_expand);

        }
    }
}
