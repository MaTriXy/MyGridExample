package com.elkriefy.apps.android.mygridexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleViewHolders> {
    private List<String> itemList;
    private Context context;

    public SampleRecyclerViewAdapter(Context context,
                                     List<String> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SampleViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stam_item, null);
        // work here if you need to control height of your items
        // keep in mind that parent is RecyclerView in this case
//        int height = parent.getMeasuredHeight() / 4;
//        layoutView.setMinimumHeight(height);

        SampleViewHolders rcv = new SampleViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SampleViewHolders holder, int position) {
        holder.position.setText("" + position);
        if (position==0)
        {

        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}