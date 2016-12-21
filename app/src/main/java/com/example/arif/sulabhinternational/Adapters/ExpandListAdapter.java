package com.example.arif.sulabhinternational.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arif.sulabhinternational.Activities.MainActivity;
import com.example.arif.sulabhinternational.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Arif on 06/12/16.
 */

public class ExpandListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> mDataHeader;
    private HashMap<String, List<String>> mDataChild;
    private ExpandableListView expandList;

    public ExpandListAdapter(Context context, List<String> mDataHeader, HashMap<String, List<String>> mDataChild) {
        this.context = context;
        this.mDataHeader = mDataHeader;
        this.mDataChild = mDataChild;
    }

    @Override
    public int getGroupCount() {

        return mDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mDataChild.get(this.mDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return this.mDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.mDataChild.get(
                this.mDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String header = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.head, null);
            }
        TextView txtHead = (TextView) convertView.findViewById(R.id.menu);
        ImageView icon = (ImageView) convertView.findViewById(R.id.iconimage);
        txtHead.setText(header);
        icon.setImageResource(MainActivity.icon[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_submenu, null);

        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.submenu);

        txtListChild.setText(childText);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
