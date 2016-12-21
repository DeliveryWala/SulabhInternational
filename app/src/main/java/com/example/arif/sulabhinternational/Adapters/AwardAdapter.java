package com.example.arif.sulabhinternational.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arif.sulabhinternational.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

/**
 * Created by Arif on 12/12/16.
 */

public class AwardAdapter extends RecyclerView.Adapter<AwardAdapter.MyViewHolder> {
    private String[] award_no, award_det, award_date;
    private Context context;

    public AwardAdapter(Context context, String[] award_no,String[] award_det, String[] award_date) {
        this.context = context;
        this.award_no = award_no;
        this.award_det = award_det;
        this.award_date = award_date;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.award_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.awardNo.setText(award_no[position]);
        holder.awardDetail.setText(award_det[position]);
        holder.awardDate.setText(award_date[position]);

    }

    @Override
    public int getItemCount() {
        return award_det.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView awardNo, awardDetail,awardDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            awardNo = (TextView) itemView.findViewById(R.id.awardno);
            awardDetail = (TextView) itemView.findViewById(R.id.awardet);
            awardDate = (TextView) itemView.findViewById(R.id.awardate);

        }
    }
}
