package com.example.arif.sulabhinternational.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arif.sulabhinternational.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.List;

/**
 * Created by Arif on 12/12/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private String[] news_head, news_det, news;
    private Context context;

    public NewsAdapter(Context context, String[] news_head,String[] news_det, String[] news) {
        this.context = context;
        this.news_head = news_head;
        this.news_det = news_det;
        this.news = news;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_expand, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.newsHead.setText(news_head[position]);
        holder.newsDet.setText(news_det[position]);
        holder.news.setText(news[position]);

    }

    @Override
    public int getItemCount() {
        return news.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView newsHead, newsDet;
        ExpandableTextView news;

        public MyViewHolder(View itemView) {
            super(itemView);
            newsHead = (TextView) itemView.findViewById(R.id.news_head);
            newsDet = (TextView) itemView.findViewById(R.id.news_det);
            news = (ExpandableTextView) itemView.findViewById(R.id.expand_text_view);

        }
    }
}
